package com.mgj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgj.dao.ArticleDao;
import com.mgj.entity.Article;
import com.mgj.utils.Result.BaseResponse;
import com.mgj.utils.Result.ResultCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService {
	
	@Autowired
	ArticleDao articleDao;
	
	public BaseResponse saveArticle(List<Article> articles) {
		BaseResponse response = new BaseResponse();
		int i = articleDao.saveArticle(articles);
		if (i == 0) {
            response.setResultCode(ResultCode.SUCCESS_IS_HAVE);
        } else {
            response.setResultCode(ResultCode.SUCCESS);
        }
		log.info(response.toString());
        return response;
	}

}
