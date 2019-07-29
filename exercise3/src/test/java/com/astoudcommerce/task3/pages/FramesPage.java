package com.astoudcommerce.task3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.astoudcommerce.task3.drivers.Driver;

public class FramesPage  extends PageObject{
	
	private static FramesPage framesPage;
	
	public static FramesPage refresh() {
		framesPage=new FramesPage(Driver.actualDriver());
		return framesPage;
	}
	
	public static FramesPage actual() {
		return framesPage;
	}
	
	
	public FramesPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy(xpath = "//*[@href='/iframe']")
	private WebElement frames;
	
	
	public void clickOnIframe() {
		frames.click();
	}
	
}
