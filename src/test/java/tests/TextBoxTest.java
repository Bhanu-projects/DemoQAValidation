package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TextBoxPage; // Import the page class you just made

public class TextBoxTest {
	WebDriver driver;
	TextBoxPage textBoxPage; // Declare the page object

	@BeforeMethod
	public void setup() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");

		// Initialize the page object by passing the driver
		textBoxPage = new TextBoxPage(driver); 
	}

	@Test
	public void tc_el_001_validTextBoxSubmission() {
		textBoxPage.navigateToTextBoxMenu();
		textBoxPage.enterFullName("VNR Academy");
		textBoxPage.enterFullEmail("vnracademy@gmail.com");
		textBoxPage.enterCurrentAddress("ESI Hospital, Hyderabad, Telangana, 500038");
		textBoxPage.enterPermanentAddress("Santhosh Nagar Colony, Kurnool, AP, 518006");
		textBoxPage.clickSubmit();
		Assert.assertTrue(textBoxPage.isResultBoxDisplayed(), "Result box did not appear!");
	}

	@Test()
	public void tc_el_002_invalidEmailFormat() {
		textBoxPage.navigateToTextBoxMenu();
		textBoxPage.enterEmail("abc@");
		textBoxPage.clickSubmit();
		Assert.assertTrue(textBoxPage.isEmailErrorDisplayed(), "Error border was not displayed for invalid email!");
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}