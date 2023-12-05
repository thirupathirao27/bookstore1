package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.entity.User;
@EnableJpaRepositories(basePackages = "com.example.demo")
public interface UserJpaRepo extends JpaRepository<User, Integer> {

	User findByUserNameAndPassword(String name,String pass);
	
	User findByUserName(String name);
	
	
}
