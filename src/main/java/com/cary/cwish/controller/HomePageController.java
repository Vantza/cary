package com.cary.cwish.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
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
		ModelAndView mav = new ModelAndView(WishConstant.HOME_PAGE);
		try {
			List<Article> articles = articleService.getArticles(0);
			logger.info("get into homepage(/home): ");
			for (Article art : articles) {
				logger.info(art.getUserName());
			}
			mav.addObject("articles", articles);
			mav.addObject("page", WishConstant.HOME_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return mav;
	}
	
	/**
	 * To get articles on home page by ajax
	 * @param req
	 * @param res
	 */
	@RequestMapping(value="/homeArticles")
	public void getHomeArticles(HttpServletRequest req, HttpServletResponse res) {
		JSONObject jsonObject;
		
		res.setCharacterEncoding("UTF-8");
		try {
			logger.info("get in home articles method");
			List<Article> articles = articleService.getArticles(0);
			jsonObject = new JSONObject();
			jsonObject.put("articles", articles);
			res.getWriter().write(jsonObject.toString());
			logger.info("page count: " + jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
