package com.mgj.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgj.utils.RequestUrl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SpiderController {
	
	@Value("${appid}")  
	private String appid; 
	
	@RequestMapping("todayInHistory")
	@ResponseBody
	public String todayInHistory() throws UnsupportedEncodingException {
		String httpUrl = "https://api.shenjian.io/todayOnhistory/queryEvent/";
		String date=URLEncoder.encode("12/6","UTF-8");
		String httpArg = "appid="+appid+"&date="+date;
		String jsonResult = RequestUrl.request(httpUrl, httpArg);
		log.info(jsonResult);
		return jsonResult;
	}
}
