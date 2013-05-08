package pt.ulht.es.cookbook.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.ist.fenixframework.FenixFramework;


public class CookBookManager extends CookBookManager_Base{

	private static int nextRecipeId = 1;
	private static Map<String, Recipe> RECIPE_MAP = new HashMap<String, Recipe>();
	
	public static CookBookManager getInstance() {
		return FenixFramework.getRoot();
	}
	
	public static void saveRecipe(Recipe recipe) {
		String id = nextRecipeId + "";
		recipe.setId(id);
		RECIPE_MAP.put(id, recipe);
		nextRecipeId++;
	}

	public static Recipe getRecipe(String id) {
		return RECIPE_MAP.get(id);
	}

	public static Collection<Recipe> getRecipes() {
		return RECIPE_MAP.values();
	}
	
	public static List<Recipe> getOrderedRecipes() {
		ArrayList<Recipe> allRecipes = new ArrayList<Recipe>(); 
		
		for(Recipe recipe : RECIPE_MAP.values()){
			allRecipes.add(recipe);
		}
		
		Collections.sort(allRecipes);
		
		return allRecipes;
	}
	
	public static List<Recipe> getLastFiveRecipes(){
		ArrayList<Recipe> allRecipes = new ArrayList<Recipe>(); 
		
		for(Recipe recipe : RECIPE_MAP.values()){
			allRecipes.add(recipe);
		}
		Collections.sort(allRecipes, new RecipeDateComparatorLatestFirst());
		int collectionSize = allRecipes.size();
		
		if (collectionSize > 4) {
			return allRecipes.subList(0, 5);
		}
		if (collectionSize == 0) {
			return allRecipes;
		}
		return allRecipes.subList(0, collectionSize);
	}
}
