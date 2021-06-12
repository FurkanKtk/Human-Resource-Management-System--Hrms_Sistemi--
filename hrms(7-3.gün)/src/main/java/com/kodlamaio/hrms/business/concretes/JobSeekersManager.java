package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobSeekersService;
import com.kodlamaio.hrms.core.adapter.abstracts.CheckMernisService;
import com.kodlamaio.hrms.core.adapter.abstracts.SendEmailService;
import com.kodlamaio.hrms.core.adapter.concretes.Genarator;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.ErrorResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.core.utulities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utulities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import com.kodlamaio.hrms.entities.concretes.JobSeekers;

@Service

public class JobSeekersManager implements JobSeekersService {

	private JobSeekersDao jobSeekersDao;
	private CheckMernisService checkMernisService;
	private SendEmailService sendEmailService;

	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao,
			@Qualifier("checkMernisAdapter") CheckMernisService checkMernisService,
			@Qualifier("fakeSendEmailManager") SendEmailService sendEmailService) {
		super();
		this.jobSeekersDao = jobSeekersDao;
		this.checkMernisService = checkMernisService;
		this.sendEmailService = sendEmailService;

	}

	private boolean validationForCandidate(JobSeekers jobSeekers) {
		if (Objects.isNull(jobSeekers.getIdentityNumber()) || Objects.isNull(jobSeekers.getName())
				|| Objects.isNull(jobSeekers.getSurname()) || Objects.isNull(jobSeekers.getEmail())
				|| Objects.isNull(jobSeekers.getPassword()) || Objects.isNull(jobSeekers.getDateOfBirth())) {
			return false;
		}

		return true;
	}

	@Override
	public DataResult<List<JobSeekers>> getAll() {
		return new SuccessDataResult<List<JobSeekers>>(this.jobSeekersDao.findAll(), "JobSeekers Listed");
	}

	public boolean confirmPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {

			return true;
		}
		return false;
	}

	@Override
	public Result add(JobSeekers jobSeekers, String confirmPassword) {
		if (!checkMernisService.checkIfRealPerson(jobSeekers)) {
			return new ErrorResult("Geçerli bir kişi değil");
		} else if (!validationForCandidate(jobSeekers)) {
			return new ErrorResult("Eksik bilgi girdiniz. Lütfen bilgilerinizi tekrar kontrol edin.");
		}
		if (getByEmail(jobSeekers.getEmail()).getdata() != null) {
			return new ErrorResult("Bu e-posta adresi zaten var.");

		}
		if(!isEmailValidation(jobSeekers.getEmail()))
		{
			return new ErrorResult("Geçersiz e-posta adresi. Lütfen e-posta adresinizi doğru giriniz.");
		}
		
		if (!this.confirmPassword(jobSeekers.getPassword(), confirmPassword)) {
			return new ErrorResult("Şifre eşleşmiyor. Lütfen şifrenizi tekrar girin.");
		}

		String genarator = Genarator.generateString();
		String mailBodyMessage = String.format("Kayıt işleminin tamamlanabilmesi için gerekli kod : %s ", genarator);

		this.jobSeekersDao.save(jobSeekers);
		this.sendEmailService.sendSimpleMessage(jobSeekers.getEmail(), "Kayıt Onaylama Hk.", mailBodyMessage);
		return new SuccessResult("Aday başarıyla eklendi." + mailBodyMessage);
	}

	@Override
	public DataResult<JobSeekers> getByEmail(String email) {
		return new SuccessDataResult<JobSeekers>(this.jobSeekersDao.findByEmail(email));
	}

	@Override
	public DataResult<JobSeekers> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<JobSeekers>(this.jobSeekersDao.findByIdentityNumber(identityNumber));
	}

	public static boolean isEmailValidation(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
				Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}

}
