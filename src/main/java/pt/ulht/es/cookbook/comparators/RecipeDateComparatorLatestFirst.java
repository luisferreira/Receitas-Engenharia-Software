package pt.ulht.es.cookbook.comparators;

import java.util.Comparator;

import pt.ulht.es.cookbook.domain.Recipe;

public class RecipeDateComparatorLatestFirst implements Comparator<Recipe>{
    public int compare(Recipe p, Recipe q) {
        if (p.getCreationTimestamp().isBefore(q.getCreationTimestamp())) {
            return 1;
        } else if (p.getCreationTimestamp().isAfter(q.getCreationTimestamp())) {
            return -1;
        } else {
            return 0;
        }        
    }
}
