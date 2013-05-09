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

import pt.ulht.es.cookbook.domain.CookBookManager;
import pt.ulht.es.cookbook.domain.Recipe;

@Controller
public class RecipeController {

	/*
	 * Show recipe from id. If recipe with id exists, redirect to
	 * showRecipeDetail
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}")
	public String showRecipe(Model model, @PathVariable String id) {
		Recipe recipe = CookBookManager.getRecipe(id);
		
		if (recipe != null) {
			model.addAttribute("title", "[CookBook] - " + recipe.getRecipeTitle());
			model.addAttribute("recipe", recipe);
			return "showRecipeDetail";
		} else {
			model.addAttribute("title", "[CookBook] - Recipe not found");
			return "recipeNotFound";
		}

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
	public String createRecipe(@RequestParam Map<String, String> params) {

		String recipetitle = params.get("recipetitle");
		String recipeProblemDescription = params
				.get("recipeProblemDescription");
		String recipeSolutionDescription = params
				.get("recipeSolutionDescription");
		String recipeAuthor = params.get("recipeAuthor");
		Recipe recipe = new Recipe(recipetitle, recipeProblemDescription,
				recipeSolutionDescription, recipeAuthor);
		CookBookManager.saveRecipe(recipe);

		return "redirect:/recipe/" + recipe.getId();
	}
	
	/* simple search for recipe title */
	@RequestMapping (method = RequestMethod.POST, value = "/recipe/search")
	public String searchRecipes(Model model, @RequestParam("param") String query) {

	String[] searchParams = query.split(",| ");

	List<Recipe> resultSet = new ArrayList<Recipe>();
	for (Recipe recipe : CookBookManager.getRecipes()) {
		if (recipe.match(searchParams)) {
			resultSet.add(recipe);
		}
	}

	model.addAttribute("searchQuery", StringUtils.join(searchParams,", "));
	model.addAttribute("recipes", resultSet);

	return "searchRecipe";

	}
}
