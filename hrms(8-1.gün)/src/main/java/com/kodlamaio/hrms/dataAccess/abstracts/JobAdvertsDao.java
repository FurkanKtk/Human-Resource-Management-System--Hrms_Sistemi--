package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaio.hrms.entities.concretes.JobAdverts;

public interface JobAdvertsDao extends JpaRepository<JobAdverts, Integer>{
	//List<JobAdverts> getByJobAdvertNameAndEmployers_Id(String jobAdvertName, int employersId);
	
	//JobAdverts getByJobAdvertNameAndJobPositions_Id(String jobAdvertName, int jobPositionsId);
	
	//List<JobAdverts> getByJobAdvertNameAndCity_Id(String jobAdvertName, int cityId);
	/*JobAdverts getByJobAdvertName(String jobAdvertName);
	@Query("From JobAdverts where jobAdvertName=:jobAdvertName and city.id=:cityId")
	List<JobAdverts> getByNameAndCity(String jobAdvertName, int cityId);*/
	
	List<JobAdverts> getOneById(int id);
	List<JobAdverts> findAllByIsActive(boolean isActive);
	List<JobAdverts> findAllByIsActiveOrderByPublishedDateDesc(boolean isActive);
	@Query("From JobAdverts where isActive = true and employer_id =:id")
	List<JobAdverts> getEmployersActiveJobAdvertisement(int id);
	
	//@Query("From JobAdverts where isConfirmed = true")
	//List<JobAdverts> getConfirmedJobAdvertisements();
	
	//@Query("From JobAdverts where isConfirmed = false")
	//List<JobAdverts> getWaitingJobAdvertisements();
	
}


