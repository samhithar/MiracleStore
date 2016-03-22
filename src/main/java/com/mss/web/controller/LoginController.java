package com.mss.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String customLogin(ModelMap map) {
 		return "login";
 	}
	
	
	@RequestMapping(value="/loginSuccess", method = RequestMethod.GET)
	public String success(ModelMap map) {
		map.addAttribute("msg", "Successfully logged in");
		return "home";
	}
	
	
}
