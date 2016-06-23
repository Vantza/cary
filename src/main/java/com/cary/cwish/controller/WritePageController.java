package com.cary.cwish.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cary.cwish.pojo.Article;
import com.cary.cwish.service.ArticleService;
import com.cary.cwish.utils.CommonUtils;
import com.cary.cwish.utils.WishConstant;

@Controller
@RequestMapping("/write")
public class WritePageController {
	private static Logger logger = Logger.getLogger(WritePageController.class);
	
	@Resource
	ArticleService articleService;
	
	@RequestMapping(value= "/")
	public ModelAndView writePage() {
		ModelAndView mav = new ModelAndView(WishConstant.WRITEPAGE);
		
		mav.addObject("page", WishConstant.WRITEPAGE);
		return mav;
	}
	
	@RequestMapping(value="/submit")
	public void onSubmit(HttpServletRequest req, HttpServletResponse res, Model model) {
		Article art = new Article();
		logger.info("get in submit function");
		logger.info("Encoding is :" + req.getCharacterEncoding());
		String text = req.getParameter("editor");
		String title = req.getParameter("title");
		String userName = CommonUtils.getUserName(req);
		art.setTitle(title);
		art.setText(text);
		art.setUserName(userName);
		try {
			articleService.insertArticle(art);
			res.sendRedirect("/cary/home/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("text is : " + text);
		logger.info("title is :" + title);
	}
}
