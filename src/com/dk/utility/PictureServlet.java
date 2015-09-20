package com.dk.utility;

import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dk.model.Picture;
import com.dk.model.PictureThumb;
import com.dk.service.PictureService;
import com.dk.service.PictureThumbService;

@Component("pictureServlet")
public class PictureServlet extends HttpServlet {

	private static final long serialVersionUID = 1893969420176842277L;
	@Autowired
	PictureService pictureService;
	@Autowired
	PictureThumbService pictureThumbService;

	private WebApplicationContext springContext;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getPathInfo();

		// grab the id
		String pictureIdStr = path.substring(path.indexOf('/') + 1);
		int pictureId = Integer.parseInt(pictureIdStr);

		// get the picture
		Picture picture = pictureService.getPicture(pictureId);
		// get the data
		PictureThumb thumb = pictureThumbService.getPictureData(picture.getId());

		// send the picture
		resp.setContentType("image/jpg");
		BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());

		out.write(thumb.getData());
		out.close();
	}

}