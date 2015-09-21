package com.dk.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dk.model.Picture;
import com.dk.model.PictureData;
import com.dk.model.PictureThumb;
import com.dk.model.User;
import com.dk.service.PictureDataService;
import com.dk.service.PictureService;
import com.dk.service.PictureThumbService;
import com.dk.service.UserService;
import com.dk.utility.PictureTool;
import com.dk.utility.SessionTool;

@Controller
public class AccountController {

	private PictureService pictureService;
	private PictureDataService pictureDataService;
	private PictureThumbService pictureThumbService;
	private UserService userService;
	@Autowired
	private SessionTool sessionTool;

	public AccountController() {
		sessionTool = new SessionTool();
	}

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired(required = true)
	@Qualifier(value = "pictureService")
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@Autowired(required = true)
	@Qualifier(value = "pictureDataService")
	public void setPictureDataService(PictureDataService pictureDataService) {
		this.pictureDataService = pictureDataService;
	}

	@Autowired(required = true)
	@Qualifier(value = "pictureThumbService")
	public void setPictureThumbService(PictureThumbService pictureThumbService) {
		this.pictureThumbService = pictureThumbService;
	}

	@RequestMapping(value = "/account")
	public String listUsers(Model model) {
		System.out.println("account");
		if (sessionTool.getCurrentUser() == null) {
			model.addAttribute("user", new User());
			model.addAttribute("target", "account");
			return "login";
		} else {
			User tmpUser = userService.getUser(sessionTool.getCurrentUser().getUsername());
			model.addAttribute("user", tmpUser);
			sessionTool.setCurrentUser(tmpUser);
			model.addAttribute("uploadedPictures", pictureService.getByUsername(tmpUser));
			return "account";
		}
	}

	@RequestMapping(value = "/upload")
	public String upload(Model model) {
		System.out.println("upload");
		if (sessionTool.getCurrentUser() == null) {
			model.addAttribute("user", new User());
			model.addAttribute("target", "upload");
			return "login";
		} else {
			return "upload";
		}
	}

	@RequestMapping(value = "/buy{id}")
	public String buy(Model model, @RequestParam String id) {
		System.out.println("buy; id=" + id);
		if (sessionTool.getCurrentUser() == null) {
			model.addAttribute("user", new User());
			model.addAttribute("target", "buy");
			return "login";
		} else {
			return "buy";
		}
	}
	
	@RequestMapping(value = "/deletePicture{id}")
	public String deletePicture(Model model, @RequestParam int id) {
		Picture toDelete = pictureService.getPicture(id);
		PictureData toDeleteData = pictureDataService.getPictureData(toDelete.getId());
		PictureThumb toDeleteThumb = pictureThumbService.getPictureThumb(toDelete.getId());
		
		if(toDelete.getUsername().getUsername().equals(sessionTool.getCurrentUser().getUsername())) {
			pictureThumbService.deletePictureThumb(toDeleteThumb);
			pictureDataService.deletePictureData(toDeleteData);
			pictureService.deletePicture(toDelete);
			model.addAttribute("successMsg", "Picture successfully deleted.");
		} else {
			model.addAttribute("dangerMsg", "You lack permission to delete that picture.");
		}
		model.addAttribute("user", sessionTool.getCurrentUser());
		model.addAttribute("uploadedPictures", pictureService.getByUsername(sessionTool.getCurrentUser()));
		return "account";
	}

	@RequestMapping(value = "/account/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {
		userService.SaveOrUpdateUser(user);
		sessionTool.setCurrentUser(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam("picture") MultipartFile picture, Model model,
			@RequestParam("price") double price) throws Exception {
		ModelAndView mv = new ModelAndView("upload");
		String filename = picture.getOriginalFilename();

		String[] splitFilename = filename.split(Pattern.quote("."));
		if (!splitFilename[1].equals("jpg") && !splitFilename[1].equals("JPG")) {
			model.addAttribute("dangerMsg", "Invalid picture format; must be jpg.");
			return mv;
		}

		Picture toSave = new Picture();
		PictureData toSaveData = new PictureData();
		PictureThumb toSaveThumb = new PictureThumb();

		toSaveData.setId(toSave);
		toSaveData.setData(picture.getBytes());
		toSave.setFileName(picture.getOriginalFilename());
		toSave.setUsername(sessionTool.getCurrentUser());
		toSave.setPrice(price);

		// create the thumbnail
		// convert byte[] to image
		InputStream in = new ByteArrayInputStream(toSaveData.getData());
		BufferedImage bImageFromConvert = ImageIO.read(in);
		// scale image
		BufferedImage scaled = PictureTool.scale(bImageFromConvert, 0.05);
		// convert back to byte[]
		byte[] imageInByte;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(scaled, "jpg", baos);
		baos.flush();
		imageInByte = baos.toByteArray();
		baos.close();

		toSaveThumb.setId(toSave);
		toSaveThumb.setData(imageInByte);

		// save everything
		pictureService.SaveOrUpdatePicture(toSave);
		pictureDataService.SaveOrUpdatePictureData(toSaveData);
		pictureThumbService.SaveOrUpdatePictureThumb(toSaveThumb);

		// return a success message
		model.addAttribute("successMsg", "Image uploaded successfuly!");

		mv.addObject("successMsg", "Image uploaded successfuly!");

		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, Model model, @RequestParam("target") String target) {

		User tmp = userService.getUser(user.getUsername());
		if (tmp == null || tmp.getUsername() == null) {
			model.addAttribute("dangerMsg", "Invalid username or password. Please try again.");
			model.addAttribute("target", target);
			return "login";
		}
		sessionTool.setCurrentUser(user);
		model.addAttribute("user", tmp);
		return "redirect:" + target;
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, Model model, @RequestParam("target") String target) {

		User tmp = userService.getUser(user.getUsername());
		if (tmp != null) {
			model.addAttribute("dangerMsg", "Username already exists.");
			model.addAttribute("target", target);
			return "login";
		}
		
		userService.SaveOrUpdateUser(user);
		
		sessionTool.setCurrentUser(user);
		model.addAttribute("user", tmp);
		return target;
	}
	
	
	
	
	@RequestMapping(value = "/logout")
	public String logout() {
		sessionTool.setCurrentUser(null);
		return "index";
	}

}
