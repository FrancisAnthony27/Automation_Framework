package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BasePage;
import utils.WaitUtils;

public class DropdownPage extends BasePage {
	
	WebDriver driver;
	WaitUtils waitUtils;

	// Constructor
    public DropdownPage(WebDriver driver) {
    	super(driver);
    	this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    
    // Implement abstract method from BasePage
    @Override
    protected String getRelativeUrl() {
        return "/dropdown";  // relative URL part
    }
    
    @FindBy(id = "dropdown")
    private WebElement DropdownElement;

    
    public void verifyDropdownPage() {
    	String actualUrl = getCurrentUrl();
        String expectedUrl = getBaseUrl() + getRelativeUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Dropdown Page Url mismatch!");
	}
    
    public void selectOptionFromDropdown() {
        Select dropdown = new Select(DropdownElement);
        dropdown.selectByVisibleText("Option 1");

        String selectedOption = dropdown.getFirstSelectedOption().getText();
        System.out.println(selectedOption);
        Assert.assertEquals(selectedOption, "Option 1", "Option 1 is not selected by default!");
    }
    
    
    public HomePage navigateBackToHomePage() {
		goBackToHomePage(); // Call the inherited method
        return new HomePage(driver); // Assuming HomePage is your home page class
    }
	
}
