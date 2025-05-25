package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BasePage;
import base.BaseTest;
import utils.WaitUtils;


public class HomePage extends BasePage {
	
	WebDriver driver;
    
    WaitUtils waitUtils;  
	
	
	// Constructor
    public HomePage(WebDriver driver) {
    	super(driver);// sets 'this.driver'
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }
    
 // Implement abstract method from BasePage
    @Override
    protected String getRelativeUrl() {
        return "/";  // relative URL part
    }

    
	
	@FindBy(xpath = "//ul/li/a[text()='A/B Testing']")
    public WebElement ABTesting;
	
	@FindBy(xpath = "//ul/li/a[text()='Checkboxes']")
    public WebElement Checkboxes;
	
	@FindBy(xpath = "//ul/li/a[text()='Dropdown']")
    public WebElement Dropdown;
	
	@FindBy(xpath = "//ul/li/a[text()='Frames']")
    public WebElement Frames;

	
   public HomePage openHomePage() {
	   navigateToHomePage();
	   return this;
   }
   
   
   public void verifyHomePageTitle() {
	   String actualHomePageTitle = getPageTitle();

	   String expectedHomePageTitle = "The Internet";
	   Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "Home page title mismatch!");
	}
   
   public void clickABTesting() {
	   ABTesting.click();

   }
   
   public void clickCheckboxes() {
	   Checkboxes.click();
   }
   
   public void clickDropdown() {
	   Dropdown.click();
	   
   }
   
   public void clickFrames() {
	   Frames.click();
	   
   }
   
   
}
