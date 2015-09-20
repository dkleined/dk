package com.dk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dk.service.PictureService;

@Controller
public class GalleryController {

	PictureService pictureService;

	@Autowired(required = true)
	@Qualifier(value = "pictureService")
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@RequestMapping("/gallery")
	public ModelAndView galleryx() {
		ModelAndView model = new ModelAndView("gallery");
		model.addObject("pictures", pictureService.getPictures());
		System.out.println(pictureService.getPictures().size());
		return model;
	}

}
