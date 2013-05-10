package pt.ulht.es.cookbook.domain;

import java.util.Comparator;

public class RecipeDateComparatorLatestFirst implements Comparator<Recipe>{
    public int compare(Recipe p, Recipe q) {
        if (p.getCreationDate().before(q.getCreationDate())) {
            return 1;
        } else if (p.getCreationDate().after(q.getCreationDate())) {
            return -1;
        } else {
            return 0;
        }        
    }
}
