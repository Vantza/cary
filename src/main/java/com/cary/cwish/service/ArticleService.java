package com.cary.cwish.service;

import java.util.List;

import com.cary.cwish.pojo.Article;

public interface ArticleService {
	public Article getArticleById(int articleId) throws Exception;
	
	public int getArticleCount(String userName) throws Exception;
	
	public List<Article> getArticles(int startNum) throws Exception;
	
	public int insertArticle(Article article) throws Exception;
	
	public List<Article> getArticlesByUserName(String userName, int currentPage) throws Exception;
}
