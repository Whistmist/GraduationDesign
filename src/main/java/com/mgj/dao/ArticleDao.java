package com.mgj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mgj.entity.Article;
import com.mgj.entity.Statistical;

@Mapper
public interface ArticleDao {

	int saveArticle(List<Article> articles);

	List<String> queryArticleIds(List<String> ids);

	String queryStatistical(String year);
	
}
