package com.astoudcommerce.task5.tests;

import org.testng.annotations.Test;
import org.testng.internal.TestNGMethod;

public class exerciseTest {

	@Test(description = "debug test")
	public void debugTest() {
		System.out.println("is a debug");
	}

	@Test(description = "is a test1")
	public void Test1() {
		System.out.println("is a test1");
	}

	@Test(description = "is a test2")
	public void Test2() {
		int a=1/0;
		System.out.println("is a test2");

	}

	@Test(description = "is a test3")
	public void Test3() {
		System.out.println("is a test3");
	}

}
