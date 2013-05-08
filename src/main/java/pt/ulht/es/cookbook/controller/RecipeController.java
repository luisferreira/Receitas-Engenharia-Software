package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

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

	/* Create recipe and redirect to ShowRecipeDetail "/recipes/{id}" */
	@RequestMapping(method = RequestMethod.POST, value = "/recipes")
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

		return "redirect:/recipes/" + recipe.getId();
	}

	/*
	 * Show recipe from id. If recipe with id exists, redirect to
	 * showRecipeDetail
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recipes/{id}")
	public String showRecipe(Model model, @PathVariable String id) {
		Recipe recipe = CookBookManager.getRecipe(id);

		if (recipe != null) {
			model.addAttribute("recipe", recipe);
			return "showrecipedetail";
		} else {
			return "recipeNotFound";
		}

	}

	/* Show list of recipes */
	@RequestMapping(method = RequestMethod.GET, value = "/recipes/list")
	public String showAllRecipes(Model model) {
		model.addAttribute("recipes", CookBookManager.getRecipes());

		return "listrecipes";
	}

	/* show home page */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String showHomePage(Model model) {

		Date date = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateInstance();
		model.addAttribute("currentTime", df.format(date));
		model.addAttribute("title", "Cookbook");

		/* For fill table os last recipes added on show home page */
		model.addAttribute("recipes", CookBookManager.getRecipes());

		return "home";
	}

	/* Show new recipe form */
	@RequestMapping(method = RequestMethod.GET, value = "/recipes/create")
	public String showRecipeCreationForm(Model model) {
		model.addAttribute("currentTime",
				new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm")
						.format(new Date(System.currentTimeMillis())));
		model.addAttribute("title", "Cookbook");

		return "newrecipe";
	}

	/* Show recipe after crate */
	@RequestMapping(method = RequestMethod.POST, value = "recipes/list")
	public String listrecipes(Model model) {
		Collection<Recipe> recipes = CookBookManager.getRecipes();
		model.addAttribute("recipes", recipes);

		return "listrecipes";
	}
}
