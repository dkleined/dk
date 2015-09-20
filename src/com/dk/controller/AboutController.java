package com.dk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
	
@Controller
public class AboutController {

	@RequestMapping("/about")
	public ModelAndView index() {
		return new ModelAndView("about");
	}

}
