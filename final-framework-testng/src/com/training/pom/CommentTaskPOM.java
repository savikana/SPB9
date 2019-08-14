package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommentTaskPOM {
	private WebDriver driver; 
	
	public CommentTaskPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(), 'Course catalog')]")
	private WebElement courseCatalog; 
	
	@FindBy(name="search_term")
	private WebElement searchCatalog;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	private WebElement searchButton; 
	
	@FindBy(xpath="//h4//a[@title='Test Course']")
	private WebElement myCourses; 
	
	@FindBy(xpath="//div//a[@class='btn btn-lg btn-success btn-block']")
	private WebElement coursehome; 
	
	@FindBy(xpath="//*[@id='istooldesc_2656']")
	private WebElement project; 
	
	@FindBy(xpath="//*[@title='[Blog: Test Project1] A task for me']")
	private WebElement mytasks; 
	
	@FindBy(xpath="//*[contains(text(),'Task1')]")
	private WebElement tasklink; 
	
	@FindBy(id="add_post_title")
	private WebElement commentTitle; 
	
	@FindBy(xpath="//div[@id='cke_1_contents']//iframe")
	private WebElement framepath; 
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement comment; 
	
	@FindBy(id="add_post_save")
	private WebElement savecomment; 
		
	public void sendcoursecatalog() {
		Actions catalog = new Actions(driver);
		catalog.moveToElement(courseCatalog).click().build().perform();
	}
	
	public void sendSearchCatalog(String searchcatalog) {
		this.searchCatalog.sendKeys(searchcatalog);
	}
	
	public void sendsearchbutton() {
		Actions search = new Actions(driver);
		search.moveToElement(searchButton).click().build().perform();
	}
	
	public void clickMycourses() {
		this.myCourses.click(); 
	}
	
	public void clickcourse() {
		this.coursehome.click(); 
	}
	
	public void clickMyTasks() {
		this.mytasks.click(); 
	}
	
	public void clickProject() {
		this.project.click(); 
	}
	
	public void clickTaskLink() {
		this.tasklink.click(); 
	}
	
	public void sendCommentTitle(String commenttitle) {
		this.commentTitle.sendKeys(commenttitle);
	}
	
	public void sendComment(String actualcomment) throws InterruptedException {
		driver.switchTo().frame(framepath);
		this.comment.sendKeys(actualcomment);
		driver.switchTo().defaultContent();
	}
	
	public void clickSaveComment() {
		this.savecomment.click(); 
	}
	
	
	
}
