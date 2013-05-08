package pt.ulht.es.cookbook.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Recipe extends Recipe_Base implements Comparable<Recipe> {

	private String recipeTitle;
	private String recipeProblemDescription;
	private String recipeSolutionDescription;
	private String recipeAuthor;
	private String id;
	private Date creationDate;
	private String formatedCreationDate;
	private int recipeVersion;

	public Recipe(String recipetitle, String recipeProblemDescription,String recipeSolutionDescription, String recipeAuthor) {
		this.recipeAuthor = recipeAuthor;
		this.recipeProblemDescription = recipeProblemDescription;
		this.recipeSolutionDescription = recipeSolutionDescription;
		this.recipeTitle = recipetitle;
		
		java.util.Date date= new java.util.Date();
		this.creationDate = new Date();
		
		/*Format Data to show in interface. creationdate not reused because is actually used with date type by comparator*/
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");	
		this.formatedCreationDate = format.format(this.creationDate);
		
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

	public String getFormatedCreationDate() {
		return this.formatedCreationDate;
	}

	public int getRecipeVersion() {
		return recipeVersion;
	}

	public void setRecipeVersion(int recipeversion) {
		this.recipeVersion = recipeversion;
	}

	public int compareTo(Recipe o) {
		return this.getRecipeTitle().compareTo(o.getRecipeTitle());
	}
}