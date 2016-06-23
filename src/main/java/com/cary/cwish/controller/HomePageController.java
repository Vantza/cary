package com.cary.cwish.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cary.cwish.pojo.Article;
import com.cary.cwish.service.ArticleService;
import com.cary.cwish.utils.WishConstant;

@Controller
@RequestMapping("/home")
public class HomePageController {
	private static Logger logger = Logger.getLogger(HomePageController.class);
	@Resource
	ArticleService articleService;
	
	@RequestMapping(value= "/")
	public ModelAndView getHomePage(HttpServletRequest request, Model model){
		ModelAndView mav = new ModelAndView(WishConstant.HOMEPAGE);
		try {
			List<Article> articles = articleService.getArticles(0);
			logger.info("get into homepage(/home): ");
			for (Article art : articles) {
				logger.info(art.getUserName());
			}
			mav.addObject("articles", articles);
			mav.addObject("page", WishConstant.HOMEPAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return mav;
	}
}
