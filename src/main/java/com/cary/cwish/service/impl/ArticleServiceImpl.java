package com.cary.cwish.service.impl;

import java.util.List;

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
		logger.info("get in Article Service to get article by id");
		return articleDao.selectByPrimaryKey(articleId);
	}

	@Override
	public int getArticleCount() throws Exception {
		logger.info("get in Article Service to get article count");
		return articleDao.selectArticleCount();
	}

	@Override
	public List<Article> getArticles(int startNum) throws Exception {
		logger.info("get in Article Service to get 10 articles");
		return articleDao.selectByPrimaryKeyInLimit(startNum);
	}

}
