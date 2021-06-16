package com.kodlamaio.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.AuthService;
import com.kodlamaio.hrms.business.abstracts.EmployersService;
import com.kodlamaio.hrms.business.abstracts.JobSeekersService;
import com.kodlamaio.hrms.business.abstracts.VerificationService;
import com.kodlamaio.hrms.core.utulities.results.ErrorResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.core.utulities.results.SuccessResult;
import com.kodlamaio.hrms.entities.concretes.Employers;
import com.kodlamaio.hrms.entities.concretes.JobSeekers;

@Service
public class AuthManager implements AuthService {
	
	private EmployersService employersService;
	private JobSeekersService jobSeekersService;
	private VerificationService verificationService;

	@Autowired
	public AuthManager(EmployersService employersService, JobSeekersService jobSeekersService,
			VerificationService verificationService) {
		super();
		this.employersService = employersService;
		this.jobSeekersService = jobSeekersService;
		this.verificationService = verificationService;
	}
	
	public static boolean isEmailValidation(String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
	public boolean confirmPassword(String password,String confirmPassword) 
    {    
        if (password.equals(confirmPassword)) {
            
            return true;
        }
        return false;
    }

	@Override
	public Result registerEmployer(Employers employers, String confirmPassword) {
		if(!isEmailValidation(employers.getEmail()))
		{
			return new ErrorResult("Invalid email address. Please enter your email address correctly.");
		}
		
		if(!this.confirmPassword(employers.getPassword(), confirmPassword)) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}
		//var result = this.employersService.add(employers);
		
		//if(result.isSuccess()) {
			if(this.verificationService.sendVerificationCode(employers.getEmail())) {
				return new SuccessResult("Employer Registered.");
			}
		//}
		
		return new ErrorResult();
	}

	@Override 
	public Result registerJobSeekers(JobSeekers jobSeekers, String confirmPassword) {
		if(!isEmailValidation(jobSeekers.getEmail()))
		{
			return new ErrorResult("Geçersiz e-posta adresi. Lütfen e-posta adresinizi doğru giriniz.");
		}
		if(!this.confirmPassword(jobSeekers.getPassword(), confirmPassword)) {
			return new ErrorResult("Şifre eşleşmiyor. Lütfen şifrenizi tekrar girin.");
		}
       // var result = this.jobSeekersService.add(jobSeekers);
		
	//	if(result.isSuccess()) {
			if(this.verificationService.sendVerificationCode(jobSeekers.getEmail())) {
				return new SuccessResult("İşveren Kayıtlı.");
			}
		//}
		return new ErrorResult();
	}

}
