package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateTrainingSessionPOM {
	private WebDriver driver; 
	
	public CreateTrainingSessionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://elearningm1.upskills.in/main/session/session_add.php']")
	private WebElement addTrainingSession; 
	
	@FindBy(id="add_session_name")
	private WebElement sessionName;
	
	@FindBy(id="add_session_submit")
	private WebElement sessionNextStep;
	
	@FindBy(xpath="//select[@id='origin']")
	private WebElement courseList;	
	
	@FindBy(xpath="//button[@name='add_course']")
	private WebElement addCourse;
	
	@FindBy(xpath="//button[@name='next']")
	private WebElement nextStep;
	
	@FindBy(id="user_to_add")
	private WebElement subscribeUser;
	
	@FindBy(xpath="//div//a[contains(text(),'savikana')]")
	private WebElement selectUser;
	
	@FindBy(xpath="//button[contains(text(),'Finish session creation')]")
	private WebElement sessionCreation;
					
	public void clickaddTrainingSession() {
	this.addTrainingSession.click();
	}
	
	public void sendSessionName(String name) {
	this.sessionName.sendKeys(name);
	}
	
	public void clickSessionNextStep() {
		this.sessionNextStep.click();
		}
	
	public void clickCourseList() throws InterruptedException {
		Select cList= new Select(courseList);
		cList.selectByValue("100");
		Thread.sleep(4000);
		}
	
	public void clickAddCourse() {
		this.addCourse.click();
		}
	
	public void clickNextStep() {
		this.nextStep.click();
		}
	
	public void clickSubscribeUser(String username) {
		this.subscribeUser.sendKeys(username);
		this.selectUser.click();
		}
	
	public void clickSesionCreation() {
		this.sessionCreation.click();
		}
}
