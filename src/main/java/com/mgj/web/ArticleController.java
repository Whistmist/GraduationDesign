package com.mgj.web;


import com.mgj.entity.Article;
import com.mgj.entity.MicroBlog;
import com.mgj.service.ArticleService;
import com.mgj.service.MicroBlogService;
import com.mgj.utils.Result.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	MicroBlogService microBlogService;
	
	@RequestMapping(value="saveInformation")
	@ResponseBody
	public BaseResponse saveInformation(@RequestBody List<Article> articles){
		return articleService.saveArticle(articles);
	}

	@RequestMapping(value="toGetMicroBlog")
	@ResponseBody
	public List<MicroBlog> saveInformation(){
		List<MicroBlog> list=microBlogService.getMicroBlog();
		for (MicroBlog microBlog: list ) {
			if("".equals(microBlog.getInform())&&microBlog.getInform().length()==0){
				microBlog.setInform("<h1 style='text-align: center;'>暂  无</h1>");
			}else if (microBlog.getInform().length() > 130) {
				microBlog.setInform(microBlog.getInform().substring(0, 130) + "...");
			}

		}
		return list;
	}


}
