package com.cary.cwish.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/homePage")
	public String getHomePage(HttpServletRequest request, Model model){
		return "HomePage";
	}
}
