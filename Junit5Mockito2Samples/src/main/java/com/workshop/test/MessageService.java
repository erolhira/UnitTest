package com.workshop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
public class MessageService {
	
	@Autowired
	private LogService logService;
	
	@Getter
	private boolean test = true;
	
	public String sendMessage(String message) {
		
		logService.log("message sent --> " + message);
		return message;
	}
	
}
