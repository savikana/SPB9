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
import com.training.pom.CommentTaskPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_046_CommentOnTask {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CommentTaskPOM commenttaskPOM;
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
		commenttaskPOM = new CommentTaskPOM(driver); 
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
		//code for Student login 
		loginPOM.sendUserName("savitha");
		loginPOM.sendPassword("savitha");
		loginPOM.clickLoginBtn();
		//Code to navigate to course and add the comment in assinged task
		commenttaskPOM.sendcoursecatalog();
		commenttaskPOM.sendSearchCatalog("Test Course");
		commenttaskPOM.sendsearchbutton();
		commenttaskPOM.clickMycourses();
		commenttaskPOM.clickcourse();
		commenttaskPOM.clickProject();
		commenttaskPOM.clickMyTasks();
		commenttaskPOM.clickTaskLink();
		commenttaskPOM.sendCommentTitle("Test Comment1");
		commenttaskPOM.sendComment("Comment123");
		commenttaskPOM.clickSaveComment();
	}
}
