package com.projectname.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectname.backend.models.GreetingModel;
import com.projectname.backend.models.User;
import com.projectname.backend.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public @ResponseBody Iterable<User> getAll() {

		return userService.getAll();

	}

	@PostMapping("")
	public @ResponseBody String create(@RequestBody User request) {

		return userService.create(request);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User request) {

		return new ResponseEntity<String>("Greeting - PUT " + id, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {

		return new ResponseEntity<String>("Greeting - DELETE " + id, HttpStatus.OK);

	}

}
