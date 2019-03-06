package com.mgj.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mgj.utils.DateUtil;
import com.mgj.utils.NetworkUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String login() {
		return "html/login";
	}
	@RequestMapping("login1")
	public String login1() {
		return "html/login1";
	}
	@RequestMapping("index")
	public String index(HttpServletRequest req) {
		String content = "用户在IP为【"+NetworkUtil.getIpAddress(req)+"】的电脑上系统。登录时间为【"+DateUtil.getCurTime() + "】";
		log.info(content);
		return "html/index";
	}
	@RequestMapping("welcome")
	public String welcome() {
		return "html/welcome";
	}
	@RequestMapping("reception")
	public String reception() {
		return "html/reception";
	}
}
