package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfileStudentPOM {
	private WebDriver driver; 
	
	public EditProfileStudentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[contains(text(), 'Edit profile')]")
	private WebElement editProfile; 
	
	@FindBy(id ="profile_password0")
	private WebElement pass; 
	
	@FindBy(id ="password1")
	private WebElement newPassword; 
	
	@FindBy(id="profile_password2")
	private WebElement confirmPassword; 

	@FindBy(id="profile_apply_change")
	private WebElement saveSettings; 
		
	public void editprofile() {
		this.editProfile.click(); 
	}
	public void sendPass(String password) {
		this.pass.clear(); 
		this.pass.sendKeys(password); 
	}
	public void sendnewPassword(String password) {
		this.newPassword.sendKeys(password);
	}
	public void confirmPassword(String password) {
		this.confirmPassword.sendKeys(password);
	}
	public void saveSettings() {
		this.saveSettings.click(); 
	}
}
