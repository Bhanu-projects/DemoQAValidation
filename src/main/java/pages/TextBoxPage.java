


package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TextBoxPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;

	// 1. Constructor: This connects the driver from the test to this page
	public TextBoxPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	// 2. Locators (Move all your @FindBy here)
	@FindBy(xpath = "//h5[contains(text(),'Elements')]")
	WebElement elementFormBtn;

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
	
//	@FindBy(css = ".mr-sm-2.field-error.form-control")
//	WebElement userEmailInvalidTxtB;

	@FindBy(id = "currentAddress")
	WebElement userCurrentAddressTxtB;

	@FindBy(id = "permanentAddress")
	WebElement userPermanentAddressTxtB;

	@FindBy(id = "submit")
	WebElement submitBtnTxtB;

	@FindBy(css = ".border.col-md-12.col-sm-12")
	WebElement fullDetailsTxtB;

	// ... move the rest of your locators here ...

	// 3. Action Methods (No Asserts here!)
	public void navigateToTextBoxMenu() {
		wait.until(ExpectedConditions.visibilityOf(demoQATitle));
		
		js.executeScript("arguments[0].scrollIntoView();", elementFormBtn);
		wait.until(ExpectedConditions.elementToBeClickable(elementFormBtn)).click();
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", textBoxField);
		wait.until(ExpectedConditions.elementToBeClickable(textBoxField)).click();
	}

	public void enterFullName(String name) {
		wait.until(ExpectedConditions.visibilityOf(userNameTxtB)).sendKeys(name);
	}

	// Create specific methods like enterEmail(), enterCurrentAddress(), clickSubmit()
	
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
	
	public void clickSubmit() {
		js.executeScript("arguments[0].click();", submitBtnTxtB);
//		wait.until(ExpectedConditions.elementToBeClickable(submitBtnTxtB)).click();
	}
	
	public boolean isResultBoxDisplayed() {
		return fullDetailsTxtB.isDisplayed();
	}
	
	// Action Method
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(userEmailTxtB)).clear();
        userEmailTxtB.sendKeys(email);
    }

    // Validation Method (Reads state, does not assert)
    public boolean isEmailErrorDisplayed() {
    	String elementClasses = userEmailTxtB.getAttribute("class"); 
        return elementClasses.contains("field-error"); 
    }
}



