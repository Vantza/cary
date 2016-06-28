package com.cary.cwish.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cary.cwish.pojo.Article;
import com.cary.cwish.service.ArticleService;
import com.cary.cwish.utils.CommonUtils;
import com.cary.cwish.utils.WishConstant;

@Controller
@RequestMapping("/userArticle")
public class UserArtilcePageController {
	private static Logger logger = Logger.getLogger(UserArtilcePageController.class);

	@Resource
	ArticleService articleService;
	
	/**
	 * For first entrance in user article page
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value= "/")
	public ModelAndView userArticlePage(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView(WishConstant.USER_ARTICLE_PAGE);
		
		try {
			logger.info("get in user article page");
			String userName = CommonUtils.getUserNameInCookie(req);
			int articleCount = articleService.getArticleCount(userName);
			List<Article> articles = articleService.getArticlesByUserName(userName, 0);
			mav.addObject("articles", articles);
			mav.addObject("articleCount", articleCount);
			mav.addObject("page", WishConstant.USER_ARTICLE_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * To get page count information by ajax
	 * @param req
	 * @param res
	 */
	@RequestMapping(value= "/pageInfo")
	public void getUserPageInfo(HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObject;
		
		try {
			logger.info("get in page info method");
			String userName = CommonUtils.getUserNameInCookie(req);
			int articleCount = articleService.getArticleCount(userName);
			jsonObject = new JSONObject();
			jsonObject.put("artCount", articleCount);
			res.getWriter().write(jsonObject.toString());
			logger.info("page count: " + jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To get current page by ajax
	 * @param req
	 * @param res
	 */
	@RequestMapping(value="/currentPageArts")
	public void getUserArticlesByPage(HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObject;
		
		res.setCharacterEncoding("UTF-8");
		logger.info("get in get user articles by page");
		String userName = CommonUtils.getUserNameInCookie(req);
		String cPageStr = req.getParameter("currentPage");
		logger.info("currentPage = " + cPageStr);
		logger.info("Encoding is :" + res.getCharacterEncoding());
		int cPage = Integer.parseInt(cPageStr);
		
		try {
			List<Article> articles = articleService.getArticlesByUserName(userName, (cPage-1)*10);
			logger.info(articles.size());
			jsonObject = new JSONObject();
			jsonObject.put("currentArticles", articles);
			res.getWriter().write(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
