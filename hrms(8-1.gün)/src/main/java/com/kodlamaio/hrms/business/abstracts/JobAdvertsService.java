package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobAdverts;

public interface JobAdvertsService {
	DataResult<List<JobAdverts>> getAll();

	Result add(JobAdverts jobAdverts);
	
	/*DataResult<List<JobAdverts>> getAllSorted();
    DataResult<List<JobAdverts>> getAll(int pagenNo, int pageSize);
	DataResult<JobAdverts> getByJobAdvertName(String jobAdvertName);
	DataResult<JobAdverts> getByJobAdvertNameAndJobPositions(String jobAdvertName, int jobPositionsId);
	DataResult<List<JobAdverts>> getByJobAdvertNameAndEmployers(String jobAdvertName, int employersId);
	DataResult<List<JobAdverts>> getByJobAdvertNameAndCity(String jobAdvertName, int cityId);
	DataResult<List<JobAdverts>> getByNameAndCity(String jobAdvertName, int cityId);*/

	
	DataResult<List<JobAdverts>> findAllByIsActive();
	DataResult<List<JobAdverts>> findAllByIsActiveSorted();
	DataResult<List<JobAdverts>> findAllByIsActiveAndCompanyName(int id);
	DataResult<JobAdverts> setJobAdvertisementDisabled(int id);
}
