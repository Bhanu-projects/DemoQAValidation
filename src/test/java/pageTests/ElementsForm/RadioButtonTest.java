package pageTests.ElementsForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageClass.ElementsForm.RadioButtonPage;

public class RadioButtonTest {
	
	WebDriver driver;
	RadioButtonPage radioButtonPage;
    
	@BeforeMethod
    public void initialize() {
    	driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		radioButtonPage = new RadioButtonPage(driver);
    }
    
    @Test
    public void tc_el_005_yesRadioButtonSelection () throws InterruptedException {
    	Assert.assertTrue(radioButtonPage.demoQAPageValidation(), "!?DemoQa Page is not Loaded.Use External Waits to wait for the page to load");
    	radioButtonPage.navigateToRadioButtonMenu();
    	Assert.assertTrue(radioButtonPage.radioButtonTitleValidation(), "!?Radio Button Field is Not Loaded Successfully!?");
    	radioButtonPage.selectYesRadioButton();
    	Assert.assertTrue(radioButtonPage.getSelectedButtonMessage(), "!?You have selected Yes Message is not Displayed!?");
    }
    
    @Test
    public void tc_el_006_impressiveRadioButtonSelection() throws InterruptedException {
    	radioButtonPage.navigateToRadioButtonMenu();
    	Assert.assertTrue(radioButtonPage.radioButtonTitleValidation(), "!?Radio Button Field is Not Loaded Successfully!?");
    	radioButtonPage.selectImpressiveRadioButton();
    	Assert.assertTrue(radioButtonPage.getSelectedButtonMessage(), "!?You have selected Impressive Message is not Displayed!?");
    }
    
    @Test
    public void tc_el_007_noRadioButtonSelection() throws InterruptedException {
    	radioButtonPage.navigateToRadioButtonMenu();
    	Assert.assertTrue(radioButtonPage.radioButtonTitleValidation(), "!?Radio Button Field is Not Loaded Successfully!?");
    	Assert.assertFalse(radioButtonPage.noRadioButtonIsEnabled(), "!?NO Radio Button is Enabled Check Once!?");
    }
    
    
    @AfterMethod
    public void tearDown() {
    	if(driver != null) {
    		driver.quit();
    	}
    }

}
