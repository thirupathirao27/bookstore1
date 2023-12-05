package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Impli.UserDaoImpl;
import com.example.demo.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserDaoImpl dao;
	
	@RequestMapping("/signIn")
	public String signIn(@ModelAttribute User user,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		session.setAttribute("user",user);
		dao.addUser(user);
		return "login.html";
				
		
	}
	
    @RequestMapping("/logInOperation")
	public ModelAndView login(@RequestParam("userName") String userName,@RequestParam("pass") String pass,HttpServletRequest request)
	
	{
		
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		 User user=dao.login(userName, pass);
		 if(user!=null)
		 {
			 session.setAttribute("user",user );
			 mv.setViewName("name.html");
			 return mv;
		 }
		 else
		 {
			 mv.addObject("msg","wrong details");
			 mv.setViewName("login.html");
			 return mv;
		 }
	}
    
    @RequestMapping(path ="/forgotpassword1", method=RequestMethod.POST)
    public ModelAndView forgotPassword1(@RequestParam("userName") String uname,HttpServletRequest request)
    {
    	ModelAndView mv=new  ModelAndView();
    	HttpSession session=request.getSession();
    	User user=dao.checkUserName(uname);
    	if(user!=null)
    	{
    		session.setAttribute("user",user);
    		mv.setViewName("password.html");
    		return mv;
    	}
    	else
    	{
    		mv.addObject("checkUserName","Enter valid User Name");
    		mv.setViewName("username.html");
    		return mv;
    	}
    }
    
    @RequestMapping(path ="/forgotPassword2", method=RequestMethod.POST)
    @ResponseBody
   public  ModelAndView forgotPassword2(@RequestParam("pass") String pass,HttpServletRequest request)
   {
	   HttpSession session=request.getSession();
	  User user=(User)session.getAttribute("user");
	  user.setPassword(pass);
	  System.out.println(user);
	   dao.addUser(user);
	   ModelAndView mv=new ModelAndView();
	   mv.addObject("msg","YOUR PASSWORD IS UPDATED");
	   mv.setViewName("login.html");
	   return mv;
	 
   }
    
   
}
