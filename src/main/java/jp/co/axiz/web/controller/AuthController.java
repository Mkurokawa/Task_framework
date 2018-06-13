package jp.co.axiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.service.AuthService;

@Controller
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@RequestMapping("/login")
	public String list(Model model) {
		List<Login> list = authService.findAll();
		model.addAttribute("loginlist", list);

		return "login";
	}

}