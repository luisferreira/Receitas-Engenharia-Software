package pt.ulht.es.cookbook.domain;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public class RecipeVersion extends RecipeVersion_Base implements Comparable<RecipeVersion>{
    
    public  RecipeVersion(String recipetitle, String recipeProblemDescription, String recipeSolutionDescription, String recipeAuthor) {
    	setTitle(recipetitle);
    	setProblem(recipeProblemDescription);
    	setSolution(recipeSolutionDescription);
    	setAuthor(recipeAuthor);
    	setCreationTimestamp(new DateTime());    	
    }
    
	public int compareTo(RecipeVersion o) {
		return -getCreationTimestamp().compareTo(o.getCreationTimestamp());
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