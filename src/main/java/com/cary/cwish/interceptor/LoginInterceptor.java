package com.cary.cwish.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cary.cwish.utils.MathUtils;

public class LoginInterceptor implements HandlerInterceptor {

	private static Logger logger = Logger.getLogger(LoginInterceptor.class);
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception e)
			throws Exception {
		logger.info("afterCompletion cookie length : "+req.getCookies().length);
	}

	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView)
			throws Exception {
		logger.info("postHandle cookie length : "+req.getCookies().length);
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		// this method is to block user to use 'write' page, if the user has no permission
		logger.info("LoginInterceptor had been executed");
		/*
		 * before redirect there should be a confirm for log info
		 */
		String acc = null;
		String ssid = null;
		logger.info("cookie length : "+req.getCookies().length);
		if (req.getCookies() != null){
			for (Cookie c : req.getCookies()) {
				logger.info(c.getName());
				if (c.getName().equals("account")) {
					acc = c.getValue();
					logger.info("acccccc" + acc);
				}
				if (c.getName().equals("ssid")) {
					ssid = c.getValue();
					logger.info("ssidddd"+ssid);
				}
			}
		}
		logger.info(acc + "---" + ssid);
		logger.info(MathUtils.MD5(acc+ " : " +MathUtils.KEY));
		if (acc!=null && ssid!=null) {
			logger.info("account in interceptor : "+acc);
			return ssid.equals(MathUtils.MD5(acc+ " : " +MathUtils.KEY));
		}
		res.sendRedirect("/cary/loginPage/");
		return false;
	}

}
