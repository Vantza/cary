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
		logger.info("get in Article Service to get articles by id");
		return articleDao.selectByPrimaryKey(articleId);
	}

	@Override
	public int getArticleCount(String userName) throws Exception {
		logger.info("get in Article Service to get article count");
		return articleDao.selectArticleCount(userName);
	}

	@Override
	public List<Article> getArticles(int startNum) throws Exception {
		logger.info("get in Article Service to get 10 articles");
		return articleDao.selectByPrimaryKeyInLimit(startNum);
	}

	@Override
	public int insertArticle(Article article) throws Exception {
		logger.info("get in insert article service");
		return articleDao.insertArticleRecord(article);
	}

	@Override
	public List<Article> getArticlesByUserName(String userName, int currentPage) throws Exception {
		logger.info("get in Article Service to get articles by user name");
		return articleDao.selectByUserName(userName, currentPage);
	}

}
