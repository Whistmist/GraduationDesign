package com.mgj.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgj.entity.Article;
import com.mgj.service.ArticleService;
import com.mgj.utils.RequestUrl;
import com.mgj.utils.Result.BaseResponse;
import com.mgj.utils.Result.ResultCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SpiderController {
	
	@Value("${appid}")  
	private String appid; 
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("todayInHistory")
	@ResponseBody
	public String todayInHistory(@RequestBody String YD) throws UnsupportedEncodingException {
		
		String[] split = YD.split("-");
		for (int i = 0; i < split.length; i++) {
			YD=Integer.parseInt(split[1])+"/"+Integer.parseInt(split[2]);
		}
		String httpUrl = "https://api.shenjian.io/todayOnhistory/queryEvent/";
		String date=URLEncoder.encode(YD,"UTF-8");
		String httpArg = "appid="+appid+"&date="+date;
		String jsonResult = RequestUrl.request(httpUrl, httpArg);
		log.info(jsonResult);
		return jsonResult;
	}
	
	@RequestMapping("saveInformation")
	@ResponseBody
	public BaseResponse saveInformation(@RequestBody List<Article> articleList) throws UnsupportedEncodingException {
		BaseResponse response=articleService.addArticle(articleList);
		return response;
	}
}
