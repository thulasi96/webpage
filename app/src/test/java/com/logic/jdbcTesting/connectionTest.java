package com.logic.jdbcTesting;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class connectionTest {

	@Before
	public void First()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.logic");
		context.refresh();
	}
	@Test
	public void test() {
		System.out.print("*****DATABASE CONNECTED*****");
		
	}
}
