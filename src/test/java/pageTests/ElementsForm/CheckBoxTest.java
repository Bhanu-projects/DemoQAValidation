package pageTests.ElementsForm;

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
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		checkBoxPage = new CheckBoxPage(driver);
    }
    
    @Test(invocationCount = 2)
    public void tc_el_003_checkBoxExpandAndSelectAll() throws InterruptedException {
    	
    	checkBoxPage.navigateToCheckBoxMenu();
    	Assert.assertTrue(checkBoxPage.checkBoxTitleValidation());
    	checkBoxPage.clickExpandBtn();
    	checkBoxPage.clickHomeExpandBtns();
    	checkBoxPage.clickDocExpandBtns();
    	checkBoxPage.clickHomeCheckBox();
    }
    
    @Test(invocationCount = 2)
    public void tc_el_004_checkBoxExpandAndSelectIndividually() throws InterruptedException {
    	checkBoxPage.navigateToCheckBoxMenu();
    	Assert.assertTrue(checkBoxPage.checkBoxTitleValidation());
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
