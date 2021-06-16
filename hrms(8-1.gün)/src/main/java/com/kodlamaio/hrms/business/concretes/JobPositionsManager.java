package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobPositionsService;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.ErrorResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.core.utulities.results.SuccessDataResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPositionsDao;
import com.kodlamaio.hrms.entities.concretes.JobPositions;

import com.kodlamaio.hrms.core.utulities.results.SuccessResult;

@Service
public class JobPositionsManager implements JobPositionsService {

	private JobPositionsDao jobPasitionsDao;

	@Autowired
	public JobPositionsManager(JobPositionsDao jobPasitionsDao) {
		super();
		this.jobPasitionsDao = jobPasitionsDao;
	}

	@Override
	public DataResult<List<JobPositions>> getAll() {
		return new SuccessDataResult<List<JobPositions>>(this.jobPasitionsDao.findAll(), "Listelendi");

	}

	@Override
	public DataResult<JobPositions> getByPositionName(String jobTitle) {
		return new SuccessDataResult<JobPositions>(this.jobPasitionsDao.findByJobTitle(jobTitle));
	}
	private boolean checkIfPositionExists(String jobTitle) {
		if(this.jobPasitionsDao.findByJobTitle(jobTitle) != null) {
			return false;
		}
		return true;
		}

	@Override
	public Result add(JobPositions jobPositions) {
	if(!this.checkIfPositionExists(jobPositions.getJobTitle())) {
		return new ErrorResult("This position already exists in the system.");
	}
	this.jobPasitionsDao.save(jobPositions);
	return new SuccessResult("Job position added");
}
	/*{
		if (jobPositions.getJobTitle() == null || jobPositions.getJobTitle() == "")
			return new ErrorResult("İş pozisyon ismi boş bırakılamaz.");
		else if (getByPositionName(jobPositions.getJobTitle()) != null)
			return new ErrorResult("Aynı isimde iki adet iş pozisyonu oluşturulamaz.");
		this.jobPasitionsDao.save(jobPositions);
		return new SuccessResult("İş pozisyonu başarıyla eklendi.");
	}*/

}
