package com.cary.cwish.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cary.cwish.pojo.User;
import com.cary.cwish.service.UserService;
import com.cary.cwish.utils.MathUtils;

@Controller
@RequestMapping(value="/loginPage")
public class LoginPageController {
	private static Logger logger = Logger.getLogger(LoginPageController.class);
	@Resource
	private UserService userService;  
	
	@RequestMapping(value="/")
	public ModelAndView loginPage(){
		 ModelAndView view = new ModelAndView("LoginPage");
		 return view;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		ModelAndView mav = new ModelAndView("HomePage");
		Cookie accountCookie = null;
		Cookie ssidCookie = null;
		
		try{
			String userName = request.getParameter("user_name").toString();
			String password = request.getParameter("user_pwd").toString();
			String md5Str;
        	User user = this.userService.getUserByName(userName);
        	if (user != null) {
        		if (password.equals(user.getPassword())) {
        			mav.addObject("account", user);
        			/*
        			 * Add user_name and KEY to cookie
        			 */
        			md5Str = userName.trim().toUpperCase() + MathUtils.KEY;
        			logger.info("md5 : " + MathUtils.MD5(md5Str));
        			ssidCookie = new Cookie("ssid", MathUtils.MD5(md5Str));
        			ssidCookie.setMaxAge(60*60*1);
        			// 设置Path为'/'以确保在域名下所有路径都可以访问到该cookie
        			ssidCookie.setPath("/");
        			
        			accountCookie = new Cookie("account", userName);
        			accountCookie.setMaxAge(60*60*1);
        			accountCookie.setPath("/");
        			
        			response.addCookie(ssidCookie);
        			response.addCookie(accountCookie);
        			
        			logger.info("Get the correct user info, return to HomePage");
        			return mav;
        		} else {
        			mav.setViewName("LoginPage");
        			mav.addObject("Exception", "Incorrect user password");
        			logger.info("Incorrect user password, return to LoginPage");
        			return mav;
        		}
        	} else {
        		mav.setViewName("LoginPage");
    			mav.addObject("Exception", "Incorrect user name");
    			logger.info("Incorrect user name, return to LoginPage");
        		return mav;
        	}
        } catch (Exception e) {
        	mav.setViewName("outException");
        	mav.addObject("Exception", e);
        	logger.info(e);
        	return mav;
        }
	}
	
}
