package com.kodlamaio.hrms.core.adapter.concretes;

import java.util.UUID;

public class Genarator {
	public static String generateString() {
        String uuid=UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}
