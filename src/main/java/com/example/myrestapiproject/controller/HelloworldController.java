package com.example.myrestapiproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
	public String helloWorld() {
		return "Hello World";
	}
	@GetMapping("/hello-world-json")
	public UserDetails helloworldjson() {
		return new UserDetails("Jaiganesh", "Shanmugam", "Chennai");
	}

}
