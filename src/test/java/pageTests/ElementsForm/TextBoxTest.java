package pageTests.ElementsForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageClass.ElementsForm.TextBoxPage;

public class TextBoxTest {
	WebDriver driver;
	TextBoxPage textBoxPage;

	@BeforeMethod
	public void initialize() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		textBoxPage = new TextBoxPage(driver);
	}

	@Test()
	public void tc_el_001_validTextBoxSubmission() throws InterruptedException {
		textBoxPage.navigateToTextBoxMenu();
		textBoxPage.enterFullName("VNR Academy");
		textBoxPage.enterFullEmail("vnracademy@gmail.com");
		textBoxPage.enterCurrentAddress("ESI Hospital, Hyderabad, Telangana, 500038");
		textBoxPage.enterPermanentAddress("Santhosh Nagar Colony, Kurnool, AP, 518006");
		textBoxPage.clickSubmit();
		Assert.assertTrue(textBoxPage.isResultBoxDisplayed(), "Result box did not appear!");
	}

	@Test()
	public void tc_el_002_invalidEmailFormat() throws InterruptedException {
		textBoxPage.navigateToTextBoxMenu();
		textBoxPage.enterEmail("abc@");
		textBoxPage.clickSubmit();
		Assert.assertTrue(textBoxPage.isEmailErrorDisplayed(), "Error border was not displayed for invalid email!");
	}

	@AfterMethod
	public void teardown() {
//		if (driver != null) {
//			driver.quit();
//		}
		driver.quit();
	}
}