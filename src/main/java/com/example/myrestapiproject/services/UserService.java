package com.example.myrestapiproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myrestapiproject.controller.Entity.User;
import com.example.myrestapiproject.exceptions.UserExistsException;
import com.example.myrestapiproject.exceptions.UserNotFoundException;
import com.example.myrestapiproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	public User saveUsers(User user) throws UserExistsException {
		String userName = user.getUserName();
		List<User> users = userRepository.findByUserName(userName);
		if (!users.isEmpty()) {
			throw new UserExistsException("User already present in the database");
		}
		return userRepository.save(user);
	}

	public Optional<User> findUserbyID(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not present in the database");
		}
		return user;
	}

	public User updateUser(Long id, User user) throws UserNotFoundException {

		Optional<User> user1 = userRepository.findById(id);
		if (!user1.isPresent()) {
			throw new UserNotFoundException("User not present in the database for the update");
		}
		user.setId(id);
		return userRepository.save(user);
	}

	public void deletebyID(Long id) throws UserNotFoundException {

		Optional<User> user1 = userRepository.findById(id);
		if (!user1.isPresent()) {
			throw new UserNotFoundException("User not present in the database for the delete");
		}
		userRepository.deleteById(id);
	}

}
