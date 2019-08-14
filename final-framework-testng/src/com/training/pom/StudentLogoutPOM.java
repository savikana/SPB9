package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentLogoutPOM {
	private WebDriver driver; 
	
	public StudentLogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@class='dropdown-toggle']//img[@class='img-circle']")
	private WebElement userIcon; 
	
	@FindBy(id ="logout_button")
	private WebElement userLogout; 
	
	public void clickusericon() {
		this.userIcon.click(); 
	}
	public void clicklogout() {
		this.userLogout.click(); 
	}
	
}
