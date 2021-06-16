package com.kodlamaio.hrms.core.adapter.concretes;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.adapter.abstracts.CheckMernisService;
import com.kodlamaio.hrms.entities.concretes.JobSeekers;

@Service
public class CheckFakeMernisAdapter implements CheckMernisService {

	@Override
	public boolean checkIfRealPerson(JobSeekers jobSeekers) {
		return true;
	}

}
