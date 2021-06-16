package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobAdvertsService;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;

import com.kodlamaio.hrms.entities.concretes.JobAdverts;

@RestController
@RequestMapping("/api/jobAdvertsController")
public class JobAdvertsController {

	private JobAdvertsService jobAdvertsService;

	@Autowired
	public JobAdvertsController(JobAdvertsService jobAdvertsService) {
		super();
		this.jobAdvertsService = jobAdvertsService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdverts>> getAll() {
		return this.jobAdvertsService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdverts jobAdverts) {
		return this.jobAdvertsService.add(jobAdverts);
	}
	/*
	@GetMapping("/getAllByPage")
	DataResult<List<JobAdverts>> getAll(int pageNo, int pageSize){
		return this.jobAdvertsService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<JobAdverts>> getAllSorted() {
		return this.jobAdvertsService.getAllSorted();
	}
	
	@GetMapping("/getByNameJobAdvert")
	public DataResult<JobAdverts> getByProductName(@RequestParam String productName){
		return this.jobAdvertsService.getByJobAdvertName(productName);
	}*/
	
	@GetMapping("/getallactive")
	public DataResult<List<JobAdverts>>  getAllActive(){
		return this.jobAdvertsService.findAllByIsActive();
	}
	@GetMapping("/getallactivesorted")
	public DataResult<List<JobAdverts>>  getAllActiveSorted(){
		return this.jobAdvertsService.findAllByIsActiveSorted();
	}
	@PostMapping("/jobAdvertisementDisable")
	public DataResult<JobAdverts> setJobAdvertisementDisabled(int id) {
		return this.jobAdvertsService.setJobAdvertisementDisabled(id);
	}
}
