package com.cary.cwish.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CommonUtils {
	
	public final static String getUserName(HttpServletRequest req) {
		if (req.getCookies() != null){
			for (Cookie c : req.getCookies()) {
				if (c.getName().equals("account")) {
					return c.getValue();
				}
			}
		}
		return null;
	}
	
}
