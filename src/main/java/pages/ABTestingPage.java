package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BasePage;
import utils.WaitUtils;


public class ABTestingPage extends BasePage {
	
	WebDriver driver;
	WaitUtils waitUtils;

	// Constructor
    public ABTestingPage(WebDriver driver) {
    	super(driver);    	
    	this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    
    
    // Implement abstract method from BasePage
    @Override
    protected String getRelativeUrl() {
        return "/abtest";  // relative URL part
    }
    
    //@FindBy(xpath = "//h3[contains(text(),'A/B Test Variation 1')]")
    @FindBy(xpath = "//h3[text()='A/B Test Variation 1']")
    public WebElement ABTestVariationTitle;
	
	
    public void verifyABTestingPage() {
    	String actualUrl = getCurrentUrl();
        String expectedUrl = getBaseUrl() + getRelativeUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "AB Test Page Url mismatch!");
	}
    
	public void verifyABTestVariationTitle() {
		waitUtils.waitForVisibility(ABTestVariationTitle);
		String actualTitle = ABTestVariationTitle.getText();
		String expectedTitle = "A/B Test Variation 1";
	    System.out.println("Actual Title: " + actualTitle);
	    Assert.assertEquals(actualTitle, expectedTitle, "AB Test Variation Title mismatch!");
	}

	
	public HomePage navigateBackToHomePage() {
		goBackToHomePage(); // Call the inherited method
        return new HomePage(driver); // Assuming HomePage is your home page class
    }
	 
	
}
