package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CookbookController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String showHomePage(Model model) {

		Date date = new Date(System.currentTimeMillis());
		DateFormat df = DateFormat.getDateInstance();
		model.addAttribute("currentTime", df.format(date));
		model.addAttribute("title", "Cookbook");
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recipes/create")
	public String showRecipeCreationForm(Model model) {
		model.addAttribute("currentTime",
				new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm")
						.format(new Date(System.currentTimeMillis())));
		model.addAttribute("title", "Cookbook");
		return "newrecipe";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recipes/list")
	public String showListRecipe(Model model) {
		model.addAttribute("currentTime",
				new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm")
						.format(new Date(System.currentTimeMillis())));
		model.addAttribute("title", "Cookbook");
		return "listrecipes";
	}
}
