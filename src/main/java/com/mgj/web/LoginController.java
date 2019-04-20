package com.mgj.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.mgj.common.Const.RedisCacheExtime;
import com.mgj.common.RedisClient;
import com.mgj.entity.User;
import com.mgj.service.UserService;
import com.mgj.utils.CookieUtil;
import com.mgj.utils.DateTimeUtil;
import com.mgj.utils.JsonUtil;
import com.mgj.utils.NetworkUtil;
import com.mgj.utils.Result.BaseResponse;
import com.mgj.utils.Result.ResultCode;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginController {
	@Autowired
	UserService userService;
	@Autowired
	RedisClient redisClient;
	@RequestMapping("gotoLogin")
	@ResponseBody
	public BaseResponse gotoLogin(@RequestBody User user,HttpSession session,HttpServletResponse response,HttpServletRequest request) {
		log.info(user.toString());
		BaseResponse baseResponse=new BaseResponse();
		int flag=0;
		if(user!=null&&!user.equals("")) {
			flag=userService.getUser(user);
		}
		if(flag==0) {
			baseResponse.setResultCode(ResultCode.NOT_DATA);
		}
		if(flag>0) {
			CookieUtil.writeLoginToken(response, session.getId());
			redisClient.setEx(session.getId(), JsonUtil.obj2String(new Date()), RedisCacheExtime.REDIS_SESSION_EXTIME);
			baseResponse.setResultCode(ResultCode.SUCCESS_IS_HAVE);
		}
		return baseResponse;
	}
	
	
	
	@RequestMapping("login")
	public String login() {
		return "html/login";
	}
	@RequestMapping("logout")
	public String logout(HttpServletResponse response,HttpServletRequest request) {
		CookieUtil.delLoginToken(request, response);
		return "html/login";
	}
	@RequestMapping("login1")
	public String login1() {
		return "html/login1";
	}
	@RequestMapping("1")
	public String e1(HttpServletRequest req) {
		String readLoginToken = CookieUtil.readLoginToken(req);
		if(!StringUtils.isEmpty(readLoginToken)) {
			return "index";
		}else {
			return "html/login1";
		}
	}
	@RequestMapping("index")
	public String index(HttpServletRequest req) {
		String content = "用户在IP为【"+NetworkUtil.getIpAddress(req)+"】的电脑上系统。登录时间为【"+DateTimeUtil.getCurTime() + "】";
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
