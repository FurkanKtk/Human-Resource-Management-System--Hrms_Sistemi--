package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobPositions;

public interface JobPositionsService {
	
	//List<JobPositions> getAll();
	DataResult<List<JobPositions>> getAll();
	DataResult<JobPositions> getByPositionName(String jobTitle);

	Result add(JobPositions jobPositions);
	
	

}
