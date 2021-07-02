package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Loginpage {

	private WebDriver driver;

	//By Locators

	private By emailid= By.id("email");
	private By password= By.id("passwd");
	private By signInButton= By.id("SubmitLogin");
	private By forgotpwdink= By.linkText("Forgot your password?1");
	
	//Constructor of page class
	
	public Loginpage(WebDriver driver){
		this.driver=driver;			
	}
	
	//page actions: methods describing the behavior 
	
	public String getTitleLoginTitle() {
	return	driver.getTitle();
	}
	
	public boolean isForgotpwdlinkexist() {
		return driver.findElement(forgotpwdink).isDisplayed();
	}
	
	public void enterusername(String username) {
				driver.findElement(emailid).sendKeys(username);
		
	}
	
	public void enterpwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);
				}
	
	public void ClickOnLogin() {
		driver.findElement(signInButton).click();
		
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}
	
	
	
	
}
