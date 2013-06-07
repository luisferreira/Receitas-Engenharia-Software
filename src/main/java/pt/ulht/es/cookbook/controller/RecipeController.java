package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.cookbook.domain.CookBookManager;
import pt.ulht.es.cookbook.domain.Recipe;
import pt.ulht.es.cookbook.domain.RecipeVersion;
import pt.ulht.es.cookbook.domain.Tag;

@Controller
public class RecipeController {
	
	/*************
	 *   ROOT
	 *************/
	

	/**
	 * Shows the home page
	 * @param model
	 * @return home view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String showHomePage(Model model) {

		Date date = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateInstance();
		model.addAttribute("currentTime", df.format(date));
		model.addAttribute("title", "[Cookbook] - Home");

		/* For fill table of last recipes added on show home page */
		model.addAttribute("recipes", CookBookManager.getLastFiveRecipes());
        return "home";
	}
	
	
	/*************
	 *   SHOW ROUTES
	 *************/

	/**
	 * Shows a specific recipe
	 * @param model
	 * @param id
	 * @return recipe detail view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}")
	public String showRecipe(Model model, @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		
		if (recipe != null) {
			model.addAttribute("title", "[CookBook] - " + recipe.getLastVersion().getTitle());
			model.addAttribute("recipe", recipe);
			model.addAttribute("versions", recipe.getRecipeVersionSet());
			model.addAttribute("tags", recipe.getLastVersion().getTagSet());
			try {
				if ((Boolean) model.asMap().get("creation")){
					model.addAttribute("creationMessage", "creation");
				} else if ((Boolean) model.asMap().get("update")){
					model.addAttribute("creationMessage", "update");
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
			return "showRecipeDetail";
		} else {
			model.addAttribute("title", "[CookBook] - Recipe not found");
			return "recipeNotFound";
		}
	}
	
	/**
	 * Shows a list of all recipes
	 * @param model
	 * @return all recipes view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/all")
	public String showAllRecipes(Model model) {
		model.addAttribute("recipes", CookBookManager.getOrderedRecipes());
		model.addAttribute("title", "[CookBook] - All recipes");
		
		try {
			if ((Boolean) model.asMap().get("delete")){
				model.addAttribute("deleteonMessage", "deleted");
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} 
		
		return "listRecipes";
	}
	
	
	
	
	/*************
	 *   DELETE ROUTES
	 *************/

	/**
	 * Deletes a recipe and all versions
	 * @param model
	 * @param id
	 * @param attr
	 * @return 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}/delete")
	public String deleteRecipe(Model model, @PathVariable String id, RedirectAttributes attr) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		
		recipe.delete(recipe);
		
		attr.addFlashAttribute("delete", true);
		
		return "redirect:/recipe/all";
	}
	
	
	
	/*************
	 *   EDIT ROUTES
	 *************/
	
	/**
	 * Shows recipe edit form
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}/edit")
	public String editRecipe(Model model, @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		
		//Necessário ajustar o destino
		model.addAttribute("recipe", recipe);
		
		return "editRecipe";
	}

	/**
	 * Edits a recipe version
	 * @param params
	 * @param attr
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/recipe/{id}/edit")
	public String EditRecipe(@RequestParam Map<String, String> params, RedirectAttributes attr,  @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		String recipetitle = params.get("recipetitle");
		String recipeProblemDescription = params.get("recipeProblemDescription");
		String recipeSolutionDescription = params.get("recipeSolutionDescription");
		String recipeAuthor = params.get("recipeAuthor");
		RecipeVersion version = new RecipeVersion(recipetitle, recipeProblemDescription,recipeSolutionDescription, recipeAuthor);
		
		recipe.addRecipeVersion(version);
		
		attr.addFlashAttribute("update", true);

		return "redirect:/recipe/" + id;
	}
	

	/*************
	 *   CREATION ROUTES
	 *************/

	/**
	 * Show recipe creation form
	 * @param model
	 * @return recipe creation form
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/create")
	public String showRecipeCreationForm(Model model) {
		model.addAttribute("title", "[CookBook] - Create new recipe");
		return "newRecipe";
	}
	
	/**
	 * Creates and persists a recipe
	 * @param params
	 * @param attr
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/recipe/create")
	public String createRecipe(@RequestParam Map<String, String> params, RedirectAttributes attr) {
		String recipetitle = params.get("recipetitle");
		String recipeProblemDescription = params.get("recipeProblemDescription");
		String recipeSolutionDescription = params.get("recipeSolutionDescription");
		String recipeAuthor = params.get("recipeAuthor");
		String tags = params.get("recipeTags");
		String[] tokens = tags.split(", ");
		
		
		Recipe recipe = new Recipe(recipetitle, recipeProblemDescription, recipeSolutionDescription, recipeAuthor);
		RecipeVersion version = recipe.getLastVersion();
		for(String token : tokens){
			version.addTag(Tag.fromString(token));
		}
		
		attr.addFlashAttribute("creation", true);

		return "redirect:/recipe/" + recipe.getExternalId();
	}
	
	
	/*************
	 *   SEARCH ROUTES
	 *************/
	
	/**
	 * Shows the search results
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping (method = RequestMethod.POST, value = "/recipe/search")
	public String searchRecipes(Model model, @RequestParam("param") String query) {
		String[] searchParams = query.split(",| ");
		List<Recipe> resultSet = new ArrayList<Recipe>();
			
		//itera todas as recipes
		for (Recipe recipe : CookBookManager.getOrderedRecipes()) {
			
			Recipe recipe1 = recipe;
			
			//itera todas as keywords de pesquisa
			for (int i=0; i< searchParams.length;i++){				
				if (recipe1.getLastVersion().getTitle().toLowerCase().trim().contains(searchParams[i].toString().toLowerCase().trim())){
					resultSet.add(recipe);
				}
			}				
		}
		model.addAttribute("searchQuery", StringUtils.join(searchParams,", "));
		model.addAttribute("recipes", resultSet);

		return "searchRecipe";
	}
}
