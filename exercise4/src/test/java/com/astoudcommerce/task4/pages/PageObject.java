package com.astoudcommerce.task4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.astoudcommerce.task4.drivers.Driver;

public class PageObject {
	
	private static PageObject PageObject;

	public static PageObject refresh() {
		PageObject=new PageObject(Driver.actualDriver());
		return PageObject;
	}
	
	public static PageObject actual() {
		PageObject = new LoginPage(Driver.actualDriver());
		return PageObject;
	}
	
	public PageObject(WebDriver webDriver) {
		PageFactory.initElements(Driver.actualDriver(), this);
	}
	
}
