package com.cary.cwish.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cary.cwish.pojo.Article;
import com.cary.cwish.service.ArticleService;

@Controller
@RequestMapping(value={"/"})
public class HomeRedirectController {
	private static Logger logger = Logger.getLogger(HomeRedirectController.class);
	@Resource
	ArticleService articleService;
	
	@RequestMapping(value={"cary","index.jsp","/"})
    public ModelAndView index(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("HomePage");
		
		try {
			int articleCount = articleService.getArticleCount();

			List<Article> articles = articleService.getArticles(0);
			logger.info("get into homepage(/cary): ");
			for (Article art : articles) {
				logger.info(art.getUserName());
			}
			mav.addObject("articles", articles);
			mav.addObject("articleCount", articleCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return mav;
    }
}
