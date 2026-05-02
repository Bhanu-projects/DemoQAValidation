package pageClass.ElementsForm;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;

	public TextBoxPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[contains(text(),'Elements')]")
	WebElement elementBox;

	@FindBy(id = "userName")
	WebElement userNameTxtB;

	@FindBy(xpath = "//a[@href='https://demoqa.com']//img")
	WebElement demoQATitle;

	@FindBy(xpath = "//span[contains(text(),'Text Box')]")
	WebElement textBoxField;

	@FindBy(className = "text-center")
	WebElement textBoxTitle;

	@FindBy(id = "userEmail")
	WebElement userEmailTxtB;

	@FindBy(id = "currentAddress")
	WebElement userCurrentAddressTxtB;

	@FindBy(id = "permanentAddress")
	WebElement userPermanentAddressTxtB;

	@FindBy(id = "submit")
	WebElement submitBtnTxtB;

	@FindBy(css = ".border.col-md-12.col-sm-12")
	WebElement fullDetailsTxtB;
	
	public boolean demoQAPageValidation() {
		return wait.until(ExpectedConditions.elementToBeClickable(demoQATitle)).isDisplayed();
	}

	public void navigateToTextBoxMenu() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", elementBox);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(elementBox)).click();
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", textBoxField);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(textBoxField)).click();
	}
	
	public boolean textBoxTitleValidation() {
		return wait.until(ExpectedConditions.elementToBeClickable(textBoxTitle)).isDisplayed();
	}

	public void enterFullName(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(userNameTxtB)).sendKeys(name);
	}

	public void enterFullEmail(String email) {
		userEmailTxtB.sendKeys(email);
	}

	public void enterCurrentAddress(String address) {
		js.executeScript("arguments[0].scrollIntoView(true);", userCurrentAddressTxtB);
		userCurrentAddressTxtB.sendKeys(address);
	}

	public void enterPermanentAddress(String address) {
		wait.until(ExpectedConditions.elementToBeClickable(userPermanentAddressTxtB)).sendKeys("Santhosh Nagar Colony, Kurnool, AP, 518006");
	}

	public void clickSubmit() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", submitBtnTxtB);
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtnTxtB)).click();
	}

	public boolean isResultBoxDisplayed() {
		return fullDetailsTxtB.isDisplayed();
	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(userEmailTxtB)).clear();
		userEmailTxtB.sendKeys(email);
	}

	public boolean isEmailErrorDisplayed() {
		String elementClasses = userEmailTxtB.getAttribute("class"); 
		return elementClasses.contains("field-error"); 
	}
}



