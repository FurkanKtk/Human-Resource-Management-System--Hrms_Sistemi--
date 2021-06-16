package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.kodlamaio.hrms.entities.concretes.JobSeekers;

@Repository
public interface JobSeekersDao  extends JpaRepository<JobSeekers, Integer>{
	
	JobSeekers findByEmail(String email);
    JobSeekers findByIdentityNumber(String identityNumber);
    
    //boolean existsByIdentityNumber(String identityNumber);
	//boolean existsByEmail(String email);
	//JobPositions findByJobTitle(String jobTitle);

}
