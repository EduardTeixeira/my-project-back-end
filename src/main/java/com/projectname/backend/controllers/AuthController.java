package com.projectname.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectname.backend.models.GreetingModel;
import com.projectname.backend.models.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User request) {

		return new ResponseEntity<String>("Greeting - POST", HttpStatus.OK);

	}

	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody User request) {

		return new ResponseEntity<String>("Greeting - POST", HttpStatus.OK);

	}
	
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshToken(@RequestBody User request) {

		return new ResponseEntity<String>("Greeting - POST", HttpStatus.OK);

	}

}
