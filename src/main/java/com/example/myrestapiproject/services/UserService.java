package com.example.myrestapiproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myrestapiproject.controller.Entity.User;
import com.example.myrestapiproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	public User saveUsers(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findUserbyID(Long id) {
		return userRepository.findById(id);
	}

	public User updateUser(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	public void deletebyID(Long id) {
		userRepository.deleteById(id);
	}

}
