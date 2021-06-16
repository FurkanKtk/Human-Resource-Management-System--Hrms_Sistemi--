package com.kodlamaio.hrms.core.adapter.abstracts;

import com.kodlamaio.hrms.entities.concretes.JobSeekers;

public interface CheckMernisService {
	boolean checkIfRealPerson(JobSeekers jobSeekers);

}
