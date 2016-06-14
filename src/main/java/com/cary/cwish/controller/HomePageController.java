package com.cary.cwish.controller;

//import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.cary.cwish.pojo.Article;
//import com.cary.cwish.service.ArticleService;

@Controller
@RequestMapping("/home")
public class HomePageController {
	private static Logger logger = Logger.getLogger(HomePageController.class);
//	@Resource
//	ArticleService articleservice;
	
	@RequestMapping(value= "/")
	public ModelAndView getHomePage(HttpServletRequest request, Model model){
		ModelAndView mav = new ModelAndView("HomePage");
//		try {
//			Article a = articleservice.getArticleById(1);
//			logger.info("get into homepage: "+a.getText());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return mav;
	}
}
