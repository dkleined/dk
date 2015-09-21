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

import com.dk.model.CreditCard;
import com.dk.model.Order;
import com.dk.model.Picture;
import com.dk.model.PictureData;
import com.dk.model.PictureThumb;
import com.dk.model.User;
import com.dk.service.OrderService;
import com.dk.service.PictureDataService;
import com.dk.service.PictureService;
import com.dk.service.PictureThumbService;
import com.dk.service.UserService;
import com.dk.utility.PaymentTool;
import com.dk.utility.PictureTool;
import com.dk.utility.SessionTool;

@Controller
public class AccountController {

	private PictureService pictureService;
	private PictureDataService pictureDataService;
	private PictureThumbService pictureThumbService;
	private OrderService orderService;
	private UserService userService;
	@Autowired
	private SessionTool sessionTool;
	@Autowired
	private PaymentTool paymentTool;

	public AccountController() {
	}

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired(required = true)
	@Qualifier(value = "orderService")
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
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

	/**
	 * 
	 * Used to allow user access to the account details page. The user has to be
	 * authenticated in order to gain access to this resource.
	 * 
	 * The accounts page consists of 3 things: account details, uploaded photos,
	 * and purchased photos. These fields are populated here and passed into the
	 * account view.
	 * 
	 * @param model
	 *            current model
	 * @return
	 */
	@RequestMapping(value = "/account")
	public String listUsers(Model model) {

		// verify that the user is logged in
		if (sessionTool.getCurrentUser() == null) {
			model.addAttribute("user", new User());
			model.addAttribute("target", "account");
			return "login";
		} else {
			// populate required fields to display account information
			User tmpUser = userService.getUser(sessionTool.getCurrentUser().getUsername());
			model.addAttribute("user", tmpUser);
			sessionTool.setCurrentUser(tmpUser);
			model.addAttribute("uploadedPictures", pictureService.getByUsername(tmpUser));
			model.addAttribute("orders", orderService.getByUsername(tmpUser));
			return "account";
		}
	}

	/**
	 * 
	 * Used to redirect the user to the upload page. The user must be
	 * authenticated in order to access this resource.
	 * 
	 * @param model
	 *            current model
	 * @return
	 */
	@RequestMapping(value = "/upload")
	public String upload(Model model) {

		// verify that the user is logged in
		if (sessionTool.getCurrentUser() == null) {
			model.addAttribute("user", new User());
			model.addAttribute("target", "upload");
			return "login";
		} else {
			return "upload";
		}
	}

	/**
	 * 
	 * Used to direct the user to the purchase form. The user must be
	 * authenticated in order to access this resource.
	 * 
	 * The id of the photo the user wishes to purchase must be passed in as a
	 * request parameter.
	 * 
	 * @param model
	 *            current model
	 * @param id
	 *            the id of the photo to be purchased
	 * @return
	 */
	@RequestMapping(value = "/buy{id}")

	// verify that the user is logged in
	public String buy(Model model, @RequestParam int id) {
		if (sessionTool.getCurrentUser() == null) {
			model.addAttribute("user", new User());
			model.addAttribute("target", "buy");
			return "login";
		} else {
			model.addAttribute("picture", pictureService.getPicture(id));
			return "buy";
		}
	}

	/**
	 * 
	 * Used to delete a picture from the gallery. The user attempting to delete
	 * a photo must be logged in. A user can only delete photos they uploaded.
	 * 
	 * The photo data and the photo thumbnail must be deleted before the photo
	 * in order to satisfy foreign key restraints in the database. After the
	 * photo and all related data is deleted, the user is redirected back to the
	 * account page.
	 * 
	 * @param model
	 *            current model
	 * @param id
	 *            the id of the photo to be deleted
	 * @return
	 */
	@RequestMapping(value = "/deletePicture{id}")
	public String deletePicture(Model model, @RequestParam int id) {
		if (sessionTool.getCurrentUser() == null) {
			model.addAttribute("user", new User());
			model.addAttribute("target", "account");
			return "login";
		}

		Picture toDelete = pictureService.getPicture(id);
		PictureData toDeleteData = pictureDataService.getPictureData(toDelete.getId());
		PictureThumb toDeleteThumb = pictureThumbService.getPictureThumb(toDelete.getId());

		// verify that the user attempting to delete a picture is the same user
		// that uploaded it
		if (toDelete.getUsername().getUsername().equals(sessionTool.getCurrentUser().getUsername())) {
			// delete all picture data in order of dependencies
			pictureThumbService.deletePictureThumb(toDeleteThumb);
			pictureDataService.deletePictureData(toDeleteData);
			pictureService.deletePicture(toDelete);
			model.addAttribute("successMsg", "Picture successfully deleted.");
		} else {
			// the user is not the one we expected
			model.addAttribute("dangerMsg", "You lack permission to delete that picture.");
		}

		// redirect back to account
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

	/**
	 * 
	 * Used to upload a picture to the gallery. The user must be authenticated
	 * in order to upload pictures.
	 * 
	 * After the user is verified to be authenticated, the picture itself is
	 * verified to be a jpg. Then a thumbnail is created that will be displayed
	 * in the gallery, and all the related data is stored into the database. The
	 * user is then redirected back to the upload page wiht a success message.
	 * 
	 * If anything goes wrong, or the file fails acceptance criteria, the user
	 * is redirected back to the upload page with a danger message.
	 * 
	 * @param picture
	 *            the picture to be saved
	 * @param model
	 *            the current model
	 * @param price
	 *            the desired price of the photo
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 
	 * Used to log a user into the current session.
	 * 
	 * @param user
	 *            login data
	 * @param model
	 *            current model
	 * @param target
	 *            the protected resource the user was attempting to access
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, Model model, @RequestParam("target") String target) {

		// verify the login was successful
		User tmp = userService.getUser(user.getUsername());
		if (tmp == null || tmp.getUsername() == null) {
			model.addAttribute("dangerMsg", "Invalid username or password. Please try again.");
			model.addAttribute("target", target);
			return "login";
		}

		// add the user to the session and direct to the page they were trying
		// to access
		sessionTool.setCurrentUser(user);
		model.addAttribute("user", tmp);
		return "redirect:" + target;
	}

	/**
	 * 
	 * Used to register a new user.
	 * 
	 * @param user
	 *            the user information to be persisted
	 * @param model
	 *            the current model
	 * @param target
	 *            the protected resource that the user was attempting to access
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, Model model, @RequestParam("target") String target) {

		// verify the registration won't break PK restraint
		User tmp = userService.getUser(user.getUsername());
		if (tmp != null) {
			model.addAttribute("dangerMsg", "Username already exists.");
			model.addAttribute("target", target);
			return "login";
		}

		// save the user and direct them to the page they were trying to access
		userService.SaveOrUpdateUser(user);

		sessionTool.setCurrentUser(user);
		model.addAttribute("user", tmp);
		return "redirect:" + target;
	}

	/**
	 * Used to log the current user out of the session.
	 * 
	 * @return redirect to the index page
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		sessionTool.setCurrentUser(null);
		return "index";
	}

	/**
	 * 
	 * Used to verify the final purchase of a photo. The user must be
	 * authenticated in order to access this resource.
	 * 
	 * @param model
	 * @param cardNumber
	 * @param expiryMonth
	 * @param expiryYear
	 * @param cvCode
	 * @return
	 */
	@RequestMapping("/verifyPayment")
	public String verifyPayment(Model model, @RequestParam("cardNumber") String cardNumber,
			@RequestParam("expiryMonth") int expiryMonth, @RequestParam("expiryYear") int expiryYear,
			@RequestParam("cvCode") int cvCode, @RequestParam("total") double total, @RequestParam("id") int id) {
		
		System.out.println("card=" + cardNumber);

		CreditCard creditCard = new CreditCard(cardNumber, expiryMonth, expiryYear, cvCode);

		if (paymentTool.processRequest(PaymentTool.TRANSACTION_TYPE.SALE, creditCard, total).equals("success")) {
			Order order = new Order();
			order.setPictureId(pictureService.getPicture(id));
			order.setUsername(sessionTool.getCurrentUser());
			orderService.saveOrUpdateOrder(order);
			return "redirect:account";
		} else {
			model.addAttribute("dangerMsg", "Your transaction was not approved. Please try again.");
		}

		return "redirect:account";
	}

}
