package com.social.pixogram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.pixogram.model.User;
import com.social.pixogram.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<User> getUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(new User(user.getName(), user.getEmail(), user.getPassword()));
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		return (Optional<User>) userRepo.findById(userId);
	}
	
	@Override
	public User checkUser(String name) {
		return userRepo.checkUser(name);
	}

	@Override
	public List<User> findByUserAndPassword(String username, String password) {
		return userRepo.findByUserAndPassword(username, password);
	}

	@Override
	public List<User> searchUserByName(String value) {
		// TODO Auto-generated method stub
		return userRepo.serachUserByName(value);
	}

	@Override
	public List<User> searchNotFollowed(long id,String value) {
		// TODO Auto-generated method stub
		return userRepo.searchNotFollowed(id, value);
	}
}
