package com.astoudcommerce.task3.tests;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.astoudcommerce.task3.drivers.Driver;
import com.astoudcommerce.task3.pages.EditorPage;
import com.astoudcommerce.task3.pages.FramesPage;
import com.astoudcommerce.task3.pages.HomePage;
import com.astoudcommerce.task3.support.TestData;
import com.google.inject.Inject;
@Guice
public class HerokuappTestPOM {

	@Inject
	TestData testData;
	
	@BeforeTest
	public void before() {
		Driver.newChromedriverOnUrl("http://the-internet.herokuapp.com");
	}
	
	@Test
	public void purePageObjectTest() {
		HomePage.refresh();
		HomePage.actual().clickOnFrames();
		FramesPage.refresh();
		FramesPage.actual().clickOnIframe();
		EditorPage.refresh();
		EditorPage.actual().clickOnFile();
		EditorPage.actual().clickOnNewDocument();
		EditorPage.actual().inputParagraph(" ");
		EditorPage.actual().clickOnBold();
		EditorPage.actual().inputParagraphLn(testData.getProperty("line1"));
		EditorPage.actual().clickOnBold();
		EditorPage.actual().inputParagraphLn(testData.getProperty("line2"));
		Driver.driver().takeScreenshot("evidence");
		throw new SkipException("Skipped");	
	}
	
	@AfterTest
	public void after() {
		Driver.actualDriver().quit();
	}


}
