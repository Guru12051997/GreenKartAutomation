package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1.By locator
	private By emaidId = By.id("email");
	private By password = By.id("passwd");
	private By SignInButton = By.id("SubmitLogin");
	private By ForgotPwdLink = By.xpath("//a[normalize-space()='Forgot your password?']");

	// 2.Constructor of the page
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// 3.page actions : feature (behavior)of the Page the form of methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(ForgotPwdLink).isDisplayed();
	}

	public void EnterUserName(String username) {
		driver.findElement(emaidId).sendKeys(username);
	}

	public void EnterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void ClickOnLogin() {
		driver.findElement(SignInButton).click();
	}
	
	public AccountsPage dologin(String un ,String pwd) {
		
		System.out.println("login with:"+un+"and"+pwd);
		driver.findElement(emaidId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(SignInButton).click();
		return new AccountsPage(driver);
	}
	
	
	
	
	
	
	
	
}
