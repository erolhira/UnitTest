package com.workshop.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
 * Assumptions are useful when a test method should only be executed under certain conditions.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Assumptions extends TestBase {

	/*
	 * If the condition of the assumption doesn't hold, then the test is skipped. This doesn't affect the "green" of the project, 
	 * and won't cause the build to fail; all of the code in test method after assumeTrue() is simply skipped.
	 */
	@Test
	public void testAssume() {
		
		LocalDateTime ld = LocalDateTime.now();
		assumeTrue(ld.isAfter(LocalDateTime.now())); //always false
		assertTrue(false); //not fails since assumption not allows the test to go on..
	}
	
	/*
	 * In cases where only a portion of the test method should execute if an assumption holds, 
	 * you could write the above condition with the assumingThat() method, which uses lambda syntax:
	 * 
	 * Note that everything after the lambda will execute, regardless of whether the assumption in assumingThat() holds.
	 */
	@Test
	public void testAssumeThat() {
		
		LocalDateTime ldt = LocalDateTime.now();
		assumingThat(ldt.isBefore(LocalDateTime.now()), () -> {
			// Execute this code if assumption holds...
		});
		// Execute here regardless..
	}
}
