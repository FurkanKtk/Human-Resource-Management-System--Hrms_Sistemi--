package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employers;

public interface EmployersService {
	DataResult<List<Employers>>getAll();
	//Result add(Employers employers);
	DataResult<Employers>getByEmail(String email);
	Result add(Employers employers, String confirmPassword);

}
