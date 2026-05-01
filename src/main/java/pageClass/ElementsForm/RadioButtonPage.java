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

public class RadioButtonPage {
		
		WebDriver driver;
		WebDriverWait wait;
		JavascriptExecutor js;
		Actions act;
		
		public RadioButtonPage(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			this.js = (JavascriptExecutor) driver;
			this.act = new Actions(driver);
			
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//h5[contains(text(),'Elements')]")
		WebElement elementBox;
		
		@FindBy(xpath = "//span[contains(text(),'Radio Button')]")
		WebElement radioButtonField;
		
		@FindBy(className = "text-center")
		WebElement radioButtonTitle;
		
		@FindBy(id = "yesRadio")
		WebElement yesRadioButton;
		
		@FindBy(className = "mt-3")
		WebElement selectedMsg;
		
		@FindBy(className = "text-success")
		WebElement yesMsg;
		
		public void navigateToRadioButtonMenu() throws InterruptedException {
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", elementBox);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(elementBox)).click();;
			
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", radioButtonField);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(radioButtonField)).click();
		}
		
		public boolean radioButtonTitleValidation() {
			return wait.until(ExpectedConditions.elementToBeClickable(radioButtonTitle)).isDisplayed();
		}
		
		public void selectYesRadioButton() {
			act.moveToElement(yesRadioButton).click().perform();
		}
		
		public boolean selectedYesButtonMessage() {
			String selectedTextMsg = selectedMsg.getText();
			if(selectedTextMsg.equalsIgnoreCase("You have selected Yes")) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		
		
}



































