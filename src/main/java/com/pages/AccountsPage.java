package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
				
		//List<WebElement> Accountsectionlist=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountpageoptions));
		for(WebElement e : Accountsectionlist){
			String ListOptions=e.getText();
			System.out.println("The sections are :"+ListOptions);
			AccountList.add(ListOptions);
					
		}
		return AccountList;
	}

	

}
