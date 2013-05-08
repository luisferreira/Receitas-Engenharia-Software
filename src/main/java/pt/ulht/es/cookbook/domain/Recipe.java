package pt.ulht.es.cookbook.domain;

import java.util.Date;

public class Recipe extends Recipe_Base{

	private String recipeTitle;
	private String recipeProblemDescription;
	private String recipeSolutionDescription;
	private String recipeAuthor;
	private String id;
	private Date creationDate;
	private int recipeVersion;

	public Recipe(String recipetitle, String recipeProblemDescription,String recipeSolutionDescription, String recipeAuthor) {
		this.recipeAuthor = recipeAuthor;
		this.recipeProblemDescription = recipeProblemDescription;
		this.recipeSolutionDescription = recipeSolutionDescription;
		this.recipeTitle = recipetitle;
		
		java.util.Date date= new java.util.Date();
		this.creationDate = new Date();
		
		/*Necessário alterar isto quando existir controlo de versões*/
		this.recipeVersion = 1;
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

	public void setRecipeTitle(String recipetitle) {
		this.recipeTitle = recipetitle;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setCreationDate(Date creationData) {
		this.creationDate = creationData;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public int getRecipeVersion() {
		return recipeVersion;
	}
	
	public void setRecipeVersion(int recipeversion) {
		this.recipeVersion = recipeversion;
	}
}