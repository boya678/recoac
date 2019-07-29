package com.astoudcommerce.task4.pages;

import static com.astoudcommerce.task4.drivers.Driver.actualDriver;
import static com.astoudcommerce.task4.drivers.Driver.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.astoudcommerce.task4.drivers.Driver;

public class LoginPage extends PageObject {

	private static LoginPage loginPage;

	public static LoginPage refresh() {
		loginPage = new LoginPage(Driver.actualDriver());
		return loginPage;
	}

	public static LoginPage actual() {
		return loginPage;
	}

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(id = "username")
	private WebElement user;
	
	@FindBy(id = "btnGo")
	private WebElement continueBtn;
	
	@FindBy(id="summary")
	private WebElement error;
	
	private String password="//table[@id='_KEYBRD']//*[substring(@id, string-length(@id), 1)='#']/parent::td";

	public void clickOnContinue() {
		continueBtn.click();
	}
	
	public String getError() {
		return error.getText();
	}
	
	public void inputUser(String user) {
		this.user.sendKeys(user);
	}
	
	public void inputPassword(String password) {
		for(int i=0;i<password.length();i++) {
			System.out.println();
			actualDriver().findElement(By.xpath(this.password.replace("#", String.valueOf(password.charAt(i))))).click();
			driver().executeJavascript("changeToOrigKeyboard()");
		}
	}

}
