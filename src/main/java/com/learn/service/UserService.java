package com.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.learn.entity.User;
import com.learn.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo ur;

	
	@Async
	public User saveUser(User user) {

		System.out.println(" inside saveUser" + Thread.currentThread().getId());

		return ur.save(user);
	}

	@Async
	public void sendEmail(User user) {

		try {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		System.out.println("email sent successfully"+ Thread.currentThread().getId());

	}

	public void sendNotification(User user) {
		

		try {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		System.out.println("Notifications sent successfully"+ Thread.currentThread().getId());
	

	}

}
