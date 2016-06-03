package com.cary.cwish.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cary.cwish.pojo.User;
import com.cary.cwish.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	private static Logger logger = Logger.getLogger(UserController.class);
    @Resource  
    private UserService userService;  
      
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model) {  
        try{
//        	int userId = Integer.parseInt(request.getParameter("id"));  
//        	logger.info(userId);
        	User user = this.userService.getUserById(1);  
        	model.addAttribute("user", user);
        } catch (Exception e) {
        	model.addAttribute("Exception", e);
        	logger.info(e);
        	return "outException";
        }
        return "showUser";
    }  
}