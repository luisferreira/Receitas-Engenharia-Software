package pt.ulht.es.cookbook.domain;

public class Tag extends Tag_Base {
    
    public  Tag() {
        super();
    }

	public static Tag fromString(String token) {
		for (Tag t : CookBookManager.getInstance().getTagSet()){
			if (t.getTag().equalsIgnoreCase(token))
				return t;
		}
		Tag t = new Tag();
		t.setTag(token);
		return t;
	}
    
}
