package com.example.myrestapiproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myrestapiproject.controller.Entity.User;
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
		return userService.saveUsers(user);
	}
	
	@GetMapping("/get-userby-id/{id}")
	public Optional<User> findUserbyID(@PathVariable Long id) {
		return userService.findUserbyID(id);
	}
	
	@PostMapping("/update-user/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@GetMapping("/delete-user/{id}")
	public void deletebyID(@PathVariable Long id) {
		userService.deletebyID(id);
	}
	
	

}
