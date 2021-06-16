package com.kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.AuthService;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employers;
import com.kodlamaio.hrms.entities.concretes.JobSeekers;

@RestController
@RequestMapping("/api/auths")
public class AuthControlller {
	private AuthService authService;

	@Autowired
	public AuthControlller(AuthService authService) {
		super();
		this.authService = authService;
	}
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employers employers,String confirmPassword) {
		return this.authService.registerEmployer(employers, confirmPassword);
	}
	

	@PostMapping("/registerCandidate")
	public Result registerJobSeekers(@RequestBody JobSeekers jobSeekers ,String confirmPassword) {
		return this.authService.registerJobSeekers (jobSeekers, confirmPassword);
	}

}
