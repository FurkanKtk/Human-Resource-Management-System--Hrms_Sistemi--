package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.entities.concretes.JobPositions;

public interface JobPositionsService {
	
	List<JobPositions> getAll();

}
