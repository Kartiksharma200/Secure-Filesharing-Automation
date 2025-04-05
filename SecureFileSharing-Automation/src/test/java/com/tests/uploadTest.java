package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageObjects.uploadPage;
import com.utils.driverManager;

public class uploadTest {
	 private WebDriver driver;
	    private uploadPage upload;
	    
	    @BeforeMethod
	    public void setUp() {
	        driver = driverManager.getDriver();
	        driver.get("https://file-sharing-application.netlify.app/upload_files");
	        upload = new uploadPage(driver);
	    }
	    
	    @Test(priority = 1)
	    public void testValidFileUpload() {
	        upload.uploadFile("C:\\Users\\10000\\Downloads\\ChatPP Test Plan.pdf");
	        // Add validation
	    }
	    
	    @Test(priority = 2)
	    public void setPassword() {
	    	upload.clickOnSetPass();
	    	upload.setPassword("123456789");
	    }
	    
	    @Test(priority = 3)
	    public void uploadfile() {
	    	upload.clickUploadButton();
	    }
	    
	    @Test
	    public void testInvalidFileUpload() {
	        upload.uploadFile("C:/test/largefile.mp4");
	        // Add validation
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        driverManager.quitDriver();
	    }

}
