package pt.ulht.es.cookbook.domain;

import java.util.Collection;
import java.util.HashMap;
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
}
