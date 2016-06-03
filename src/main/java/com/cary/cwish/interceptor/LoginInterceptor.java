package com.cary.cwish.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private static Logger logger = Logger.getLogger(LoginInterceptor.class);
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception e)
			throws Exception {
	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		// this method is to block user to use 'write' page, if the user has no permission
		logger.info("LoginInterceptor had been executed");
		res.sendRedirect("/cary/home/");
		return false;
	}

}
