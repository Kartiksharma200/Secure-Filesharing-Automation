package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logoutPage {
	
	WebDriver driver;
	
	
	//Locators
	private By profileIcon = By.xpath("//*[@aria-expanded='false'  or  @aria-expanded='true']");
	private By uploadFiles = By.xpath("(//*[@role='menuitem'])[2]");
	private By logoutbtn = By.xpath("(//*[@role='menuitem'])[3]");
	private By allFilesbtn = By.xpath("//*[@data-index=\'1\']");
	
	
	
	//Constructor
	public logoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods
	public void clickOnProfileIcon() {
		driver.findElement(profileIcon).click();
	}
	
	public void clickOnUploadfiles() {
		driver.findElement(uploadFiles).click();
	}
	
	public void clickOnLogout() {
		driver.findElement(logoutbtn).click();
	}
	
	public void clickOnallFiles() {
		driver.findElement(allFilesbtn).click();
	}

}
