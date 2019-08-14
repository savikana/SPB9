package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterMultipleTeacherPOM {
	private WebDriver driver; 
	
	public RegisterMultipleTeacherPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[contains(text(),'Finish session creation')]")
	private WebElement sessionCreation;
	
	
	public void clickSesionCreation() {
		this.sessionCreation.click();
		}
}
