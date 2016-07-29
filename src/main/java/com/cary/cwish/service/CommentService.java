package com.cary.cwish.service;

import java.util.List;

import com.cary.cwish.pojo.Comment;

public interface CommentService {
	public void insertComment(Comment comment) throws Exception;
	
	public List<Comment> getArticleComments(int articleId) throws Exception;
}
