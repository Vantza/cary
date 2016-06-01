package com.cary.cwish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/write")
public class WritePageController {
	
	@RequestMapping(value= "/")
	public String writePage() {
		return "WritePage";
	}
}
