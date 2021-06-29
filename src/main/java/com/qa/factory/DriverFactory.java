package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	/**
	 * This method returns the local driver thread for the given browser value
	 * @param browser
	 * @return
	 */
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("browser value is :"+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());}
			
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());}
			
			else if (browser.equals("internet explorere")) {
				WebDriverManager.iedriver().setup();
				tlDriver.set(new InternetExplorerDriver());}
				
				else {
					System.out.println("Please pass the correct browseer value");
				}
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			return getDriver();
										
			}
	
	
	public static synchronized WebDriver getDriver() {					
		return tlDriver.get();
	}
	
	
}
