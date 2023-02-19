package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorBaseController implements ErrorController {

	@RequestMapping("/error")
	private String onError() {
		return "error";
	}
	
	public String getErrorPath() {
		return "/error";
	}
}
