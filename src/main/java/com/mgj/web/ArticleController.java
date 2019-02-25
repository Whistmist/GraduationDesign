package com.mgj.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgj.entity.Article;
import com.mgj.service.ArticleService;
import com.mgj.utils.Result.BaseResponse;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="saveInformation")
	@ResponseBody
	public BaseResponse saveInformation(@RequestBody List<Article> articles){
		return articleService.saveArticle(articles);
	}

}
