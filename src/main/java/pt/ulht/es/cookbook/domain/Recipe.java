package pt.ulht.es.cookbook.domain;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public class Recipe extends Recipe_Base implements Comparable<Recipe>{
    
    public  Recipe(String recipetitle, String recipeProblemDescription, String recipeSolutionDescription, String recipeAuthor) {
    	setTitle(recipetitle);
    	setProblem(recipeProblemDescription);
    	setSolution(recipeSolutionDescription);
    	setAuthor(recipeAuthor);
    	setCreationTimestamp(new DateTime());    	
    	setCookbookManager(CookBookManager.getInstance());
    }
    
	public int compareTo(Recipe o) {
		return this.getTitle().toLowerCase().compareTo(o.getTitle().toLowerCase());
	}
		
	public boolean match(String[] words){
		boolean found = false;
		for(String word : words){
			if (this.getTitle().toLowerCase().contains(word.toLowerCase())) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public String getFormatedCreationDate() {
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
		return format.format(getCreationTimestamp());
	}
}
