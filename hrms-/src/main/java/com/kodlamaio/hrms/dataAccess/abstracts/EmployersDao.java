package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{
	
	Employers findByEmail(String email);

}
