package com.workshop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class Junit4TestApplication implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	MessageService messageService;
	
	public static void main(String[] args) {
		SpringApplication.run(Junit4TestApplication.class, args);	
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {
		messageService.sendMessage("Hello there..");
	}
}
