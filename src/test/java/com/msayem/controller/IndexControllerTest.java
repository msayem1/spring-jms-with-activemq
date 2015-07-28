package com.msayem.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
* Sample JUnit and Mockito Tests for IndexController class
* 
* @author MSAYEM
* 
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IndexControllerTest {

	private IndexController junitTestIndexController = new IndexController();
	private IndexController mockTestIndexController = mock(IndexController.class);	
	private String pageName = "index";

	@BeforeClass
	public static void beforeClass() {   
		System.out.println("@BeforeClass: Successful!");
	}
 
	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass: Successful!");
	}
 
	@Before
	public void before() {
		System.out.println("@Before: Successful!");
	}
 
	@After
	public void after() {
		System.out.println("@After: Successful!");
	}
 
	@Test
	public void testJunit() {
		String returnPageName = junitTestIndexController.indexController();
		
		assertNotNull(returnPageName);
		
		assertEquals("@Test - testJunit: Expected view was not returned.", "index", returnPageName);
		System.out.println("@Test - testJunit: Successful!");
	}
 
	@Test
	public void testMockito() {
		when(mockTestIndexController.indexController()).thenReturn(pageName);
		
		assertEquals(pageName, mockTestIndexController.indexController());
		
		System.out.println("@Test - testMockito: Successful!");
	}	
}