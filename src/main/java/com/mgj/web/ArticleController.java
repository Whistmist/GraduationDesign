package com.mgj.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mgj.entity.Article;
import com.mgj.service.ArticleService;
import com.mgj.utils.Result.BaseResponse;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="saveInformation")
	@ResponseBody
	public String saveInformation(@RequestBody String articleList){
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
		System.out.println(articleList);
		return "";
	}
}
