package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.EmployersService;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employers;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	private EmployersService employersService;

	@Autowired
	public EmployersController(EmployersService employersService) {
		super();
		this.employersService = employersService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Employers>> getAll(){
		return this.employersService.getAll();
	}
	
	@GetMapping("/getByEmail")
	public DataResult<Employers> getByEmail(String email){
		return this.employersService.getByEmail(email);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employers employer,String confirmPassword) {
		return this.employersService.add(employer,confirmPassword);
	}

}
