package com.mgj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgj.dao.ArticleDao;
import com.mgj.entity.Article;
import com.mgj.utils.Result.BaseResponse;

@Service
public class ArticleService {
	
	@Autowired
	ArticleDao articleDao;
	
	public BaseResponse addArticle(List<Article> articleList) {
		// TODO Auto-generated method stub
		return null;
	}

}
