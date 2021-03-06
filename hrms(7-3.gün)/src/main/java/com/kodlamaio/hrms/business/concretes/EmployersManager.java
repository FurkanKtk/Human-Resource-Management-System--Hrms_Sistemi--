package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployersService;
import com.kodlamaio.hrms.core.adapter.abstracts.SendEmailService;
import com.kodlamaio.hrms.core.adapter.concretes.Genarator;
import com.kodlamaio.hrms.core.utulities.results.DataResult;
import com.kodlamaio.hrms.core.utulities.results.ErrorResult;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.core.utulities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utulities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import com.kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService {

	private EmployersDao employersDao;
	private SendEmailService sendEmailService;

	@Autowired
	public EmployersManager(EmployersDao employersDao,
			@Qualifier("fakeSendEmailManager") SendEmailService sendEmailService) {
		super();
		this.employersDao = employersDao;
		this.sendEmailService = sendEmailService;
	}

	private boolean checkIfEmailExists(String email) {
		if (this.employersDao.findByEmail(email) != null) {
			return false;
		}
		return true;
	}

	private boolean validationForEmployer(Employers employers) {
		if (Objects.isNull(employers.getCompanyName()) || Objects.isNull(employers.getWebsite())
				|| Objects.isNull(employers.getEmail()) || Objects.isNull(employers.getPhoneNumber())
				|| Objects.isNull(employers.getPassword())) {
			return false;
		}

		return true;
	}

	@Override
	public DataResult<List<Employers>> getAll() {
		return new SuccessDataResult<List<Employers>>(this.employersDao.findAll(), "Employers Listed");
	}

	public boolean confirmPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {

			return true;
		}
		return false;
	}

	@Override
	public Result add(Employers employers, String confirmPassword) {
		if (!this.checkIfEmailExists(employers.getEmail())) {
			return new ErrorResult("Bu e-posta adresi zaten var.");
		}
		if (!this.validationForEmployer(employers)) {
			return new ErrorResult("Eksik bilgi girdiniz. L??tfen bilgilerinizi tekrar kontrol edin.");
		}
		if (!this.confirmPassword(employers.getPassword(), confirmPassword)) {
			return new ErrorResult("??ifre e??le??miyor. L??tfen ??ifrenizi tekrar girin.");
		}
		if (!isEmailValidation(employers.getEmail())) {
			return new ErrorResult("Ge??ersiz e-posta adresi. L??tfen e-posta adresinizi do??ru giriniz.");
		}

		String genarator = Genarator.generateString();
		String mailBodyMessage = String.format("Kay??t i??leminin tamamlanabilmesi i??in gerekli kod : %s ", genarator);

		this.employersDao.save(employers);
		this.sendEmailService.sendSimpleMessage(employers.getEmail(), "Kay??t Onaylama Hk.", mailBodyMessage);
		return new SuccessResult("????veren ba??ar??yla eklendi.");

	}

	@Override
	public DataResult<Employers> getByEmail(String email) {
		return new SuccessDataResult<Employers>(this.employersDao.findByEmail(email));
	}

	public static boolean isEmailValidation(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
				Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}

}
