package com.cary.cwish.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value= "/")
	public ModelAndView userArticlePage(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView(WishConstant.USERARTICLEPAGE);
		
		try {
			int articleCount = articleService.getArticleCount();
			String userName = CommonUtils.getUserName(req);
			List<Article> articles = articleService.getArticlesByUserName(userName);
			mav.addObject("articles", articles);
			mav.addObject("articleCount", articleCount);
			mav.addObject("page", WishConstant.USERARTICLEPAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
