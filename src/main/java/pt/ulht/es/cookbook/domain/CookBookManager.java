package pt.ulht.es.cookbook.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.ist.fenixframework.FenixFramework;

public class CookBookManager extends CookBookManager_Base {
    
    public static CookBookManager getInstance() {
        return FenixFramework.getRoot();
    }
    
	public static List<Recipe> getOrderedRecipes() {
		ArrayList<Recipe> allRecipes = new ArrayList<Recipe>();

		for (Recipe recipe : getInstance().getRecipeSet()) {
			allRecipes.add(recipe);
		}
			
		return allRecipes;
	}

	public static List<Recipe> getLastFiveRecipes() {
		ArrayList<Recipe> allRecipes = new ArrayList<Recipe>(getInstance().getRecipeSet());

		Collections.sort(allRecipes);
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

