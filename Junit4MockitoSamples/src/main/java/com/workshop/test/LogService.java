package com.workshop.test;

import org.springframework.stereotype.Service;

@Service
public class LogService {
	
	public void log(String log) {
		System.out.println(log);
	}
}
