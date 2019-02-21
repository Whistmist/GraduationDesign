package com.mgj.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidateCodeController {
	
	Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * 生成验证码
	 * 
	 * @param res
	 * @param key
	 */
	@RequestMapping("vc")
	public void vc(HttpServletResponse res, @RequestParam("key") String key) {
		OutputStream os = null;
		try {
			res.setHeader("Pragma", "No-cache");
			res.setHeader("Cache-Control", "no-cache");
			res.setDateHeader("Expires", 0);
			res.setContentType("image/jpeg; charset=UTF-8");

			int width = 80, height = 32;
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			os = res.getOutputStream();
			Graphics g = image.getGraphics();
			Random random = new Random();
			g.setColor(getRandColor(200, 250));
			g.fillRect(0, 0, width, height);

			g.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			g.setColor(getRandColor(160, 200));
			for (int i = 0; i < 155; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, x + xl, y + yl);
			}
			for (int i = 0; i < 4; i++) {
				String rand = String.valueOf(random.nextInt(10));
				g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
				g.drawString(rand, 13 * i + 14, 24);
			}
			g.dispose();		
			ImageIO.write(image, "JPEG", os);
			os.flush();
			res.flushBuffer();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				os = null;
			}
		}
	}

	/*@RequestMapping("/validSensitiveCode")
	@ResponseBody
	public Object validate(@RequestBody VCRequest request) throws Exception {
		BaseResponse br = new BaseResponse();
		if(request.getKey() == null || request.getCode() == null) {
			br.setCode(ResultCode.ERROR.code);
			br.setMessage("验证码错误！");
			return br;
		}
		
		String sensitiveVCKey = PREFIX + request.getKey();
		logger.debug("sensitiveVCKey : {}", sensitiveVCKey);
		String cacheCode = memcachedClient.get(sensitiveVCKey);
		
		if(request.getCode().equals(cacheCode)) {
			br.setResultCode(ResultCode.SUCCESS);
		} else {
			br.setCode(ResultCode.ERROR.code);
			br.setMessage("验证码错误！");
		}
		
		return br;
	}*/
	
}
