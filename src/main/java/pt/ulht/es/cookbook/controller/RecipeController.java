package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
import pt.ulht.es.cookbook.domain.SearchResults;

@Controller
public class RecipeController {
	
	/************* ROOT *************/
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
	
	/************* SHOW ROUTES *************/
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
			
			try {				
				if ((Boolean) model.asMap().get("creation")){
					model.addAttribute("creationMessage", "creation");
				} 
			} catch (Exception e) {}
			
			try {				
				if ((Boolean) model.asMap().get("update")){
					model.addAttribute("creationMessage", "update");
				}
			} catch (Exception e) {}
			return "showRecipeDetail";
		} else {
			model.addAttribute("title", "[CookBook] - Recipe not found");
			return "recipeNotFound";
		}
	}
	
	/**
	 * Shows a specific recipe version
	 * @param model
	 * @param id
	 * @return recipe detail view
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}/version/{idv}")
	public String showRecipeVersion(Model model, @PathVariable String id, @PathVariable String idv) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);

		RecipeVersion version = recipe.getVersion(idv);
				
		if (recipe != null && version != null) {
			model.addAttribute("title", "[CookBook] - " + version.getTitle() + " [" + version.getCreationTimestamp() +"]");
			model.addAttribute("recipe", recipe);
			model.addAttribute("version", version);
			try {
				if ((Boolean) model.asMap().get("creation")){
					model.addAttribute("creationMessage", "creation");
				} else if ((Boolean) model.asMap().get("update")){
					model.addAttribute("creationMessage", "update");
				}
			} catch (Exception e) {
				System.out.println("ERROR: " + e.getLocalizedMessage());
			}
			return "showRecipeVersionDetail";
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
				model.addAttribute("deletionMessage", "deleted");
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getLocalizedMessage());
		} 
		
		return "listRecipes";
	}
	
	/************* DELETE ROUTES *************//**
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
		
		attr.addFlashAttribute("deletionMessage", "deleted");
		
		return "redirect:/recipe/all";
	}
	
	/************* EDIT ROUTES *************//**
	 * Shows recipe edit form
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}/edit")
	public String showEditRecipe(Model model, @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		
		//Necessário ajustar o destino
		model.addAttribute("recipe", recipe);
		
		return "editRecipe";
	}

	/**
	 * Restores a recipe version
	 * @param params
	 * @param attr
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/recipe/{id}/edit")
	public String editRecipe(@RequestParam Map<String, String> params, RedirectAttributes attr,  @PathVariable String id) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		String recipetitle = params.get("recipetitle");
		String recipeProblemDescription = params.get("recipeProblemDescription");
		String recipeSolutionDescription = params.get("recipeSolutionDescription");
		String recipeAuthor = params.get("recipeAuthor");
		String tags = params.get("recipeTags");
		RecipeVersion version = new RecipeVersion(recipetitle, recipeProblemDescription,recipeSolutionDescription, recipeAuthor, tags);
		
		recipe.addRecipeVersion(version);
		
		attr.addFlashAttribute("update", true);

		return "redirect:/recipe/" + id;
	}
	
	/**
	 * Restores a recipe version
	 * @param params
	 * @param attr
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/recipe/{id}/version/{idv}/restore")
	public String restoreRecipeVersion(@RequestParam Map<String, String> params, RedirectAttributes attr,  @PathVariable String id, @PathVariable String idv) {
		Recipe recipe = AbstractDomainObject.fromExternalId(id);
		RecipeVersion version = recipe.getVersion(idv);
		RecipeVersion newVersion = new RecipeVersion(version.getTitle(), version.getProblem(), version.getSolution(), version.getAuthor(), version.getTagsAsStrings());
		
		recipe.addRecipeVersion(newVersion);
		
		attr.addFlashAttribute("update", true);

		return "redirect:/recipe/" + id;
	}

	/************* CREATION ROUTES *************//**
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
		Recipe recipe = new Recipe(recipetitle, recipeProblemDescription, recipeSolutionDescription, recipeAuthor, tags);
		
		attr.addFlashAttribute("creation", true);

		return "redirect:/recipe/" + recipe.getExternalId();
	}
	
	/**************   
	 * SEARCH ROUTES 
	 * ************/
	
	@RequestMapping (method = RequestMethod.GET, value = "/recipe/search")
	public String searchRecipes(Model model) {
		model.addAttribute("title", "[CookBook] - Search");
		attr.addFlashAttribute("direct", "direct");
		return "searchResults";
	}
	
	
	/**
	 * Shows the search results
	 * @param model
	 * @param query
	 * @return
	 */	
	@RequestMapping (method = RequestMethod.POST, value = "/recipe/search")
	public String searchRecipes(Model model, @RequestParam("param") String query) {
		String[] searchParams = query.split(",");
		
		ArrayList<SearchResults> results = new ArrayList<SearchResults>();
		
		// title
		for(String srchStr : searchParams){
			// title
			for (Recipe r : CookBookManager.getOrderedRecipes()) {
				System.out.println("r title: " + r.getLastVersion().getTitle().toLowerCase() + "\nMatching : " + srchStr.trim().toLowerCase());
				if (r.getLastVersion().getTitle().toLowerCase().contains(srchStr.trim().toLowerCase())){
					results.add(new SearchResults(srchStr, "title", r));
				}
			}
			
			// problem
			for (Recipe r : CookBookManager.getOrderedRecipes()) {
				if (r.getLastVersion().getProblem().toLowerCase().contains(srchStr.trim().toLowerCase())){
					boolean existing = false;
					for(SearchResults sr : results) {
						if (sr.getRecipe().equals(r) && sr.getTerm().equals(srchStr)){
							sr.addMatchField("problem");
							existing = true;
						}
					}
					if (!existing) {
						results.add(new SearchResults(srchStr, "problem", r));
					}
				}
			}
			
			// solution
			for (Recipe r : CookBookManager.getOrderedRecipes()) {
				if (r.getLastVersion().getSolution().toLowerCase().contains(srchStr.trim().toLowerCase())){
					boolean existing = false;
					for(SearchResults sr : results) {
						if (sr.getRecipe().equals(r) && sr.getTerm().equals(srchStr)){
							sr.addMatchField("solution");
							existing = true;
						}
					}
					if (!existing)
						results.add(new SearchResults(srchStr, "solution", r));
				}
			}
			
			// Author
			for (Recipe r : CookBookManager.getOrderedRecipes()) {
				if (r.getLastVersion().getAuthor().toLowerCase().contains(srchStr.trim().toLowerCase())){
					boolean existing = false;
					for(SearchResults sr : results) {
						if (sr.getRecipe().equals(r) && sr.getTerm().equals(srchStr)){
							sr.addMatchField("author");
							existing = true;
						}
					}
					if (!existing)
						results.add(new SearchResults(srchStr, "author", r));
				}
			}
			
			// Tags
			for (Recipe r : CookBookManager.getOrderedRecipes()) {
				if (r.getLastVersion().getTagsAsStrings().toLowerCase().contains(srchStr.trim().toLowerCase())){
					boolean existing = false;
					for(SearchResults sr : results) {
						if (sr.getRecipe().equals(r) && sr.getTerm().equals(srchStr)){
							sr.addMatchField("tags");
							existing = true;
						}
					}
					if (!existing)
						results.add(new SearchResults(srchStr, "tags", r));
				}
			}
		}
		
		HashMap<String, List<SearchResults>> searchResults = new HashMap<String, List<SearchResults>>();
		
		HashMap<String, SearchResults> fml = new HashMap<String, SearchResults>();
		for(SearchResults res : results){
			if (fml.containsKey(res.getRecipe().getExternalId())){
				SearchResults sr = fml.get(res.getRecipe().getExternalId());
				
				// terms
				res.setTerm(res.getTerm() + ", " + sr.getTerm());
				
				// matches
				for(String mf : sr.matchFields()){
					if (!res.getMatch().toLowerCase().contains(mf.toLowerCase().trim()))
						res.addMatchField(mf.toLowerCase().trim());
				}
				
				fml.put(res.getRecipe().getExternalId(), res);
				
			} else
				fml.put(res.getRecipe().getExternalId(), res);
		}
		
		List<SearchResults> top = new ArrayList<SearchResults>(fml.values());
		Collections.sort(top);
		int max = top.size();
		searchResults.put("topThree", top.subList(0, (max >= 3 ? 3 : max)));
		
		for(String srchStr : searchParams) {
			ArrayList<SearchResults> matchedResults = new ArrayList<SearchResults>();
			for(SearchResults sr : results) {
				if (sr.getTerm().toLowerCase().trim().equals(srchStr.toLowerCase().trim()))
					matchedResults.add(sr);
			}
			if (matchedResults.size() > 0) {
				searchResults.put(srchStr, matchedResults);
			}
		}
		
		model.addAttribute("title", "[CookBook] - Search results");
		model.addAttribute("searchQuery", StringUtils.join(searchParams,", "));
		model.addAttribute("results", searchResults);
		
		return "searchResults";
	}
}
