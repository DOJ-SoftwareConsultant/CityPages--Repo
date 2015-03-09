package com.doj.citypages.services;

import com.doj.citypags.entities.Users;

public interface IUserService {
	
	public Users create(Users user);

	public Users findUserById(int id);

	public Users login(String email, String password);

}
