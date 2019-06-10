package com.gupt.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gupt.demo.entity.User;
import com.gupt.demo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public String dologin(){
		return "login";
	}
	
	@RequestMapping(value="/register")
	public String doRegister(){
		return "register";
	}
	@RequestMapping(value="/dologin")
	public String login(User user, Model model){
		
		System.out.println("user:" + user);
		User user1 = userService.selectUser(user) ;
		System.out.println(user1);
		if(user1 == null){
			model.addAttribute("msg", "用户名或者密码错误！！");
			return "fail";
		}else {
			model.addAttribute("msg", "登录成功！！！");
			return "success";
		}
		
	}
	
	@RequestMapping(value="/doRegister")
	public String register(User user, Model model){
		Date d = new Date();
		user.setBirthday(d);
		int registerSuc = userService.insert(user);
		System.out.println("+++++++++++++++++++++"+registerSuc);
		if(registerSuc > 0){
			model.addAttribute("msg", "注册成功！！");
			return "fail";
		}else {
			model.addAttribute("msg", "注册失败！！！");
			return "success";
		}
	}
	

}
