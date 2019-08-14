package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.StudentLogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_016_StudentLogout {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private StudentLogoutPOM studentlogoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		studentlogoutPOM = new StudentLogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("savikana");
		loginPOM.sendPassword("password3@123");
		loginPOM.clickLoginBtn(); 
		//Student logout code
		studentlogoutPOM.clickusericon();
		studentlogoutPOM.clicklogout();
		screenShot.captureScreenShot("First");
		//Verify Login Screen is displayed
		String Expected = "Savitha Kanakaraju";
		String Actual =driver.findElement(By.xpath("//strong[contains(text(),'Savitha Kanakaraju')]")).getText();
		Assert.assertEquals(Actual,Expected);
	}
}
