package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	//Object Repository/Locators
	//Constructor
	//Methods
	
	private WebDriver driver;
	
	private By accountpageoptions= By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getAccPageTitle() {
				return driver.getTitle();	
	}
	
	public int getAccPageSectionCount() {
	return	driver.findElements(accountpageoptions).size();
	}
	
	public List<String> getAccSectionList() {
		List<String>  AccountList=new ArrayList<>();
		List<WebElement> Accountsectionlist=driver.findElements(accountpageoptions);
		
		for(WebElement e : Accountsectionlist){
			String ListOptions=e.getText();
			System.out.println("The sections are :"+ListOptions);
			AccountList.add(ListOptions);
					
		}
		return AccountList;
	}
	

}
