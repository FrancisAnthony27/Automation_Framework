package base;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public abstract class BasePage {
    protected WebDriver driver;
    private final String baseUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.baseUrl = ConfigReader.get("base.url");
    }

    protected abstract String getRelativeUrl();
    
    protected String getBaseUrl() {
        return baseUrl;
    }

    public void goBackToHomePage() {
        driver.get(baseUrl);
    }

    public void navigateToHomePage() {
        driver.get(baseUrl + getRelativeUrl());
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public String getPageTitle() {
	    return driver.getTitle(); 
	}
}
