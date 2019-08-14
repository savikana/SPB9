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
import com.training.pom.CategoryCoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_047_CreateCategoryCourse {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CategoryCoursePOM categorycoursePOM;
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
		categorycoursePOM = new CategoryCoursePOM(driver); 
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
		//code for Admin login 
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		//admin to create a category & add course to created category
		categorycoursePOM.clickCourseCategory();
		categorycoursePOM.clickAddCateogry();
		categorycoursePOM.sendCategoryCode("BL6");
		categorycoursePOM.sendCategoryName("Blended Learning6");
		categorycoursePOM.clickSubmitCategory();
		categorycoursePOM.clickAdministration();
		categorycoursePOM.clickCreateCourse();
		categorycoursePOM.sendCourseCode("Code1");
		categorycoursePOM.sendCourseTitle("Title1");
		categorycoursePOM.clickTeacherList("teach");
		categorycoursePOM.selectCategory("Blended Learning1");
		categorycoursePOM.selectLanguage("English");
		categorycoursePOM.clickSubmitCourse();
	}
}
