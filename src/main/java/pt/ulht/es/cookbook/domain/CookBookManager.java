package pt.ulht.es.cookbook.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pt.ist.fenixframework.FenixFramework;
import pt.ulht.es.cookbook.domain.comparator.VersionDateComparator;

public class CookBookManager extends CookBookManager_Base {
    
    public static CookBookManager getInstance() {
        return FenixFramework.getRoot();
    }
    
	public static List<Recipe> getOrderedRecipes() {
		ArrayList<Recipe> allRecipes = new ArrayList<Recipe>();

		for (Recipe recipe : getInstance().getRecipeSet()) {
			allRecipes.add(recipe);
		}
		
		Collections.sort(allRecipes);
			
		return allRecipes;
	}

	public static List<Recipe> getLastFiveRecipes() {
		ArrayList<Recipe> allRecipes = new ArrayList<Recipe>(getInstance().getRecipeSet());
		Collections.sort(allRecipes, new VersionDateComparator());
		int collectionSize = allRecipes.size();

		if (collectionSize > 4) {
			return allRecipes.subList(0, 5);
		}
		if (collectionSize == 0) {
			return allRecipes;
		}
		return allRecipes.subList(0, collectionSize);
	}   
	
	public static String[] getAllTags(){
		ArrayList<String> tags = new ArrayList<String>();
		for (Tag t : getInstance().getTagSet()){
			tags.add(t.getTag());
		}
		String[] results = new String[tags.size()];
		results = tags.toArray(results); 
		return results;
	}
	
	public static String tagsToJSArray(){
		String tags = "[";
		for(String t : getAllTags()){
			tags += "\"" + t + "\",";
		}
		if (tags.endsWith(","))
			tags=tags.substring(0, tags.length()-1);
		tags += "]";
		
		return tags;
	}
}