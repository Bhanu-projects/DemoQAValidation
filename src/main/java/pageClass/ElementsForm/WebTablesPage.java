package pageClass.ElementsForm;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTablesPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;
	
	public WebTablesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor)driver;
		act = new Actions(driver);
	}
	
	@FindBy(xpath = "//a[@href='https://demoqa.com']//img")
	WebElement demoQATitle;
	
	@FindBy(xpath = "//h5[contains(text(),'Elements')]")
	WebElement elementBox;
	
	@FindBy(xpath = "//span[contains(text(),'Web Tables')]")
	WebElement webTablesField;
	
	@FindBy(className = "text-center")
	WebElement webTablesTitle;
	
	@FindBy(xpath = "//table[@class='-striped -highlight table table-striped table-bordered table-hover']/tbody/tr")
	List<WebElement> rowCount;
	
	@FindBy(id = "addNewRecordButton")
	WebElement addBtn;
	
	@FindBy(id = "registration-form-modal")
	WebElement registrationForm;
	
	@FindBy(id = "firstName")
	WebElement firstName;
	
	@FindBy(id = "lastName")
	WebElement lastName;
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "age")
	WebElement age;
	
	@FindBy(id = "salary")
	WebElement salary;
	
	@FindBy(id = "department")
	WebElement dept;
	
	@FindBy(id = "submit")
	WebElement submitBtn;
	
	public boolean demoQAPageValidation() {
		return wait.until(ExpectedConditions.elementToBeClickable(demoQATitle)).isDisplayed();
	}
	
	public void navigateToTextBoxMenu() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", elementBox);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(elementBox)).click();
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", webTablesField);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(webTablesField)).click();
	}
	
	public boolean webTablesTitleValidation() {
		return wait.until(ExpectedConditions.elementToBeClickable(webTablesTitle)).isDisplayed();
	}
	
	public int countOfRows() {
		return rowCount.size();
	}
	
	public void clickAddButton() {
		act.moveToElement(addBtn).click().perform();
	}
	
	public boolean registrationFormValidation() {
		act.scrollToElement(registrationForm).perform();
		return registrationForm.isDisplayed();
	}
	
	public void addNewRecord(String firstName, String lastName, String email, int age, int salary, String dept) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.userEmail.sendKeys(email);
		this.age.sendKeys(String.valueOf(age));
		this.salary.sendKeys(String.valueOf(salary));
		this.dept.sendKeys(dept);
	}
	
	public void clickSubmitBtn() throws InterruptedException {
		act.moveToElement(submitBtn).click().perform();
	}
}
