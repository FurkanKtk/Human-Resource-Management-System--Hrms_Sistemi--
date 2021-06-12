package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.UsersService;
import com.kodlamaio.hrms.core.entities.Users;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UsersService usersService;

	public UserController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}
	@GetMapping("/getall")
	public DataResult<List<Users>> getAll(){
		return this.usersService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Users product) {
		return this.usersService.add(product);
	}
}
