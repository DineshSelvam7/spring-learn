package com.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.User;
import com.learn.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;

	@PostMapping("/post")
	public String postMethodName(@RequestBody User user) {

		
		//synch
		User dbuser = us.saveUser(user);

		//Asynch
		us.sendEmail(user);
		
		us.sendNotification(user);

		return "User Registered successfully" + "   "+dbuser.getId();
	}

}
