package com.websystique.springmvc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

    private static List<User> users;
	
    @Autowired
    public UserRepository userRepository;
    
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
	
	public User findById(long id) {
		return userRepository.findById(id);
	}
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public void saveUser(User user) {
		userRepository.saveUser(user);
	}

	public void updateUser(User user) {
		userRepository.updateUser(user);
	}

	public void deleteUserById(long id) {
		userRepository.deleteUserById(id);
	}

	public boolean isUserExist(User user) {
		return userRepository.findByName(user.getUsername()) != null;
	}
	
	public void deleteAllUsers(){
		userRepository.deleteAllUser();
	}

}
