package com.cary.cwish.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cary.cwish.pojo.User;
import com.cary.cwish.service.IUserService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	private static Logger logger = Logger.getLogger(UserController.class);
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model) {  
        try{
        	int userId = Integer.parseInt(request.getParameter("id"));  
        	User user = this.userService.getUserById(userId);  
        	model.addAttribute("user", user);
        } catch (Exception e) {
        	model.addAttribute("Exception", e);
        	logger.info(e);
        	return "outException";
        }
        return "showUser";
    }  
}