package com.gupt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gupt.demo.entity.User;
import com.gupt.demo.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	public User selectUser(User user){
		return  userMapper.selectUser(user.getUserName(), user.getPassword());
	}

	public int insert(User user){
		return userMapper.insert(user);
	}
}
