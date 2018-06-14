package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	AuthService ls;

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String index(@ModelAttribute("login") Login login, Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("login") Login login, Model model) {
		String id =login.getAdmin_id();
		String pass =login.getPassword();

		Login l = AuthService.Admin_name(id, pass);
		if(l == null) {
			return "login";
		}else {

			return "menu";
		}

	}
}
