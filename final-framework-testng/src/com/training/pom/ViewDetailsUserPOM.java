package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewDetailsUserPOM {
	private WebDriver driver; 
	
	public ViewDetailsUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Administration')]")
	private WebElement administration; 
	
	@FindBy(xpath="//a[contains(text(),'User list')]")
	private WebElement userlist; 
	
	@FindBy(xpath="//table/tbody/tr[2]/td[11]/a[5]/img")
	private WebElement edituser; 
	
	public void clickAdministration() {
		this.administration.click(); 
	}
	
	public void clickUserList() {
		this.userlist.click(); 
	}
	
	public void clickEditUser() {
		this.edituser.click(); 
	}
}
