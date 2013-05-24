package pt.ulht.es.cookbook.domain;

import pt.ist.fenixframework.FenixFramework;

public class CookBookManager extends CookBookManager_Base {

	public static CookBookManager getInstance() {
		return FenixFramework.getRoot();
	}
}