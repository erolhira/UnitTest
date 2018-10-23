package com.workshop.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
 * A parameterized test is one where the @Test method is invoked multiple times with different parameter values each time. 
 * A parameterized test must be annotated with @ParameterizedTest, and must specify a source for its arguments.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ParametrizedTests {

	/*
	 * supported primitives: String --> strings int --> ints long --> longs double
	 * --> doubles
	 */
	@ParameterizedTest
	@ValueSource(longs = { 1L, 2L, 3L, 4L, 5L })
	public void valueSourceTest(Long id) {
		assertTrue(id < 5);
	}

	@ParameterizedTest
	@EnumSource(TestEnum.class)
	public void enumSourceTest(TestEnum status) {
		assertEquals(TestEnum.ACTIVE, status);
	}
	
	/*
	 * The return type of a provider method source must be Stream, Iterator, Iterable, or array. 
	 * In addition, the provider method must be declared static.
	 */
	@ParameterizedTest
	@MethodSource(value = "nameProvider")
	public void methodSourceTest(String name) {
		assertEquals(name, "John");
	}
	
	static Iterator<String> nameProvider() {		
		return Arrays.asList("John", "Mohn", "Lahn", "Mahn").iterator();
	}
}
