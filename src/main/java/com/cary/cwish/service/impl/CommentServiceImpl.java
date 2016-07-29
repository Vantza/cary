package com.cary.cwish.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cary.cwish.dao.CommentDao;
import com.cary.cwish.pojo.Comment;
import com.cary.cwish.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentDao commentDao;

	@Override
	public void insertComment(Comment comment) throws Exception {
		commentDao.insert(comment);
	}

	@Override
	public List<Comment> getArticleComments(int articleId) throws Exception {
		return commentDao.selectByArticleId(articleId);
	}
}
