package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employers;
import com.kodlamaio.hrms.entities.concretes.JobSeekers;

public interface AuthService {
	Result registerEmployer(Employers employers,String confirmPassword);
	Result registerJobSeekers(JobSeekers jobSeekers ,String confirmPassword);

}
