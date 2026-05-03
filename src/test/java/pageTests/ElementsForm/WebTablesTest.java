package pageTests.ElementsForm;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageClass.ElementsForm.WebTablesPage;

public class WebTablesTest {
	WebDriver driver;
	WebTablesPage webtablepage;
	
	@BeforeMethod
	public void initialize() {
		driver = new EdgeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		webtablepage  = new WebTablesPage(driver);
		
	}
	
	@Test
	public void tc_el_008_webTable_VerifyDataRows() throws InterruptedException {
		Assert.assertTrue(webtablepage.demoQAPageValidation(), "!?DemoQa Page is not Loaded.Use External Waits to wait for the page to load");
		webtablepage.navigateToTextBoxMenu();
		Assert.assertTrue(webtablepage.webTablesTitleValidation(), "Web Table Page is Not Loaded Successfully");
		Assert.assertEquals(webtablepage.countOfRows(), 3, "!?Count of rows is not as expected?!");
	}
	
	@Test
	public void tc_el_009_webTable_AddNewRecord() throws InterruptedException {
		tc_el_008_webTable_VerifyDataRows();
		webtablepage.clickAddButton();
		Assert.assertTrue(webtablepage.registrationFormValidation(), "!?Registration Form is Not Loaded Check Once Again?!");
		webtablepage.addNewRecord("Bhanu", "Prakash", "admin@gmail.com", 23, 1000000, "Automation QA Testing");
		webtablepage.clickSubmitBtn();
		Assert.assertEquals(webtablepage.countOfRows(), 4, "!?Count of rows is not as expected?!");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
