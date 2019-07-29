package com.astoudcommerce.task3.drivers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Driver {
	private static Driver driver;
	private WebDriver webDriver;
	private WebDriverWait wait;
	
	public static WebDriver actualDriver() {
		return driver.webDriver;
	}
	
	public static Driver driver() {
		return driver;
	}
	
	public void takeScreenshot(String name) {	
		try {
			File src= ((TakesScreenshot)actualDriver()).getScreenshotAs(OutputType.FILE);
			Files.copy(src, new File(Paths.get("").toAbsolutePath().toString() + "\\"+name+".png"));
		} catch (IOException e) {

		}
	}
	
	public static void newChromedriverOnUrl(String url) {
		if(driver==null) {
			driver=new Driver();
		}
		driver.chromeDriver(url);
	}
	
	public WebDriverWait waitElement() {
		return driver.wait = new WebDriverWait(driver.actualDriver(),10);
	}
	
	public void chromeDriver(String url) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver=new ChromeDriver(options);
		webDriver.get(url);
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void switchToFrameByName(String name) {
		driver.webDriver.switchTo().frame(name);
	}
	
	public void switchToFrameByElement(WebElement element) {
		driver.webDriver.switchTo().frame(element);
	}
	
	public void switchToParentFrame() {
		driver.webDriver.switchTo().parentFrame();
	}
	
}
