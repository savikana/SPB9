package com.training.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPOM {
	private WebDriver driver; 
	
	public AddUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Administration')]")
	private WebElement administration; 
	
	@FindBy(xpath="//a[@href='user_add.php']")
	private WebElement adduser; 
	
	@FindBy(id="firstname")
	private WebElement firstName;
	
	@FindBy(id="lastname")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
	@FindBy(id="username")
	private WebElement newuserName; 
	
	@FindBy(id="password")
	private WebElement newPassword;
	
	@FindBy(xpath="//div[text()='Learner']")
	private WebElement profiledropdown;
	
	@FindBy(name="submit")
	private WebElement submit;
		
	public void clickAdministration() {
		this.administration.click(); 
	}
	
	public void addUserList() {
		this.adduser.click(); 
	}
	
	public void sendFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void sendemail(String email) {
		this.email.sendKeys(email);
	}
	
	public void sendphoneNumber(String phonenumber) {
		this.phoneNumber.sendKeys(phonenumber);
	}
	
	public void sendNewUserName(String newuserName) {
		this.newuserName.clear();
		this.newuserName.sendKeys(newuserName);
	}
	
	public void sendNewPassword(String newpassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newpassword);
	}
	
	public void sendProfileValue() {
		Actions profile = new Actions(driver);
		profile.moveToElement(profiledropdown).click().sendKeys(Keys.ARROW_UP).build().perform();
		//keyDown(profiledropdown,Keys.ARROW_UP).build().perform();
		
				
	}
	
	public void sendSubmit() {
		this.submit.click();
	}
}
	