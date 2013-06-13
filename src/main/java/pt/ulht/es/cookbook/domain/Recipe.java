package pt.ulht.es.cookbook.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Recipe extends Recipe_Base implements Comparable<Recipe>{
    
    public Recipe(String recipetitle, String recipeProblemDescription, String recipeSolutionDescription, String recipeAuthor) {
    	RecipeVersion version = new RecipeVersion(recipetitle, recipeProblemDescription, recipeSolutionDescription, recipeAuthor);
    	addRecipeVersion(version);
    	setCookbookManager(CookBookManager.getInstance());
    }
    
    public Recipe(String recipetitle, String recipeProblemDescription, String recipeSolutionDescription, String recipeAuthor, String Tags) {
    	RecipeVersion version = new RecipeVersion(recipetitle, recipeProblemDescription, recipeSolutionDescription, recipeAuthor);
    	addRecipeVersion(version);
    	setCookbookManager(CookBookManager.getInstance());
    }
    
    public RecipeVersion getLastVersion(){
    	List<RecipeVersion> list = new ArrayList<RecipeVersion>(getRecipeVersionSet());
    	Collections.sort(list);
    	return list.get(list.size()-1);
    }

	public int compareTo(Recipe o) {
		return getLastVersion().getTitle().toLowerCase().compareTo(o.getLastVersion().getTitle().toLowerCase());
	}

	public void delete(Recipe recipe) {
		removeCookbookManager();
		
		for (RecipeVersion version : recipe.getRecipeVersion()) {
			version.delete();
		}
		
		super.deleteDomainObject();
	} 	
	
	public RecipeVersion getVersion(String id){
		RecipeVersion version = null;
		for(RecipeVersion v : this.getRecipeVersionSet()){
			if (v.getExternalId().equals(id)){
				version = v;
				break;
			}				
		}
		return version;
	}
}