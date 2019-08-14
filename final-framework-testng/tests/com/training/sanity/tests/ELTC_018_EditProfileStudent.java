package com.training.sanity.tests;

import static org.testng.Assert.assertEquals; 

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EditProfileStudentPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_018_EditProfileStudent {

	private WebDriver driver;
	private String baseUrl;
	private EditProfileStudentPOM editprofilestudentPOM;
	private LoginPOM loginPOM;
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
		editprofilestudentPOM = new EditProfileStudentPOM(driver); 
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
		loginPOM.sendPassword("password4@123");
		loginPOM.clickLoginBtn();
		//code to edit profile
		editprofilestudentPOM.editprofile(); 
		editprofilestudentPOM.sendPass("password4@123");
		editprofilestudentPOM.sendnewPassword("password5@123");
		editprofilestudentPOM.confirmPassword("password5@123");
		editprofilestudentPOM.saveSettings();
		//verify if the profile update is saved
		String Expected ="Your new profile has been saved";
		String Actual =driver.findElement(By.xpath("//*[contains(text(),'Your new profile has been saved')]")).getText();
		assertEquals(Actual,Expected);
	}
}
