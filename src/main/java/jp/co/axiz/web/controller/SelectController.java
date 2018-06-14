package jp.co.axiz.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.SelectServise;

@Controller
public class SelectController {

	@Autowired
	SelectServise ss;

	@RequestMapping(value="/select", method =RequestMethod.GET)
	public String select(@ModelAttribute("loginForm") User form, Model model) {
		return "select";
	}

	@RequestMapping(value="/list", method =RequestMethod.POST)
	public String list(@ModelAttribute("selectForm") User form, Model model) {
		List<User> list = new ArrayList<User>();
		list = ss.find(form);
		model.addAttribute("userList", list);
		return "selectResult";
	}
}