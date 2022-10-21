package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}

	private By subjectheading = By.id("id_contact");
	private By email = By.id("email");
	private By orderRef = By.id("id_order");
	private By MessageText = By.id("message");
	private By SubmitButton = By.xpath("//span[normalize-space()='Send']");
	private By SuccessMessage = By.xpath("//p[@class='alert alert-success']");

	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public void ClickOnSendButton() {
		driver.findElement(SubmitButton).click();
	}

	/*
	 * public void EnterEmail(String username) {
	 * driver.findElement(email).sendKeys(username); }
	 */

	public String getSuccessMesssge() {
		return driver.findElement(SuccessMessage).getText();
	}

	public void fillContactUsForm(String heading, String emailid, String orderef, String mesaage) {
		Select select = new Select(driver.findElement(subjectheading));
		select.selectByVisibleText(heading);

		driver.findElement(email).sendKeys(emailid);
		driver.findElement(orderRef).sendKeys(orderef);
		driver.findElement(MessageText).sendKeys(mesaage);
	}

}
