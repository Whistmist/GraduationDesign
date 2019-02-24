package com.mgj.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String todayInHistory(@RequestBody String YD) throws UnsupportedEncodingException {
		
		String[] split = YD.split("-");
		for (int i = 0; i < split.length; i++) {
			YD=Integer.parseInt(split[1])+"/"+Integer.parseInt(split[2]);
		}
		String jsonResult="";
		String httpUrl = "https://api.shenjian.io/todayOnhistory/queryEvent/";
		String date=URLEncoder.encode(YD,"UTF-8");
		String httpArg = "appid="+appid+"&date="+date;
		jsonResult = RequestUrl.request(httpUrl, httpArg);
		/*log.info(jsonResult);*/
		return jsonResult;
	}
}
