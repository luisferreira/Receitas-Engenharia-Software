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

@Controller
public class RecipeController {

	/*
	 * Show recipe from id. If recipe with id exists, redirect to
	 * showRecipeDetail
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}")
	public String showRecipe(Model model, @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		
		if (recipe != null) {
			model.addAttribute("title", "[CookBook] - " + recipe.getLastVersion().getTitle());
			model.addAttribute("recipe", recipe);
			try {
				if ((Boolean) model.asMap().get("creation")){
					model.addAttribute("creationMessage", "success");
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
			return "showRecipeDetail";
		} else {
			//TODO: se o creationMessage vem como success, mas a recipe não existe, redirect para a pagina de criação com msg de erro
			model.addAttribute("title", "[CookBook] - Recipe not found");
			return "recipeNotFound";
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}/delete")
	public String deleteRecipe(Model model, @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		
		recipe.delete(recipe);
		
		return "redirect:/recipe/all";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}/edit")
	public String editRecipe(Model model, @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		
		//Necessário ajustar o destino
		model.addAttribute("recipe", recipe);
		
		return "editRecipe";
	}

	
	/* Show list of recipes */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/all")
	public String showAllRecipes(Model model) {
		model.addAttribute("recipes", CookBookManager.getOrderedRecipes());
		model.addAttribute("title", "[CookBook] - All recipes");
		return "listRecipes";
	}

	/* show home page */
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

	/* Show new recipe form */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/create")
	public String showRecipeCreationForm(Model model) {
		model.addAttribute("title", "[CookBook] - Create new recipe");
		return "newRecipe";
	}
	
	/* Create recipe and redirect to ShowRecipeDetail "/recipes/{id}" */
	@RequestMapping(method = RequestMethod.POST, value = "/recipe/create")
	public String createRecipe(@RequestParam Map<String, String> params, RedirectAttributes attr) {
		String recipetitle = params.get("recipetitle");
		String recipeProblemDescription = params.get("recipeProblemDescription");
		String recipeSolutionDescription = params.get("recipeSolutionDescription");
		String recipeAuthor = params.get("recipeAuthor");
		Recipe recipe = new Recipe(recipetitle, recipeProblemDescription,recipeSolutionDescription, recipeAuthor);
		
		recipe.addVersion(version);
		
		attr.addFlashAttribute("creation", true);

		System.out.println("ID da Receita criada: " + recipe.getExternalId());
		return "redirect:/recipe/" + recipe.getExternalId();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/recipe/{id}/edit")
	public String EditRecipe(@RequestParam Map<String, String> params, RedirectAttributes attr,  @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		String recipetitle = params.get("recipetitle");
		String recipeProblemDescription = params.get("recipeProblemDescription");
		String recipeSolutionDescription = params.get("recipeSolutionDescription");
		String recipeAuthor = params.get("recipeAuthor");
		RecipeVersion version = new RecipeVersion(recipetitle, recipeProblemDescription,recipeSolutionDescription, recipeAuthor);
		
		recipe.
		
		attr.addFlashAttribute("creation", true);

		System.out.println("ID da Receita Alterada: " + recipe.getExternalId());
		 return "redirect:/";
	}
	
	/* simple search for recipe title */
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
