package pageTests.ElementsForm;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageClass.ElementsForm.CheckBoxPage;

public class CheckBoxTest {
	WebDriver driver;
	CheckBoxPage checkBoxPage;
    
	@BeforeMethod
    public void initialize() {
    	driver = new EdgeDriver();
    	driver.get("https://demoqa.com/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		checkBoxPage = new CheckBoxPage(driver);
    }
    
    @Test
    public void tc_el_003_checkBox_ExpandAndSelectAll() throws InterruptedException {
    	Assert.assertTrue(checkBoxPage.demoQAPageValidation(), "!?DemoQa Page is not Loaded.Use External Waits to wait for the page to load");
    	checkBoxPage.navigateToCheckBoxMenu();
    	Assert.assertTrue(checkBoxPage.checkBoxTitleValidation(), "Check Box Field is Not Loaded");
    	checkBoxPage.clickExpandBtn();
    	checkBoxPage.clickHomeExpandBtns();
    	checkBoxPage.clickDocExpandBtns();
    	checkBoxPage.clickHomeCheckBox();
    }
    
    @Test
    public void tc_el_004_checkBox_ExpandAndSelectIndividually() throws InterruptedException {
    	checkBoxPage.navigateToCheckBoxMenu();
    	Assert.assertTrue(checkBoxPage.checkBoxTitleValidation(), "Check Box Field is Not Loaded");
    	checkBoxPage.clickExpandBtn();
    	checkBoxPage.clickHomeExpandBtns();
    	checkBoxPage.clickDocExpandBtns();
//    	checkBoxPage.clickHomeCheckBox();
    	checkBoxPage.clickDownloadsCheckBox();
    }
    
    @AfterMethod
    public void tearDown() {
    	if(driver != null) {
    		driver.quit();
    	}
    }

}
