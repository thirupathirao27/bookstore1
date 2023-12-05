package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/signin")
	public String signIn()
	{
		return "signin.html";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login.html";
	}
	
	@RequestMapping("/addBook")
	public String addBook()
	{
		return "addbook.html";
	}
	
	@RequestMapping("/index")
	public String index()
	{
		return "index.html";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home.html";
	}
	
	@RequestMapping("/username")
	public String username()
	{
		return "username.html";
	}
	
	@RequestMapping("/password")
	public String password()
	{
		return "password.html";
	}
	
	@RequestMapping("/viewbook")
	public String viewBook()
	{
		return "viewbook.html";
	}
	
}
