package com.workshop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private LogService logService;
	
	public String sendMessage(String message) {
		
		logService.log("message sent --> " + message);
		return message;
	}
	
}
