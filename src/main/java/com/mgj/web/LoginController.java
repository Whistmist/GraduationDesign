package com.mgj.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgj.entity.User;
import com.mgj.service.UserService;
import com.mgj.utils.CommonObjResponse;
import com.mgj.utils.DateUtil;
import com.mgj.utils.NetworkUtil;
import com.mgj.utils.Result.BaseResponse;
import com.mgj.utils.Result.ResultCode;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping("gotoLogin")
	@ResponseBody
	public BaseResponse gotoLogin(@RequestBody User user) {
		log.info(user.toString());
		BaseResponse baseResponse=new BaseResponse();
		int flag=0;
		if(user!=null&&!user.equals("")) {
			flag=userService.getUser(user);
		}
		if(flag>0) {
			baseResponse.setResultCode(ResultCode.SUCCESS_IS_HAVE);
		}
		if(flag==0) {
			baseResponse.setResultCode(ResultCode.NOT_DATA);
		}
		return baseResponse;
		
		
		
	}
	
	
	
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
