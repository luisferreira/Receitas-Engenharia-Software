package pt.ulht.es.cookbook.controller;

import java.util.Collection;
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
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/recipes/list")
	public String listrecipes (Model model) {
		Collection<Recipe> recipes = CookBookManager.getRecipes();
		model.addAttribute("recipes", recipes);
		return "listrecipes";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/recipes")
	public String createRecipe(@RequestParam Map<String, String> params) {

		String recipetitle = params.get("recipetitle");
		String recipeProblemDescription = params.get("recipeProblemDescription");
		String recipeSolutionDescription = params.get("recipeSolutionDescription");
		String recipeAuthor = params.get("recipeAuthor");
		Recipe recipe = new Recipe(recipetitle, recipeProblemDescription,recipeSolutionDescription, recipeAuthor);CookBookManager.saveRecipe(recipe);
		
		return "redirect:/recipes/" + recipe.getid();
	}

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
}
