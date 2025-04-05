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
import com.pageObjects.logoutPage;
import com.pageObjects.signupPage;
import com.pageObjects.uploadPage;
import com.utils.driverManager;

public class e2e {

	private WebDriver driver;
	private signupPage signup;
	private loginPage login;
	private uploadPage upload;
	private logoutPage logout;
	ExtentReports extent;
	ExtentTest test;

	@BeforeMethod
	public void setUp() {
		driver = driverManager.getDriver();
		signup = new signupPage(driver);
		login = new loginPage(driver);
		upload = new uploadPage(driver);
		logout = new logoutPage(driver);
		driver.get("https://file-sharing-application.netlify.app/signup");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@Test(priority = 1)
	public void testValidSignup() throws InterruptedException {
		test = extent.createTest("Valid Sign up Test");
		signup.enterName("Kartik Sharma");
		signup.enterEmail("Kartik123@gmail.com");
		signup.enterPassword("Kartik123");
		signup.clickSignup();
		Thread.sleep(2000);
		signup.clickOnLoginLink();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

	@Test(priority = 2, dependsOnMethods = "testValidSignup")
	public void testValidLogin() throws InterruptedException {
		// Thread.sleep(3000);
		test = extent.createTest("Valid Login Test");
		signup.clickOnLoginLink();
		login.enterEmail("Kartiksharma123@gmail.com");
		login.enterPassword("Kartik1234");
		Thread.sleep(2000);
		login.clickLogin();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("upload_files"));

	}

	@Test(priority = 3, dependsOnMethods = "testValidLogin")
	public void testValidFileUpload() throws InterruptedException {
		test = extent.createTest("Valid File Upload");
        upload.loginSuccessfulPOP();
		Thread.sleep(2000);
		upload.uploadFile("C:\\Users\\10000\\Downloads\\Admit Card bca bck krtik.pdf");
		upload.clickOnSetPass();
		upload.setPassword("Kartik@123");
		upload.clickUploadButton();
		Thread.sleep(2000);
		upload.verifyFileUpload();
	}
 
	
	@Test(priority = 4, dependsOnMethods = "testValidFileUpload")
	public void testforLogout() {
		test = extent.createTest("Finally Logout");
		logout.clickOnProfileIcon();
		logout.clickOnLogout();
	}
	
	
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
