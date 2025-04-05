package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signupPage {
	 private WebDriver driver;
	    
	    public signupPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    private By nameField = By.xpath("//input[@placeholder='Enter Your Full Name']");
	    private By emailField = By.xpath("//input[@placeholder='example@gmail.com']");
	    private By passwordField = By.xpath("//input[@placeholder='Enter Your Password']");
	    private By signupButton = By.xpath("//button[text()='Signup']");
	    private By signupLoginLink = By.cssSelector("[style=\"font-weight: bold; cursor: pointer;\"]");
	    
	    public void enterName(String name) {
	        driver.findElement(nameField).sendKeys(name);
	    }
	    
	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }
	    
	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }
	    
	    public void clickSignup() {
	        driver.findElement(signupButton).click();
	    }
	    
	    public void clickOnLoginLink() {
	    	driver.findElement(signupLoginLink).click();
	    }

}
