package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterUser2CoursePOM {
	private WebDriver driver; 
	
	public RegisterUser2CoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Add users to course')]")
	private WebElement addUser2Course; 
	
	@FindBy(xpath="//select[@name='UserList[]']")
	private WebElement selectUser; 
	
	@FindBy(xpath="//select[@name='CourseList[]']")
	private WebElement selectCourse; 
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement add2Course; 
	
	public void clickAddUser2Course() {
		this.addUser2Course.click();
	}
	
	public void selectUserList() {
		Select userlist = new Select(selectUser);
		userlist.selectByVisibleText("User1 Test1 (testuser07)");
	}
	
	public void selectCourseList() {
		Select courselist = new Select(selectCourse);
		courselist.selectByValue("TESTCOURSE");
		courselist.selectByValue("TES");
	}
	
	public void clickAdd2Course() {
		this.add2Course.click();
	}
	
}
