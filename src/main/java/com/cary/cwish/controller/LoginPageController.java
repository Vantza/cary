package com.cary.cwish.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cary.cwish.pojo.User;
import com.cary.cwish.service.UserService;

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
	public ModelAndView login(HttpServletRequest request, Model model) throws Exception{
		
		ModelAndView mav = new ModelAndView("HomePage");
		try{
			String userName = request.getParameter("user_name").toString();
			String password = request.getParameter("user_pwd").toString();
        	User user = this.userService.getUserByName(userName);
        	if (user != null) {
        		if (password.equals(user.getPassword())) {
        			mav.addObject("user", user);
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
