package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String username,HttpSession session){
		session.setAttribute("username", username);
		return "redirect:toIndex.action";
	}
	
	@RequestMapping("/toIndex")
	public String toIndex(){
		return "index";
	}
	
	
}
