package com.cary.cwish.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cary.cwish.dao.ArticleDao;
import com.cary.cwish.pojo.Article;
import com.cary.cwish.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	private static Logger logger = Logger.getLogger(ArticleServiceImpl.class);
	@Resource
	private ArticleDao articleDao;

	public Article getArticleById(int articleId) throws Exception {
		logger.info("get in Article Service");
		return articleDao.selectByPrimaryKey(articleId);
	}

}
