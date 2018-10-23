package com.workshop.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class TestBase {

	/*
	 * The annotated (static) method will be executed once before any @Test method in the current class.
	 * equivalent of @BeforeClass in Junit4
	 */
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Test is starting..");
	}
	
	/*
	 * The annotated (static) method will be executed once after all @Test methods in the current class.
	 * equivalent of @AfterClass in Junit4
	 */
	@AfterAll
	public static void afterAll() {
		System.out.println("Test is ended..");
	}
	
	/*
	 * equivalent of @Before in Junit4
	 */
	@BeforeEach
	public void beforeEach(TestInfo testInfo) {
		System.out.println("running test --> " + testInfo.getTestMethod().get().getName());
	}
	
	/*
	 * equivalent of @After in Junit4
	 */
	@AfterEach
	public void afterEach(TestInfo testInfo) {
		System.out.println("ended test --> " + testInfo.getTestMethod().get().getName());
	}
}
