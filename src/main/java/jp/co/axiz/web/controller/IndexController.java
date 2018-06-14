package jp.co.axiz.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {



	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index(Model model) {

		return "index";
	}

	@RequestMapping(value = "/menu", method=RequestMethod.GET)
	public String menu(Model model) {


		return "menu";
	}

	public void loginmenu(@RequestParam("id") String id,
			@RequestParam("pass") String pass,
			Model model) {


		model.addAttribute("id", id);
		model.addAttribute("pass", pass);
	}
}
