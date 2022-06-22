package com.projectname.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectname.backend.model.Greeting;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {

	@GetMapping("")
	public ResponseEntity<?> getAll() {

		return new ResponseEntity<String>("Greeting - GET", HttpStatus.OK);

	}

	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Greeting request) {

		return new ResponseEntity<String>("Greeting - POST", HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Greeting request) {

		return new ResponseEntity<String>("Greeting - PUT " + id, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {

		return new ResponseEntity<String>("Greeting - DELETE " + id, HttpStatus.OK);

	}

}
