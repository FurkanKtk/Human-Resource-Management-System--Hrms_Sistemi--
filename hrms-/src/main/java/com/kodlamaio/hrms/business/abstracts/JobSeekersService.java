package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobSeekers;

public interface JobSeekersService {
	DataResult<List<JobSeekers>> getAll();

	//Result add(JobSeekers jobSeekers);

	// DataResult<JobSeekers> findByEmail(String email);

	// DataResult<JobSeekers> findByIdentityNumber(String identityNumber);

	DataResult<JobSeekers > getByEmail(String email);
	DataResult<JobSeekers > getByIdentityNumber(String identityNumber);
//Result register(JobSeekersDto jobSeekeres );

	Result add(JobSeekers jobSeekers, String confirmPassword);

}
