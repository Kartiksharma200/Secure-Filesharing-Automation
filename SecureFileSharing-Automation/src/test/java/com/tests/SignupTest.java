package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageObjects.signupPage;
import com.utils.driverManager;

public class SignupTest {
	
	 private WebDriver driver;
	    private signupPage signup;
	    
	    @BeforeMethod
	    public void setUp() {
	        driver = driverManager.getDriver();
	        driver.get("https://file-sharing-application.netlify.app/signup");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        signup = new signupPage(driver);
	    }
	    
	    @Test
	    public void testValidSignup() {
	        signup.enterName("Kartik Sharma");
	        signup.enterEmail("Kartiksharma@gmail.com");
	        signup.enterPassword("Password123");
	        signup.clickSignup();
	        
	    }
	    
	    @Test
	    public void testInvalidSignup() {
	        signup.enterName("");
	        signup.enterEmail("invalid-email");
	        signup.enterPassword("123");
	        signup.clickSignup();
	       
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        driverManager.quitDriver();
	    }

}
