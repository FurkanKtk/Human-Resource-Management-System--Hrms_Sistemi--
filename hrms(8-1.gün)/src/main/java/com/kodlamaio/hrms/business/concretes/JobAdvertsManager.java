package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobAdvertsService;

import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.ErrorDataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.core.utulities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utulities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import com.kodlamaio.hrms.dataAccess.abstracts.JobAdvertsDao;
import com.kodlamaio.hrms.entities.concretes.Employers;
import com.kodlamaio.hrms.entities.concretes.JobAdverts;
@Service
public class JobAdvertsManager implements JobAdvertsService {

	private JobAdvertsDao jobAdvertsDao;
	private EmployersDao employersDao;

	@Autowired
	public JobAdvertsManager(JobAdvertsDao jobAdvertsDao,EmployersDao employersDao) {
		super();
		this.jobAdvertsDao = jobAdvertsDao;
		this.employersDao = employersDao;
	}

	@Override
	public DataResult<List<JobAdverts>> getAll() {
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.findAll());
	}

	@Override
	public Result add(JobAdverts jobAdverts) {
		this.jobAdvertsDao.save(jobAdverts);
		return new SuccessResult("Job advert added");
	}
/*
	@Override
	public DataResult<List<JobAdverts>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"jobAdvertName");
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdverts>> getAll(int pagenNo, int pageSize) {
		Pageable pageable = PageRequest.of(pagenNo, pageSize);
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<JobAdverts> getByJobAdvertName(String jobAdvertName) {
		return new SuccessDataResult<JobAdverts>(this.jobAdvertsDao.getByJobAdvertName(jobAdvertName));
	}

	@Override
	public DataResult<JobAdverts> getByJobAdvertNameAndJobPositions(String jobAdvertName, int jobPositionsId) {
		return new SuccessDataResult<JobAdverts>(this.jobAdvertsDao.getByJobAdvertNameAndJobPositions_Id(jobAdvertName, jobPositionsId));
	}

	@Override
	public DataResult<List<JobAdverts>> getByJobAdvertNameAndEmployers(String jobAdvertName, int employersId) {
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.getByJobAdvertNameAndEmployers_Id(jobAdvertName, employersId));
	}

	@Override
	public DataResult<List<JobAdverts>> getByJobAdvertNameAndCity(String jobAdvertName, int cityId) {
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.getByJobAdvertNameAndCity_Id(jobAdvertName, cityId));
	}

	@Override
	public DataResult<List<JobAdverts>> getByNameAndCity(String jobAdvertName, int cityId) {
		return new SuccessDataResult<List<JobAdverts>>(this.jobAdvertsDao.getByNameAndCity(jobAdvertName, cityId));
	}*/

	@Override
	public DataResult<List<JobAdverts>> findAllByIsActive() {
		return new SuccessDataResult <List<JobAdverts>>(this.jobAdvertsDao.findAllByIsActive(true),"Başarılı");
	}

	@Override
	public DataResult<List<JobAdverts>> findAllByIsActiveSorted() {
		return new SuccessDataResult <List<JobAdverts>>(this.jobAdvertsDao.findAllByIsActiveOrderByPublishedDateDesc(true),"Başarılı");
	}

	@Override
	public DataResult<List<JobAdverts>> findAllByIsActiveAndCompanyName(int id) {
		if(!this.employersDao.existsById(id)) {
			return new ErrorDataResult("Hata: İş veren bulunamadı ");
		}
		else {
			return new SuccessDataResult <List<JobAdverts>>(this.jobAdvertsDao.getEmployersActiveJobAdvertisement(id),"Başarılı");
		}
	}

	@Override
	public DataResult<JobAdverts> setJobAdvertisementDisabled(int id) {
		if(!this.jobAdvertsDao.existsById(id)) {
			return new ErrorDataResult("Hata: İş veren bulunamadı");
		}
		JobAdverts ref =  this.jobAdvertsDao.getById(id);
		ref.setActive(false);
		return new SuccessDataResult <JobAdverts>(this.jobAdvertsDao.save(ref),"İş İlanı Pasif olarak ayarlandı");
	}
	
	
	

}
