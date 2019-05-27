package com.mgj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgj.dao.ArticleDao;
import com.mgj.entity.Article;
import com.mgj.entity.Series;
import com.mgj.entity.Statistical;
import com.mgj.utils.Result.BaseResponse;
import com.mgj.utils.Result.ResultCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService {
	
	@Autowired
	ArticleDao articleDao;
	
	/**
	 * 保存新闻
	 * @param articles
	 * @return
	 */
	public BaseResponse saveArticle(List<Article> articles) {
		BaseResponse response = new BaseResponse();
		List<String> ids = new ArrayList<String>();
		for (Article article : articles) {
			ids.add(article.getEid());
		}
		List<String> articleIds= articleDao.queryArticleIds(ids);
		List<Article> delList = new ArrayList<Article>();
		if(articleIds!=null) {
			for (String eid : articleIds) {
				for (Article article : articles) {
					if(eid.equals(article.getEid())) {
						delList.add(article);
					}
				}
			}
		}
		if(delList!=null) {
			articles.removeAll(delList);
			int i =0;
			try {
				i = articleDao.saveArticle(articles);
			} catch (Exception e) {
				log.error("保存新闻信息发生异常");
			}
			if (i == 0) {
	            response.setResultCode(ResultCode.SUCCESS_IS_HAVE);
	        } else {
	            response.setResultCode(ResultCode.SUCCESS);
	        }
		}
        return response;
	}

	@SuppressWarnings("unused")
	public  List<Integer> queryStatistical(String year) {
		List<Integer> list=new ArrayList<Integer>();
		String string = articleDao.queryStatistical(year);
		String[] split = string.split(",");
		for (String string2 : split) {
			list.add(Integer.parseInt(string2));
		}
		if(list==null) {
			log.error("统计信息发生异常");
			return null;
		}
		System.out.println("微博统计------>"+list);
		return list;
	}

}
