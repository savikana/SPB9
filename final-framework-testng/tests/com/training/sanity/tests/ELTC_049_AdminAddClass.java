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
import com.training.pom.AdminAddClassPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_049_AdminAddClass{
	private WebDriver driver;
	private String baseUrl;
	private AdminAddClassPOM adminaddclassPOM;
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
		adminaddclassPOM = new AdminAddClassPOM(driver); 
		loginPOM = new LoginPOM(driver);
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
		//Code to add Class
		adminaddclassPOM.clickClasses();
		adminaddclassPOM.clickAddClasses();
		adminaddclassPOM.sendName("Test Class");
		adminaddclassPOM.sendDescription("Test Description");
		adminaddclassPOM.selectGrpPermissions();
		adminaddclassPOM.clickSubmit();
		adminaddclassPOM.clickSubscribe2Class();
		adminaddclassPOM.selectPlatform();
		adminaddclassPOM.selectAddUser();
		adminaddclassPOM.selectSubscribeUser2Class();
		// Code for Subscribe class to courses
		adminaddclassPOM.clicksubscribeClass2Course();
		adminaddclassPOM.clickcourseOnPlatform();
		adminaddclassPOM.clickSelectCourse2Class();
		adminaddclassPOM.clicksubscribeClass2Course2();
		Thread.sleep(4000);
		}
}
