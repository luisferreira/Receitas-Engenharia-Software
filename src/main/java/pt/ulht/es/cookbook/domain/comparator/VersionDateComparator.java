package pt.ulht.es.cookbook.domain.comparator;

import java.util.Comparator;

import pt.ulht.es.cookbook.domain.Recipe;

public class VersionDateComparator implements Comparator<Recipe>{

	public int compare(Recipe rv1, Recipe rv2) {
		return rv2.getLastVersion().compareTo(rv1.getLastVersion());		
	}
	
}
