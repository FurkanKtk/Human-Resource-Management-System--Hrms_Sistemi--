package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobPositionsService;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPositionsDao;
import com.kodlamaio.hrms.entities.concretes.JobPositions;

@Service
public class JobPositionsManager implements JobPositionsService {
	
	private JobPositionsDao jobPasitionsDao;
	

	@Autowired
	public JobPositionsManager(JobPositionsDao jobPasitionsDao) {
		super();
		this.jobPasitionsDao = jobPasitionsDao;
	}



	@Override
	public List<JobPositions> getAll() {
		return this.jobPasitionsDao.findAll();

	}

}
