package com.example.myrestapiproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.myrestapiproject.controller.Entity.User;
import com.example.myrestapiproject.exceptions.UserExistsException;
import com.example.myrestapiproject.exceptions.UserNotFoundException;
import com.example.myrestapiproject.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/get-all-users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();

	}

	@PostMapping("/save-user")
	public User saveUsers(@RequestBody User user) {
		try {
			return userService.saveUsers(user);
		} catch (UserExistsException e) {
		throw new ResponseStatusException(HttpStatus.FOUND, e.getMessage());
		}
	}

	@GetMapping("/get-userby-id/{id}")
	public Optional<User> findUserbyID(@PathVariable Long id) {
		try {
			return userService.findUserbyID(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping("/update-user/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {

		try {
			return userService.updateUser(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/delete-user/{id}")
	public void deletebyID(@PathVariable Long id) {
		try {
			userService.deletebyID(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
