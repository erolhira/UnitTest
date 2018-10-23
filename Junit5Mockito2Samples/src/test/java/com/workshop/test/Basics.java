package com.workshop.test;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@RunWith(JUnitPlatform.class) //for with junit runner
public class Basics extends TestBase {
	
	@Autowired
	private MessageService messageService;
		
	
	@Test
	public void simpleTest() {		
		assertTrue(true);
	}
	
	/*
	 * The annotated method will not be executed (it will be skipped), but reported as such.
	 * equivalent of @Ignore in Junit4
	 */
	@Disabled @Test
	public void ignoredTest() {
		System.out.println("Disabled so not run.");
	}

	@Test
	//@EnabledIf(expression = "${tests.enabled}", loadContext = true)
	@DisabledIf(expression="false")
	public void ignoreIf() {
		System.out.println("in ignoreIf");
	}
	
	
}
