package com.mgj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgj.dao.UserDao;
import com.mgj.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public int getUser(User user) {
		User user2=userDao.getUser(user);
		return user2==null?0:1;
	}

}
