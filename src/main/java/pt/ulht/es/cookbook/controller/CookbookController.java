package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CookbookController {

	/*Go to Home*/
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String showHomePage(Model model) {
		
		Date date = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateInstance();
		model.addAttribute("currentTime", df.format(date));
		model.addAttribute("title", "Cookbook");		
		return "home";
	}
	
	/*Go to newrecipe form*/
	@RequestMapping(method = RequestMethod.GET, value = "/recipes/create")
	public String showRecipeCreationForm(Model model) {
		
		Date date = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateInstance();
		model.addAttribute("currentTime", df.format(date));
		model.addAttribute("title", "Cookbook");		
		return "newrecipe";
	}
}