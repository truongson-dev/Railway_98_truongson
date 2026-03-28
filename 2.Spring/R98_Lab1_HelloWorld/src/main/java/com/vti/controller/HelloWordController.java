package com.vti.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.form.AccountFormForCreating;

@RestController
@RequestMapping(value = "api/v1/helloworld")
@CrossOrigin("*")
public class HelloWordController {
	@GetMapping()
	public String getHello(@RequestParam("search") String searchParam, @RequestParam("fillter") String fitterParam) {
		System.out.println("searchParam: " + searchParam);
		System.out.println("fillterParam:" + fitterParam);
		return searchParam + " " + fitterParam;
	}

	@PostMapping()
	public String createAccount(@RequestBody AccountFormForCreating form) {
		System.out.println("User: " + form.getUser());
		System.out.println("Email: " + form.getEmail());
		System.out.println("FullName: " + form.getFullname());
		return "Data: " + form.getUser() + " " + form.getEmail() + " " + form.getFullname();
	}

	@PutMapping()
	public String UpdateHello() {
		return "Update Hello";
	}

// http://localhost:8800/api/v1/helloworldId?search=java
	@DeleteMapping("/{id}")
	public String DeleteHello(@PathVariable("id") int id) {
		return "Bạn vừa xóa bản ghi: " + id;
	}
}
