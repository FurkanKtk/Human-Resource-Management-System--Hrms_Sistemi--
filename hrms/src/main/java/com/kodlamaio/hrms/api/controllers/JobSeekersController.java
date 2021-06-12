package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobSeekersService;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobPositions;
import com.kodlamaio.hrms.entities.concretes.JobSeekers;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {

	@Autowired
	JobSeekersService jobSeekersService;

	public JobSeekersController(JobSeekersService jobSeekersService) {
		super();
		this.jobSeekersService = jobSeekersService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobSeekers>> getAll() {
		return this.jobSeekersService.getAll();
	}

	@PostMapping("/add")
	public Result registerJobSeekers(@RequestBody JobSeekers jobSeekers ,String confirmPassword) {
		return this.jobSeekersService.add(jobSeekers, confirmPassword) ;

	}
}
