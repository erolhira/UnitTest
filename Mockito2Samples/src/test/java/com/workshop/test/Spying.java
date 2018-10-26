package com.workshop.test;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
 * Some of the behavior of a spy could be mocked if neened.
 * 
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Spying {

	@Spy
	MessageDao messageDaoMock;
	
	@InjectMocks
	MessageService messageService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSpy() {
		
		doReturn("mocked message").when(messageDaoMock).getMessageById(12);				
		
		messageService.printMessage(12);
		messageService.printMessage(2);
		messageService.printMessage(3);
	}
}
