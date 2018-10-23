package com.workshop.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *  JUnit Jupiter is the API for writing tests using JUnit version 5.
 *********************************************************************  
 *  junit-jupiter-api: provides the public API for writing tests and extensions.
 *  junit-jupiter-engine: contains the implementation of the JUnit Jupiter test engine. This dependency is required only at runtime.
 *  	What a test engine does:
 *  	- Discovery of tests and the creation of a test plan.
 *  junit-vintage-engine: adds support for unit tests that use JUnit 4 or JUnit 3. Again, this dependency is required only at runtime.
 *  junit-platform-launcher: provides a public API for configuring and launching tests. This API is typically used by IDEs and build tools.
 *  	What a launcher does :
 *  	- Launching the test plan in order to (1) execute tests and (2) report results to the user.
 *  junit-platform-runner: allows us to run tests and test suites in a JUnit 4 environment.
 *  
 *********************************************************************
 *  opentest4j: JUnit 5 uses the opentest4j exceptions.
 *********************************************************************
 *
 *********************************************************************
 *
 *********************************************************************
 */

@SpringBootApplication
public class Junit5Mockito2SamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Junit5Mockito2SamplesApplication.class, args);
	}
}
