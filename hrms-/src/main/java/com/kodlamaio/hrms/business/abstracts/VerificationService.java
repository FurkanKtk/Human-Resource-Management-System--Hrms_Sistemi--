package com.kodlamaio.hrms.business.abstracts;

public interface VerificationService {
	boolean sendVerificationCode(String emailAddress);

}
