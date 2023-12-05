package com.example.demo.dao;

import com.example.demo.entity.User;

public interface UserDao {

	void addUser(User user);
	
   User login(String name,String password);
   
   User checkUserName(String name);
   
  
}
