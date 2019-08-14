package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminAddClassPOM {
	private WebDriver driver; 
	
	public AdminAddClassPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li//a[@href='usergroups.php']")
	private WebElement classes; 
	
	@FindBy(xpath="//div//a[@href='/main/admin/usergroups.php?action=add']")
	private WebElement addClasses; 
	
	@FindBy(id="usergroup_name")
	private WebElement name; 
	
	@FindBy(id="usergroup_description")
	private WebElement description; 
	
	@FindBy(xpath="//*[@id=\"usergroup\"]/fieldset/div[6]/div[1]/div/button/div/div/div")
	private WebElement grpPermisson; 
	
	@FindBy(xpath="//*[@id=\"usergroup\"]/fieldset/div[6]/div[1]/div/div/div[1]/input")
	private WebElement grpPermissonvalue; 
	
	@FindBy(id="usergroup_submit")
	private WebElement submit; 
	
	@FindBy(xpath="//tr//td[6]//a//img")
	private WebElement subscribe2class;
	
	@FindBy(id="elements_not_in")
	private WebElement platform;
	
	@FindBy(xpath="//div//button[@class='btn btn-default']")
	private WebElement addUser;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement subscribeUser2Class;
	
	@FindBy(xpath="//tr//td[6]//a//img[@title='Subscribe class to courses']")
	private WebElement subscribeClass2Course;
	
	@FindBy(xpath="//div//select[@id='elements_not_in']")
	private WebElement courseOnPlatform;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	private WebElement selectCourse2Class;
	

	@FindBy(xpath="//button[contains(text(),'Subscribe class to courses')]")
	private WebElement subscribeClass2Course2;
		
	public void clickClasses() {
		this.classes.click();
	}
	
	public void clickAddClasses() {
		this.addClasses.click();
	}
	
	public void sendName(String name1) {
		this.name.sendKeys(name1);
	}
	
	public void sendDescription(String desc) {
		this.description.sendKeys(desc);
	}
	
	public void selectGrpPermissions() throws InterruptedException {
		Actions grpperm = new Actions(driver);
		grpperm.moveToElement(grpPermisson).click().build().perform();
		Thread.sleep(1000);
		grpPermissonvalue.sendKeys("Open");
		Thread.sleep(1000);
		grpPermissonvalue.sendKeys(Keys.ENTER);
	}
	
	public void clickSubmit() {
		this.submit.click();
	}
	
	public void clickSubscribe2Class() {
		this.subscribe2class.click();
	}
	
	public void selectPlatform() {
		Select usersOnPlatform = new Select(platform);
		usersOnPlatform.selectByValue("61");
		usersOnPlatform.selectByValue("63");		
	}
	
	public void selectAddUser() {
		this.addUser.click();
	}
	
	public void selectSubscribeUser2Class() {
		this.subscribeUser2Class.click();
	}
	
	public void clicksubscribeClass2Course() {
		this.subscribeClass2Course.click();
	}
	
	public void clickcourseOnPlatform() {
		this.courseOnPlatform.click();
	}
	
	public void clickSelectCourse2Class() {
		this.selectCourse2Class.click();
	}
	
	public void clicksubscribeClass2Course2() {
		this.subscribeClass2Course2.click();
	}
}
