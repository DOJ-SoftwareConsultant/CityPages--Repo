package com.doj.citypages.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doj.citypages.entities.Users;
import com.doj.citypages.exception.UserNotFoundException;
import com.doj.citypages.repositories.UserRepository;
import com.doj.citypages.services.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Resource
	private UserRepository userRepository;

	@Transactional
	public Users create(Users user) {
		return userRepository.save(user);
	}

	@Transactional(rollbackFor=UserNotFoundException.class)
	public Users findUserById(int id) {
      return userRepository.findOne(id);
	}

	@Override
	public Users login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
