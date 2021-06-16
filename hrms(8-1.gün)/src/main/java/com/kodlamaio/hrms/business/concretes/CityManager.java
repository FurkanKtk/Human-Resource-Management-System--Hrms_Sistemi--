package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.core.utulities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utulities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CityDao;
import com.kodlamaio.hrms.entities.concretes.City;

public class CityManager implements CityService {

	private CityDao cityDao;
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("City added.");
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(this.cityDao.getById(id));
	}

}
