package com.mgj.web;


import com.mgj.entity.Article;
import com.mgj.entity.MicroBlog;
import com.mgj.entity.Series;
import com.mgj.entity.Statistical;
import com.mgj.service.ArticleService;
import com.mgj.service.MicroBlogService;
import com.mgj.utils.Result.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	MicroBlogService microBlogService;
	/**
	 * 统计柱状图
	 * @return
	 */
	@RequestMapping(value="queryStatistical")
	@ResponseBody
	public List<Series> queryStatistical(String year){	
		List<Series> list=new ArrayList<Series>();
		list.add(new Series("微博", "column", articleService.queryStatistical(year)));
		list.add(new Series("学院官网", "column", random()));
		list.add(new Series("本地新闻", "column", random()));
		list.add(new Series("系统上传", "column", random()));
		return list;
	}
	private List<Integer> random() {
		List<Integer> list1 =new ArrayList<Integer>();
		for (int i = 0; i < 12; i++) {
			if(i<5) {
				list1.add((int)(1+Math.random()*50));
			}else {
				list1.add(0);
			}
		}
		return list1;
	}
	/**
	 * 保存新闻
	 * @param articles
	 * @return
	 */
	@RequestMapping(value="saveInformation")
	@ResponseBody
	public BaseResponse saveInformation(@RequestBody List<Article> articles){
		return articleService.saveArticle(articles);
	}
	
	/**
	 * 获取微博数据
	 * @return
	 */
	@RequestMapping(value="toGetMicroBlog")
	@ResponseBody
	public List<MicroBlog> saveInformation(){
		List<MicroBlog> list=microBlogService.getMicroBlog();
		for (MicroBlog microBlog: list ) {
			if("".equals(microBlog.getInform())&&microBlog.getInform().length()==0){
				microBlog.setInform("<h1 style='line-height: 108px;text-align: center;'>暂  无</h1>");
			}else if (microBlog.getInform().length() > 120) {
				String string=microBlog.getInform().substring(0, 120);
				if(string.endsWith("</")) {
					string = string.substring(0,string.length()-2);
					string +="...</p>";
				}else if (string.endsWith("</p")) {
					string=string.substring(0,string.length()-3);
					string +="...</p>";
				}else{
					string +="...";
				}
				microBlog.setInform(string);
			}else{
				StringBuffer stringBuffer = new StringBuffer(microBlog.getInform());
				String string = stringBuffer.insert(2, " style='height: 118px;'").toString();
				microBlog.setInform(string);
			}
		}
		return list;
	}


}
