package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.City;

public interface CityService {
	Result add (City city);
    DataResult<List<City>> getAll();
    DataResult<City> getById(int id);
}
