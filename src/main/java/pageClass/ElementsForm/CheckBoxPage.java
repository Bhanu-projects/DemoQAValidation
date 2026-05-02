package pageClass.ElementsForm;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;
	
	public CheckBoxPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://demoqa.com']//img")
	WebElement demoQATitle;
	
	@FindBy(xpath = "//h5[contains(text(),'Elements')]")
	WebElement elementBox;
	
	@FindBy(xpath = "//span[contains(text(),'Check Box')]")
	WebElement checkBoxField;
	
	@FindBy(className = "text-center")
	WebElement checkBoxTitle;
	
	@FindBy(css = ".rc-tree-switcher.rc-tree-switcher_close")
	WebElement expandBtn;
	
	@FindBy(css = ".rc-tree-switcher.rc-tree-switcher_close")
	List<WebElement> homeExpandBtns;
	
	@FindBy(css = ".rc-tree-switcher.rc-tree-switcher_close")
	List<WebElement> docExpandBtns;
	
	@FindBy(xpath = "//span[@aria-label='Select Home']")
	WebElement selectHomeCheckBox;
	
	@FindBy(xpath = "//span[@aria-label='Select Downloads']")
	WebElement selectDownloadsCheckBox;
	
	public boolean demoQAPageValidation() {
		return wait.until(ExpectedConditions.elementToBeClickable(demoQATitle)).isDisplayed();
	}
	
	public void navigateToCheckBoxMenu() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", elementBox);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(elementBox)).click();;
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkBoxField);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxField)).click();
	}
	
	public boolean checkBoxTitleValidation() {
		return wait.until(ExpectedConditions.elementToBeClickable(checkBoxTitle)).isDisplayed();
	}
	
	public void clickExpandBtn() {
		expandBtn.click();
	}
	
	public void clickHomeExpandBtns() {
		Iterator<WebElement> it =  homeExpandBtns.iterator();
		
		while(it.hasNext()) {
			it.next().click();
		}
	}
	
	public void clickDocExpandBtns() throws InterruptedException {				
		for(WebElement ele : docExpandBtns) {
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", ele);
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		}
	}
	
	public void clickHomeCheckBox() {
		act.moveToElement(selectHomeCheckBox).click().perform();
	}
	
	public void clickDownloadsCheckBox() {
		act.moveToElement(selectDownloadsCheckBox).click().perform();
//		selectDownloadsCheckBox.click();
	}
	
	
}


































