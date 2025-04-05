package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pageObjects.loginPage;
import com.utils.ExtentReportManager;
import com.utils.driverManager;

public class LoginTest {
	   WebDriver driver;
	    loginPage login;
	    ExtentReports extent;
	    ExtentTest test;

	    @BeforeTest
	    public void setup() {
	        driver = driverManager.getDriver();
	        driver.get("https://file-sharing-application.netlify.app/login");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        login = new loginPage(driver);
	        extent = ExtentReportManager.getReportInstance();
	    }

	    @Test(priority = 1)
	    public void testValidLogin() throws InterruptedException {
	        test = extent.createTest("Valid Login Test");
	        login.enterEmail("KartikSharma@gmail.com");
	        login.enterPassword("Kartik@123");
	        login.clickLogin();
	        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	        Thread.sleep(3000);
	    }

	    @Test(priority = 2)
	    public void testInvalidLogin() {
	        test = extent.createTest("Invalid Login Test");
	        login.enterEmail("kartik@gmalcom");
	        login.enterPassword("wrongpass");
	        login.clickLogin();
	        Assert.assertTrue(driver.getPageSource().contains("Invalid Email or Password!"));
	    }

	    @AfterTest
	    public void tearDown() {
	        extent.flush();
	        driver.quit();
	    }

}
