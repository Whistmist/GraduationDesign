package com.mgj.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgj.entity.Article;
import com.mgj.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="saveInformation")
	@ResponseBody
	public String saveInformation(@RequestBody List<Article> atticles){
		/*BaseResponse response=articleService.addArticle(articleList);*/
		/*JSONArray jsonArray =JSONArray.parseArray(articleList);
		List<Article> articleLists=null;
		Article article =null;
		for(int i =0; i < jsonArray.size(); i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if(jsonObject !=null) {
				String eid = jsonObject.getString("eid");
				String title = jsonObject.getString("title");
				String img = jsonObject.getString("img");
				String date = jsonObject.getString("date");// 封装Java对象 
				article = new Article(eid, title, img, date);
				articleLists.add(article); 
			} 
		} */
		System.out.println(atticles);
		return "";
	}
}
