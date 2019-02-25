package com.mgj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mgj.entity.Article;

@Mapper
public interface ArticleDao {

	int saveArticle(List<Article> articles);
	
}
