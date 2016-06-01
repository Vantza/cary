package com.cary.cwish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/"})
public class HomeRedirectController {
	@RequestMapping(value={"cary","index.jsp","/"})
    public String index(){
        return "HomePage";
    }
}
