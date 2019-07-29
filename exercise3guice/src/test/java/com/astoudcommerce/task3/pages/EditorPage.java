package com.astoudcommerce.task3.pages;

import static com.astoudcommerce.task3.drivers.Driver.driver;
import static com.astoudcommerce.task3.support.JavaRobot.robot;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.astoudcommerce.task3.drivers.Driver;
import com.astoudcommerce.task3.support.JavaRobot;

public class EditorPage extends PageObject {

	private static EditorPage editorPage;

	public static EditorPage refresh() {
		editorPage = new EditorPage(Driver.actualDriver());
		return editorPage;
	}

	public static EditorPage actual() {
		return editorPage;
	}

	public EditorPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindAll(@FindBy(xpath = "//body[@id='tinymce']/p"))
	private List<WebElement> paragraphs;
	
	private String Editframe="mce_0_ifr";

	@FindBy(xpath = "//button[@role='presentation']/i[@class='mce-ico mce-i-bold']")
	private WebElement bold;
	
	@FindBy(xpath="//button[@id='mceu_15-open']")
	private WebElement file;
	
	@FindBy(xpath="//*[text()='New document']")
	private WebElement newDocument;
	
	

	public void clickOnFile() {
		file.click();
	}
	
	public void clickOnBold() {
		bold.click();
	}
	
	public void clickOnNewDocument() {
		driver().waitElement().until(ExpectedConditions.elementToBeClickable(newDocument));
		newDocument.click();
	}
	
	public void inputParagraphLn(String text) {
		inputParagraph(text);
		robot().type(10);
	}
	
	public void inputParagraph(String text) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(text);
        clipboard.setContents(strSel, null);        
		Driver.driver().switchToFrameByName(Editframe);
		refresh();
		paragraphs.get(paragraphs.size()-1).click();
		robot().type(text);
		Driver.driver().switchToParentFrame();
	}
	
}
