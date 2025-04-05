package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class e2eWithoutPOM {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://file-sharing-application.netlify.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void loginSetup() {
		driver.findElement(By.cssSelector("[placeholder='example@gmail.com']")).sendKeys("Kartiksharma123@gmail.com");
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("Kartik1234");
		driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();	
	}
	
	@Test(priority = 2)
	public void fileUploadSetup() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='menu-button-:r8:']")).click();
		//driver.findElement(By.xpath("(//*[@role='menuitem'])[2]")).click();
		
		
		driver.findElement(By.xpath("//input[contains(@class, 'chakra-input')]")).sendKeys("C:\\Users\\10000\\Downloads\\Admit Card bca bck krtik.pdf");
		driver.findElement(By.cssSelector("[class='chakra-checkbox__control css-1yld03o']")).click();
		driver.findElement(By.cssSelector("[placeholder='Set Password']")).sendKeys("123456789");
		//Upload Button
		driver.findElement(By.cssSelector("[class='chakra-button css-rxecov']")).click();
		Thread.sleep(2000);
		//Profile Icon
		driver.findElement(By.xpath("//*[@aria-expanded='false'  or  @aria-expanded='true']")).click();
		//All Files
		driver.findElement(By.xpath("//*[@data-index=\'1\']")).click();
		//driver.findElement(By.xpath("//button[@id='menu-button-:r1:']")).click();
		//driver.findElement(By.xpath("//b[@id='menu-list-:r1:-menuitem-:r2:']")).click();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
