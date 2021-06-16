package com.kodlamaio.hrms.core.adapter.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kodlamaio.hrms.core.adapter.abstracts.SendEmailService;
import com.kodlamaio.hrms.core.utulities.results.Result;
import com.kodlamaio.hrms.core.utulities.results.SuccessResult;

@Component(value = "fakeSendEmailManager")
public class FakeSendEmailManager implements SendEmailService {

	@Autowired
	public FakeSendEmailManager() {
	}

	@Override
	public Result sendSimpleMessage(String to, String subject, String mailBodyMessage) {
		String mailTo = to;
        String mailSubject = subject;
        String mailText = mailBodyMessage;

        System.out.println(String.format("Kime : %s \nKonu başlığı %s. \nMail Gövdesi: %s",to,subject,mailBodyMessage));
        return new SuccessResult("Email Yolllandı");
	}

}
