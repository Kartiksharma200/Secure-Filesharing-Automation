package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	  WebDriver driver;

	    // Locators
	    private By emailField = By.cssSelector("[placeholder=\"example@gmail.com\"]");
	    private By passwordField = By.cssSelector("[type=\"password\"]");
	    private By loginButton = By.xpath("(//*[@type=\"button\"])[2]");

	    public loginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	

}
