package com.astoudcommerce.task4.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.astoudcommerce.task4.drivers.Driver;
import com.astoudcommerce.task4.pages.LoginPage;
import com.astoudcommerce.task4.support.TestData;
import com.google.inject.Inject;

@Guice
public class BancolombiaTest {

	@Inject
	TestData testData;

	@BeforeTest
	public void before() {
		Driver.newChromedriverOnUrl(testData.getProperty("url"));
	}

	@Test(description = "invalid user and password")
	public void bancolombiaErrorMessageInvalidLogin() {
		LoginPage.refresh();
		LoginPage.actual().inputUser(testData.getProperty("user"));
		LoginPage.actual().clickOnContinue();
		LoginPage.actual().inputPassword(testData.getProperty("password"));
		LoginPage.actual().clickOnContinue();
		assertEquals(LoginPage.actual().getError(), "Usuario o clave inválida. Por favor intente de nuevo.");
	}
	

	@AfterTest
	public void after() {
		Driver.actualDriver().quit();
	}

}
