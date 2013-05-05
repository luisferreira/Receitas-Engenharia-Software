package pt.ulht.es.cookbook.domain;

import java.util.Date;

public class Recipe extends Recipe_Base{

	private String recipetitle;
	private String recipeProblemDescription;
	private String recipeSolutionDescription;
	private String recipeAuthor;
	private String id;
	private long creationData;

	public Recipe(String recipetitle, String recipeProblemDescription,String recipeSolutionDescription, String recipeAuthor) {
		this.recipeAuthor = recipeAuthor;
		this.recipeProblemDescription = recipeProblemDescription;
		this.recipeSolutionDescription = recipeSolutionDescription;
		this.recipetitle = recipetitle;
		
		java.util.Date date= new java.util.Date();
		this.creationData = date.getTime();
	}

	public void setRecipeAuthor(String recipeAuthor) {
		this.recipeAuthor = recipeAuthor;
	}

	public String getRecipeAuthor() {
		return recipeAuthor;
	}

	public void setRecipeProblemDescription(String recipeProblemDescription) {
		this.recipeProblemDescription = recipeProblemDescription;
	}

	public String getRecipeProblemDescription() {
		return recipeProblemDescription;
	}

	public void setRecipeSolutionDescription(String recipeSolutionDescription) {
		this.recipeSolutionDescription = recipeSolutionDescription;
	}

	public String getRecipeSolutionDescription() {
		return recipeSolutionDescription;
	}

	public void setRecipetitle(String recipetitle) {
		this.recipetitle = recipetitle;
	}

	public String getRecipetitle() {
		return recipetitle;
	}

	public String getid() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setCreationData(long creationData) {
		this.creationData = creationData;
	}
	
	public long getCreationData() {
		return creationData;
	}
}