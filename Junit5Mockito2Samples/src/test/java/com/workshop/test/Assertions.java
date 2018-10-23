package com.workshop.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
 * Assertions are used to test a condition that must evaluate to true in order for the test to continue executing.
 * 
 * If an assertion fails, the test is halted at the line of code where the assertion is located, and the assertion failure is reported. 
 * If the assertion succeeds, the test continues to the next line of code.
 * 
 * 
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Assertions extends TestBase {

	@Autowired
	private MessageService messageService;
	
	@Test
	public void testAssertions() {
		
		assertEquals(1, 1);
		assertTrue(messageService.isTest());
		assertNotNull(null);
	}
	
	@Test
	public void testAssertAll() {
		
		assertAll("Assert all of these",
				() -> assertEquals(1, 1, "not equals"),
				() -> assertFalse(false)
		);
	}
	
	/*
	 * use assertThrows when the method under test is expected to throw an exception.
	 */
	@Test
	@DisplayName("Empty argument")
	public void testAssertThrows() {
		if(true) {			
			//If the call to second parameter does not throw an IllegalArgumentException, then the assertion fails.
			assertThrows(IllegalArgumentException.class, () -> System.out.println("assertion fails since since IllegalArgumentException is not thrown here."));
		}
	}
	
	
	
}
