package com.cary.cwish.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/write")
public class WritePageController {
	private static Logger logger = Logger.getLogger(WritePageController.class);
	
	@RequestMapping(value= "/")
	public String writePage() {
		return "WritePage";
	}
	
	@RequestMapping(value="/submit")
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("WritePage");
		logger.info("get in submit function");
		String text = req.getParameter("editor");
		String title = req.getParameter("title");
		logger.info("text is : " + text);
		logger.info("title is :" + title);
		return mav;
	}
}
