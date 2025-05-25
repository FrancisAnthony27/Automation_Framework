package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BasePage;
import utils.WaitUtils;


public class FramePage extends BasePage {
	
	WebDriver driver;
	WaitUtils waitUtils;
	// Constructor
    public FramePage(WebDriver driver) {
    	super(driver);
    	this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    
    // Implement abstract method from BasePage
    @Override
    protected String getRelativeUrl() {
        return "/frames";  // relative URL part
    }
    
    @FindBy(xpath = "//ul/li/a[@href='/nested_frames']")
    private WebElement NestedFrameLink;

    @FindBy(xpath = "//ul/li/a[@href='/iframe']")
    private WebElement IFrameLink;
	
	
    public void verifyFramePage() {
    	String actualUrl = getCurrentUrl();
        String expectedUrl = getBaseUrl() + getRelativeUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Frame Page Url mismatch!");
	}
    
    public void verifyFramesHyperlink() {
    	Assert.assertTrue(NestedFrameLink.isDisplayed(), "Nested Frames link is not displayed.");
        Assert.assertEquals(NestedFrameLink.getAttribute("href"), 
        		getBaseUrl() + "/nested_frames", "Nested Frames hyperlink mismatch.");

        Assert.assertTrue(IFrameLink.isDisplayed(), "iFrame link is not displayed.");
        Assert.assertEquals(IFrameLink.getAttribute("href"), 
        		getBaseUrl() + "/iframe", "iFrame hyperlink mismatch.");
    
	}
    
    
    public HomePage navigateBackToHomePage() {
		goBackToHomePage(); // Call the inherited method
        return new HomePage(driver); // Assuming HomePage is your home page class
    }
    
}
