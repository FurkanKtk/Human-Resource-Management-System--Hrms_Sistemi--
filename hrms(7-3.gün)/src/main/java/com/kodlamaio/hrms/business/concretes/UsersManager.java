package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.UsersService;
import com.kodlamaio.hrms.core.dataAccess.UserDao;
import com.kodlamaio.hrms.core.entities.Users;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.core.utulities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utulities.results.SuccessResult;

@Service
public class UsersManager implements UsersService{
	private UserDao userDao;

	public UsersManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>(this.userDao.findAll());
	}

	@Override
	public Result add(Users users) {
		this.userDao.save(users);
		return new SuccessResult("User added.");
	}

}
