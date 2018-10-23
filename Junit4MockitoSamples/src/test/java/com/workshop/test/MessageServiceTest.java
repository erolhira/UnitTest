package com.workshop.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/*
 * @RunWith(MockitoJUnitRunner.class)
 */
@PrepareForTest
@RunWith(PowerMockRunner.class)
public class MessageServiceTest {
	
	/*
	 * use @Mock instead of Mockito.mock
	 * List mockList = Mockito.mock(ArrayList.class);
	 */	
	@Mock
	List<String> mockedList;
	
	/*
	 * Spy'da mocklanmayan method'larin real implementation'lari call edilir.
	 */
	@Spy
	List<String> spiedList = new ArrayList<String>();
	
	@Captor
	ArgumentCaptor<String> argCaptor;
	
	@Mock
	LogService logService;
	
	@InjectMocks
	MessageService messageService;
	
	@Before
	public void init() {
		//when(messageService.sendMessage(anyString()));
	}
	
	@Test
	public void sendMessage_nullContentCheck() {
		
		messageService.sendMessage("Hi there");
	}
	
	@Test
	public void mockTest() {
		
		mockedList.add("one");
		Mockito.verify(mockedList).add("one"); //1 kez eklenmis olmali kontrolu
		//Mockito.verify(mockedList, times(2)).add("one"); //2 kez eklenmis olmali kontrolu	    
		assertEquals(0, mockedList.size());
		
		when(mockedList.size()).thenReturn(100);
		assertEquals(100, mockedList.size());
	}
	
	@Test
	public void spyTest() {
		
		spiedList.add("one");
	    spiedList.add("two");
	    
	    Mockito.verify(spiedList).add("one");
	    Mockito.verify(spiedList).add("two");
	    
	    assertEquals(2, spiedList.size());
	    
	    doReturn(100).when(spiedList).size();
	    assertEquals(100, spiedList.size());
	}
	
	@Test
	public void captorTest() {	
		mockedList.add("one");
		Mockito.verify(mockedList).add(argCaptor.capture());
		System.out.println(argCaptor.getValue());
	}
	
	//-----------------------------------------------------------
	
	@Mock
	Map<String, String> wordMap;
	 
	/*
	 * Use @InjectMocks to inject both @Spy and @Mock instances
	 */
	@InjectMocks
	MyDictionary dic = new MyDictionary();
	
	@Test
	public void injectMocksTest() {		
		Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");		 
	    assertEquals("aMeaning", dic.getMeaning("aWord"));
	}
	
	//-----------------------------------------------------------
	
}
