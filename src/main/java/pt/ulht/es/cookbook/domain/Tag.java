package pt.ulht.es.cookbook.domain;

public class Tag extends Tag_Base {
    
    private  Tag(String tag) {
        setTag(tag);
        setCookbookManager(CookBookManager.getInstance());
    }

	public static Tag fromString(String token) {
		for (Tag t : CookBookManager.getInstance().getTagSet()){
			if (t.getTag().equalsIgnoreCase(token))
				return t;
		}
		return new Tag(token);
	}
	
	@Override
	public String toString(){
		return getTag();
	}
    
}
