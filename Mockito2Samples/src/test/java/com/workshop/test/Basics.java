package com.workshop.test;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Basics {
	
	/*
	 * @Mock will create a mock implementation for the LogService.
	 */
	@Mock
	MessageDao messageDaoMock;
	
	/*
	 * @InjectMocks will inject the mocks marked with @Mock to this MessageService instance when it is created.
	 */
	@InjectMocks
	MessageService messageService;
	
	@BeforeEach
	public void init() {
		//mock instance creation and injection is triggered with the call to initMocks.
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMock() {
		doCallRealMethod().when(messageDaoMock).getMessageById(anyInt());
		doReturn("mocked message").when(messageDaoMock).getMessageById(12);				
		
		messageService.printMessage(12);
		messageService.printMessage(2);
		messageService.printMessage(3);
	}
	
	

}
