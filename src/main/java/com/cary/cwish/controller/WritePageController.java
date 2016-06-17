package com.cary.cwish.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cary.cwish.pojo.Article;
import com.cary.cwish.service.ArticleService;

@Controller
@RequestMapping("/write")
public class WritePageController {
	private static Logger logger = Logger.getLogger(WritePageController.class);
	
	@Resource
	ArticleService articleService;
	
	@RequestMapping(value= "/")
	public String writePage() {
		return "WritePage";
	}
	
	@RequestMapping(value="/submit")
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("WritePage");
		Article art = new Article();
		logger.info("get in submit function");
		String text = req.getParameter("editor");
		String title = req.getParameter("title");
		String userName = null;
		if (req.getCookies() != null){
			for (Cookie c : req.getCookies()) {
				if (c.getName().equals("account")) {
					userName = c.getValue();
					logger.info("user : " + userName);
				}
			}
		}
		art.setTitle(title);
		art.setText(text);
		art.setUserName(userName);
		try {
			articleService.insertArticle(art);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("text is : " + text);
		logger.info("title is :" + title);
		return mav;
	}
}
