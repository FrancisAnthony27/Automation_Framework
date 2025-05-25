package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.ABTestingPage;
import pages.DropdownPage;
import pages.FramePage;
import pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefs{

	
    @Before
    public void setup() {
        BaseTest.initDriver(); 		
        System.out.println("Browser Opens");
    }

    @After
    public void tearDown() {
        BaseTest.quitDriver(); 
        System.out.println("Browser Closed");
    }
    
    
    @Given("Launch the home page")
    public void launch_the_home_page() {
    	new HomePage(BaseTest.driver)
        .openHomePage()
        .verifyHomePageTitle(); 
    }
    
    @When("Navigate to AB Testing page")
    public void navigate_to_ab_testing_page() {
    	new HomePage(BaseTest.driver)
        .clickABTesting();
    	
    	new ABTestingPage(BaseTest.driver)
        .verifyABTestingPage();
    }
    
    @Then("Verify AB Test Variation title")
    public void verify_a_b_test_variation_title() {
    	
    	new ABTestingPage(BaseTest.driver)
        .verifyABTestVariationTitle();
    }
    
    @When("Navigate back to home page")
    public void navigate_back_to_home_page() {
    	new ABTestingPage(BaseTest.driver)
    	.navigateBackToHomePage();
    }
    
    @When("Navigate to Dropdown page")
    public void navigate_to_dropdown_page() {
    	new HomePage(BaseTest.driver)
    	.clickDropdown();
    	
    	new DropdownPage(BaseTest.driver)
    	.verifyDropdownPage();
    }
    
    @Then("Verify the dropdown option is selected")
    public void verify_the_dropdown_option_is_selected() {
    	new DropdownPage(BaseTest.driver)
        .selectOptionFromDropdown();
    }
    
    @When("Navigate to Frame page")
    public void navigate_to_frame_page() {
    	new HomePage(BaseTest.driver)
    	.clickFrames();
    	
    	new FramePage(BaseTest.driver)
    	.verifyFramePage();
    }
    
    @Then("Verify the hyperlinks in frames")
    public void verify_the_hyperlinks() {
    	new FramePage(BaseTest.driver)
    	.verifyFramesHyperlink();
    	
    }
    
    
    
}

