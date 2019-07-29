package com.astoudcommerce.task3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.astoudcommerce.task3.drivers.Driver;

public class HomePage extends PageObject {

	private static HomePage homePage;

	public static HomePage refresh() {
		homePage = new HomePage(Driver.actualDriver());
		return homePage;
	}

	public static HomePage actual() {
		return homePage;
	}

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(xpath = "//*[@href='/frames']")
	private WebElement frames;

	public void clickOnFrames() {
		frames.click();
	}

}
