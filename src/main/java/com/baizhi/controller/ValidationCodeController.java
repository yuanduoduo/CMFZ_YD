package com.baizhi.controller;

import org.patchca.background.BackgroundFactory;
import org.patchca.color.ColorFactory;
import org.patchca.color.RandomColorFactory;
import org.patchca.filter.ConfigurableFilterFactory;
import org.patchca.filter.library.AbstractImageOp;
import org.patchca.filter.library.WobbleImageOp;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.text.renderer.BestFitTextRenderer;
import org.patchca.text.renderer.TextRenderer;
import org.patchca.word.RandomWordFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/code")
public class ValidationCodeController{
	private static final long serialVersionUID = 5126616339795936447L;

	private ConfigurableCaptchaService configurableCaptchaService = null;
	private ColorFactory colorFactory = null;
	private RandomFontFactory fontFactory = null;
	private RandomWordFactory wordFactory = null;
	private TextRenderer textRenderer = null;
	
	public void destroy() {
		wordFactory = null;
		colorFactory = null;
		fontFactory = null;
		textRenderer = null;
		configurableCaptchaService = null;
	}
	@RequestMapping("/code")
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		init();
		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");
		HttpSession session = request.getSession(true);
		OutputStream outputStream = response.getOutputStream();
		Captcha captcha = configurableCaptchaService.getCaptcha();

		String validationCode = captcha.getChallenge();
		session.setAttribute("validationCode", validationCode);
	
		BufferedImage bufferedImage = captcha.getImage();
		ImageIO.write(bufferedImage, "png", outputStream);

		outputStream.flush();
		outputStream.close();
		return null;
	}
	public void init() throws ServletException {
		configurableCaptchaService = new ConfigurableCaptchaService();

		
		colorFactory = new RandomColorFactory();
		configurableCaptchaService.setColorFactory(colorFactory);

		
		fontFactory = new RandomFontFactory();
		fontFactory.setMaxSize(32);
		fontFactory.setMinSize(28);
		configurableCaptchaService.setFontFactory(fontFactory);

		
		wordFactory = new RandomWordFactory();
		wordFactory.setCharacters("abcdefghkmnpqstwxyz23456789");
		wordFactory.setMaxLength(5);
		wordFactory.setMinLength(4);
		configurableCaptchaService.setWordFactory(wordFactory);

		
		MyCustomBackgroundFactory backgroundFactory = new MyCustomBackgroundFactory();
		configurableCaptchaService.setBackgroundFactory(backgroundFactory);

		
		ConfigurableFilterFactory filterFactory = new ConfigurableFilterFactory();

		List<BufferedImageOp> filters = new ArrayList<BufferedImageOp>();
		WobbleImageOp wobbleImageOp = new WobbleImageOp();
		wobbleImageOp.setEdgeMode(AbstractImageOp.EDGE_MIRROR);
		wobbleImageOp.setxAmplitude(2.0);
		wobbleImageOp.setyAmplitude(1.0);
		filters.add(wobbleImageOp);
		filterFactory.setFilters(filters);

		configurableCaptchaService.setFilterFactory(filterFactory);

		
		textRenderer = new BestFitTextRenderer();
		textRenderer.setBottomMargin(3);
		textRenderer.setTopMargin(3);
		configurableCaptchaService.setTextRenderer(textRenderer);

		
		configurableCaptchaService.setWidth(82);
		configurableCaptchaService.setHeight(32);
	}

	
	private class MyCustomBackgroundFactory implements BackgroundFactory {
		private Random random = new Random();

		public void fillBackground(BufferedImage image) {
			Graphics graphics = image.getGraphics();

			
			int imgWidth = image.getWidth();
			int imgHeight = image.getHeight();

			
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, imgWidth, imgHeight);

			
			for (int i = 0; i < 100; i++) {
				
				int rInt = random.nextInt(255);
				int gInt = random.nextInt(255);
				int bInt = random.nextInt(255);

				graphics.setColor(new Color(rInt, gInt, bInt));

				
				int xInt = random.nextInt(imgWidth - 3);
				int yInt = random.nextInt(imgHeight - 2);

				
				int sAngleInt = random.nextInt(360);
				int eAngleInt = random.nextInt(360);

			
				int wInt = random.nextInt(6);
				int hInt = random.nextInt(6);

				graphics.fillArc(xInt, yInt, wInt, hInt, sAngleInt, eAngleInt);

				
				if (i % 20 == 0) {
					int xInt2 = random.nextInt(imgWidth);
					int yInt2 = random.nextInt(imgHeight);
					graphics.drawLine(xInt, yInt, xInt2, yInt2);
				}
			}
		}
	}
}
