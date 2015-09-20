package com.dk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index(Model model) {
		return new ModelAndView("index");
	}

	@RequestMapping("/index")
	public ModelAndView getIndex(Model model) {
		return new ModelAndView("index");
	}

}
