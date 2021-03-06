package com.cary.cwish.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cary.cwish.service.ArticleService;

@Controller
@RequestMapping(value={"/"})
public class HomeRedirectController {
	private static Logger logger = Logger.getLogger(HomeRedirectController.class);
	@Resource
	ArticleService articleService;
	
	@RequestMapping(value={"cary","index.jsp","/"})
	public void index(HttpServletRequest req, HttpServletResponse res) throws IOException {
		logger.info("get in '/' and redirect to '/home'");
		res.sendRedirect("/cary/home/");
	}
}
