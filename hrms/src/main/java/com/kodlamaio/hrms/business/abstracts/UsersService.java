package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.entities.Users;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;

public interface UsersService {
	DataResult<List<Users>> getAll();
	Result add(Users users);

}
