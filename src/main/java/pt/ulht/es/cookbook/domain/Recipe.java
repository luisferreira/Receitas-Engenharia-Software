package pt.ulht.es.cookbook.domain;

import org.joda.time.DateTime;

public class Recipe extends Recipe_Base implements Comparable<Recipe>{

	public Recipe(String recipeTitle,String recipeProblemDescription, String recipeSolutionDescription,String recipeAuthor, String tags) {
		setRecipeTitle(recipeTitle);
		setRecipeAuthor(recipeAuthor);
		setRecipeSolutionDescription(recipeSolutionDescription);
		setRecipeProblemDescription(recipeProblemDescription);
		setCreationDate(new DateTime());
		setTags(tags);
		setCookbookManager(CookBookManager.getInstance());
	}

	public int compareTo(Recipe o) {
		// TODO Auto-generated method stub
		return getRecipeTitle().toLowerCase().compareTo(o.getRecipeTitle());
	}
	
	
}