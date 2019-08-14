package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryCoursePOM {
	private WebDriver driver; 
	
	public CategoryCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Courses categories')]")
	private WebElement courseCategory;
	
	@FindBy(xpath="//a//img[@title='Add category']")
	private WebElement addCategory; 
	
	@FindBy(id="course_category_code")
	private WebElement categoryCode;
	
	@FindBy(id="course_category_name")
	private WebElement categoryName; 
	
	@FindBy(id="course_category_submit")
	private WebElement submitCategory; 
	
	@FindBy(xpath="//li//a[@title='Administration']")
	private WebElement administration;
	
	@FindBy(xpath="//*[contains(text(),'Create a course')]")
	private WebElement createCourse;
	
	@FindBy(id="update_course_title")
	private WebElement courseTitle; 
	
	@FindBy(id="visual_code")
	private WebElement courseCode; 
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement selectTeacher; 
	
	@FindBy(xpath="//div[@class='filter-option-inner-inner']")
	private WebElement selectCategory; 
	
	@FindBy(xpath="//div[@class='bs-searchbox']//input[@class='form-control']")
	private WebElement selectCategory1; 
	
	@FindBy(xpath="//button[@data-id='update_course_course_language']//div//div//div[@class='filter-option-inner-inner']")
	private WebElement selectlanguage; 
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[7]/div[1]/div/div/div[1]/input")
	private WebElement selectlanguage1; 
	
	@FindBy(id="update_course_submit")
	private WebElement submitCourse; 
				
	public void clickCourseCategory() {
		this.courseCategory.click(); 
	}
	
	public void clickAddCateogry() {
		Actions search = new Actions(driver);
		search.moveToElement(addCategory).click().build().perform();
	}
	
	public void sendCategoryCode(String code) {
		this.categoryCode.sendKeys(code);
	}
	
	public void sendCategoryName(String name) {
		this.categoryName.sendKeys(name);
	}
	
	public void clickSubmitCategory() {
		this.submitCategory.click();
	}
	
	public void clickAdministration() {
	Actions admin = new Actions(driver);
	admin.moveToElement(administration).click().build().perform();
	}
	
	public void clickCreateCourse() {
	Actions course = new Actions(driver);
	course.moveToElement(createCourse).click().build().perform();
	}
	
	public void sendCourseTitle(String title1) {
		this.courseTitle.sendKeys(title1);
	}

	public void sendCourseCode(String code1) {
		this.courseCode.sendKeys(code1);
	}
	
	public void clickTeacherList(String Teacher) throws InterruptedException {
		Actions teacher = new Actions(driver);
		teacher.moveToElement(selectTeacher).click().build().perform();
		this.selectTeacher.sendKeys(Teacher);
		Thread.sleep(1000);
		selectTeacher.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		selectTeacher.sendKeys(Keys.ENTER);
	}

	public void selectCategory(String selcategory) {
		Actions category = new Actions(driver);
		category.moveToElement(selectCategory).click().build().perform();
		selectCategory1.sendKeys(selcategory);
		selectCategory1.sendKeys(Keys.DOWN,Keys.ENTER);
		}
	
	public void selectLanguage(String lang) throws InterruptedException {
		Actions selectlang = new Actions(driver);
		selectlang.moveToElement(selectlanguage).click().build().perform();
		Thread.sleep(1000);
		selectlanguage1.sendKeys(lang);
		Thread.sleep(1000);
		selectlanguage1.sendKeys(Keys.ENTER);
		}
	
	public void clickSubmitCourse() {
		this.submitCourse.click();
	}
}
