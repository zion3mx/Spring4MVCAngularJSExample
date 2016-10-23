package com.websystique.springmvc.repository;

import java.util.List;

import com.websystique.springmvc.model.User;


public interface UserRepository {

	public List<User> findAllUsers();
	
	public User findById(long id);

	public int saveUser(User user);

	public int updateUser(User user);

	public int deleteUserById(long id);

	public int deleteAllUser();

	public User findByName(String username);
}
