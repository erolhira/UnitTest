package com.workshop.test;

import org.springframework.stereotype.Repository;

@Repository
public class MessageDao {
	
	public String getMessageById(Integer id) {
		return "this is message with " + id;
	}
}
