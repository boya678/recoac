package com.astoudcommerce.task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.astoudcommerce.task3.drivers.Driver;

public class PageObject {
	
	private static PageObject PageObject;

	public static PageObject refresh() {
		PageObject=new PageObject(Driver.actualDriver());
		return PageObject;
	}
	
	public static PageObject actual() {
		PageObject = new HomePage(Driver.actualDriver());
		return PageObject;
	}
	
	public PageObject(WebDriver webDriver) {
		PageFactory.initElements(Driver.actualDriver(), this);
	}
	
}
