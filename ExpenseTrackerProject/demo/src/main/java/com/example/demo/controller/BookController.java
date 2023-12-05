package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {

	@Autowired
	private BookDao dao;
	
	@RequestMapping(path="/addbookByMethod",method=RequestMethod.POST)
	@ResponseBody
	public String insertBook(@ModelAttribute Book book,@RequestParam("date1") String date,HttpServletRequest request)
	{
		LocalDate dateObject=LocalDate.parse(date);
		HttpSession session=request.getSession();
	    User user=(User)session.getAttribute("user");
	    int userId=user.getId();
	    book.setDate(dateObject);
	    book.setUser(user);
		dao.addBook(book);
		return "<center><h2>data is add</h2><center>";
	}
	
	
	@RequestMapping("/displayBooks")
	public ModelAndView dispaly()
	{
		ModelAndView mv=new ModelAndView();
		List<Book> bookList=dao.displayBooks();
		mv.addObject("list",bookList);
		mv.setViewName("viewbook.html");
		return mv;
	
	}
}
