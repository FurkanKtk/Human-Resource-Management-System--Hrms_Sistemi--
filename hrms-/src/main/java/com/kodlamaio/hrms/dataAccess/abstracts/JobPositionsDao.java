package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.JobPositions;

public interface JobPositionsDao extends JpaRepository<JobPositions	, Integer> {
	
	//JobPositions getByJobPositions(String jobTitle);

}
