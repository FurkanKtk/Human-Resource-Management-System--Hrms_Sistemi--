package com.kodlamaio.hrms.core.adapter.abstracts;

import com.kodlamaio.hrms.core.utulities.results.Result;

public interface SendEmailService {
	Result sendSimpleMessage(String to, String subject, String text);

}
