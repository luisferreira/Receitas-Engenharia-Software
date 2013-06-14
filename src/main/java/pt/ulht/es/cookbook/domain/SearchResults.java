package pt.ulht.es.cookbook.domain;

import java.util.Arrays;
import java.util.List;

public class SearchResults implements Comparable<SearchResults>{
	private String term = "";
	private String match = "";
	private Recipe recipe;
	
	
	public SearchResults(String term, String match, Recipe recipe) {
		this.term = term;
		addMatchField(match);
		this.recipe = recipe;
	}

	public String getTerm() {
		return term;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	public String getMatch() {
		return match;
	}

	public Recipe getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public String getMatchFields(){
		return this.match;
	}
	
	public String[] matchFields(){
		return match.split(",");
	}
	
	public List<String> matchFieldsList(){
		return Arrays.asList(match.split(","));
	}
	
	public void addMatchField(String field){
		if (this.match.isEmpty()) 
			this.match += field;
		else
			this.match += "," + field;
	}

	public int compareTo(SearchResults o) {
		if (this.matchFields().length > o.matchFields().length)
			return -1;
		else if (this.matchFields().length < o.matchFields().length)
			return 1;
		else return 0;
	}
	
}
