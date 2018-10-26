package com.workshop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private MessageDao messageDao;
	
	public void printMessage(Integer messageId) {
		
		String message = messageDao.getMessageById(messageId);
		System.out.println(message);
	}
}
