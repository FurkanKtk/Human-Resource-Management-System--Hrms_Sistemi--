package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobPositionsService;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobPositions;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {
	
	@Autowired
	private JobPositionsService jobPositionsService;
	
	public JobPositionsController(JobPositionsService jobPositionsController) {
		super();
		this.jobPositionsService = jobPositionsController;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobPositions>> getAll() {
        return this.jobPositionsService.getAll();
	
}
	@GetMapping("/getbyname")
    public DataResult<JobPositions> getByPositionName(String jobTitle) {
        return this.jobPositionsService.getByPositionName(jobTitle);
    }
	@PostMapping("/add")
	public Result add(@RequestBody JobPositions jobPositions) {
		return this.jobPositionsService.add(jobPositions);
	}
	
	

}
