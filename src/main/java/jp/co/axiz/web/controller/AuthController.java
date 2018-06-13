package jp.co.axiz.web.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	private AuthService loginService;

	@RequestMapping("/list")
	public String list(Model model) {
		List<Login> list = AuthService.findAll();
		model.addAttribute("userlist", list);

		return "list";
	}

	@RequestMapping("/index")
	public String index (Model model) {

			return "index";
	}

	@RequestMapping("/login")
	public String login (@ModelAttribute("login") Login form, Model model) {

			return "login";
	}

	@RequestMapping("/test")
	public String test (Model model) {

			return "index_mvc";
	}

	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String menu (Model model) {

		return "menu";
	}

	@RequestMapping(value="/menu", method=RequestMethod.POST)
	public String loginCheck (@Validated @ModelAttribute("login") Login form,
			BindingResult bindingResult, HttpSession session, Model model) {

		if (bindingResult.hasErrors()) {
			return "login";
		}

		jp.co.axiz.web.entity.User ad = loginService.getAdmin_name(form.getAdmin_id(), form.getPassword());

		if (ad == null) {
			model.addAttribute("msg", "IDまたはPASSが間違っています");
			return "login";
		}
		session.setAttribute("Admin_name", ad.getUser_name());

		return "menu";
	}


}