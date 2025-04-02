package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pageObjects.loginPage;
import com.pageObjects.signupPage;
import com.pageObjects.uploadPage;
import com.utils.driverManager;

public class e2e {
	
	private WebDriver driver;
    private signupPage signup;
    private loginPage login;
    private uploadPage upload;
    ExtentReports extent;
    ExtentTest test;
	
	@BeforeMethod
    public void setUp() {
        driver = driverManager.getDriver();
        login = new loginPage(driver); 
        upload = new uploadPage(driver);
        driver.get("https://file-sharing-application.netlify.app");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signup = new signupPage(driver);
    }
	
	 @Test(priority = 1)
	    public void testValidSignup() throws InterruptedException {
	        signup.enterName("Kartik Sharma");
	        signup.enterEmail("Kartik124@gmail.com");
	        signup.enterPassword("Kartik123");
	        signup.clickSignup();
	        Thread.sleep(3000);
	        signup.clickOnLoginLink();
	        Thread.sleep(2000);
	        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	    }
	 
	 @Test(priority = 2)
	    public void testValidLogin() throws InterruptedException {
		    Thread.sleep(3000);
		    signup.clickOnLoginLink();
	        //test = extent.createTest("Valid Login Test");
	        login.enterEmail("Kartiksharma123@gmail.com");
	        login.enterPassword("Kartik1234");
	        Thread.sleep(2000);
	        login.clickLogin();
	        Thread.sleep(20000);
	        Assert.assertTrue(driver.getCurrentUrl().contains("upload_files"));
	        
	    }

	 @Test(priority = 3)
	    public void testValidFileUpload() throws InterruptedException {
	        upload.uploadFile("C:\\Users\\10000\\Downloads\\ChatPP Test Plan.pdf");
	        upload.clickOnSetPass();
	        upload.setPassword("123456789");
	        Thread.sleep(2000);
	        upload.clickUploadButton();
	        Thread.sleep(2000);
	        upload.verifyFileUpload();
	    }
	 
	 @AfterTest
	    public void tearDown() {
	        extent.flush();
	        driver.quit();
	    }

	    
}
