package com.kodlamaio.hrms.core.adapter.concretes;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.adapter.abstracts.CheckMernisService;
import com.kodlamaio.hrms.entities.concretes.JobSeekers;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class CheckMernisAdapter implements CheckMernisService {

	@Override
	public boolean checkIfRealPerson(JobSeekers jobSeekers) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

        boolean serviceResult=false;

        try {

            serviceResult = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeekers.getIdentityNumber()),
            		jobSeekers.getName().toUpperCase(),
            		jobSeekers.getSurname().toUpperCase(),
            		jobSeekers.getDateOfBirth());

        } catch (Exception e) {

            System.out.println("Not a valid person");
        }

       return serviceResult;
	}

}
