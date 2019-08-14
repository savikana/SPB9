package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

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
import com.training.pom.AddUserPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterUser2CoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_048_RegisterUser2Course{
	private WebDriver driver;
	private String baseUrl;
	private AddUserPOM adduserPOM;
	private LoginPOM loginPOM;
	private RegisterUser2CoursePOM registeruser2coursePOM;
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
		adduserPOM = new AddUserPOM(driver); 
		loginPOM = new LoginPOM(driver);
		registeruser2coursePOM = new RegisterUser2CoursePOM(driver);
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
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		//Code to add new user
		adduserPOM.addUserList();
		adduserPOM.sendFirstName("Test1");
		adduserPOM.sendLastName("User1");
		adduserPOM.sendphoneNumber("0441234567890");
		adduserPOM.sendemail("Testuser@gmail.com");
		adduserPOM.sendNewUserName("testuser07");
		adduserPOM.sendNewPassword("testuser@123");
		adduserPOM.sendProfileValue();
		adduserPOM.sendSubmit();
		//code to register user to course
		adduserPOM.clickAdministration();
		registeruser2coursePOM.clickAddUser2Course();
		registeruser2coursePOM.selectUserList();
		registeruser2coursePOM.selectCourseList();
		registeruser2coursePOM.clickAdd2Course();
		Thread.sleep(2000);
		}
}
