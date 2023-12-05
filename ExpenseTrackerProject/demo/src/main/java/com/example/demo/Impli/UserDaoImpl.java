package com.example.demo.Impli;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.repo.UserJpaRepo;
@Component
public class UserDaoImpl implements UserDao {


	@Autowired
	private UserJpaRepo repo;
	
	public void addUser(User user) {
	
		
      repo.save(user);
	}
	
	
	public User login(String name,String password)
	{
		User status=repo.findByUserNameAndPassword(name, password);
		return status;
		
	}
	
	@Override
	public User checkUserName(String name) {
		
		User user=repo.findByUserName(name);
		return user;
	}
	
	
}
