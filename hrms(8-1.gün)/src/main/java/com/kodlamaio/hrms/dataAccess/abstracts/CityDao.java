package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	City getById(int id);

}
