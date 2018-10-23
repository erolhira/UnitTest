package com.workshop.test;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NestedTests extends TestBase {

	@Nested
	class NamingTests {
		
		@Test
		void testName() {
			assertAll(() -> "John".contains("hn"));
		}
		
		@Test
		void testSurname() {
			assertAll(() -> "Mohn".contains("Mo"));
		}
	}
	
	@Nested
	class AgeTests {
		
		@Test
		void testAge() {
			assertAll(() -> "27".contains("2"));
		}
	}
}
