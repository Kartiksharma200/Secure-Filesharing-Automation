package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class uploadPage {
	  WebDriver driver;
   
	    //Locators
	    private By uploadInput = By.xpath("//input[contains(@class, 'chakra-input')]");
	    private By checkBox = By.cssSelector("[class='chakra-checkbox__control css-1yld03o']");
	    private By setPassword = By.cssSelector("[placeholder='Set Password']");
	    private By uploadButton = By.cssSelector("[class='chakra-button css-rxecov']");
	    private By verifyUpload = By.cssSelector("[class=\"chakra-heading css-18j379d\"]");
	    private By cancelPop = By.xpath("//button[@aria-label='Close']");
	    
	    
	    //Constructor
	    public uploadPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    
	    //Methods
	    public void uploadFile(String filePath) {
	        driver.findElement(uploadInput).sendKeys(filePath);
	    }
	    
	    public void clickOnSetPass() {
	    	driver.findElement(checkBox).click();
	    }
	    
	    public void setPassword(String setPass) {	    	
	    	driver.findElement(setPassword).sendKeys(setPass);
	    }

	    public void clickUploadButton() {
	        driver.findElement(uploadButton).click();
	    }
	    
	    public void verifyFileUpload() {
	    	driver.findElement(verifyUpload).isDisplayed();
	    	
	    }
	    
	    public void loginSuccessfulPOP() {
	    	driver.findElement(cancelPop).click();
	    }

}
