package de.uday.accenture.salesforce.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Navigates to the login page, does the login for you, and returns you a HomePage object
	 * @param loginUrl - url to the login form
	 * @param username - admin username
	 * @param pass - admin password
	 * @return HomePage object
	 * @throws InterruptedException
	 */
	public HomePage doLogin(String loginUrl, String username, String pass) throws InterruptedException{
		driver.get(loginUrl);
		this.getUsernameInput().sendKeys(username);
		this.getPasswordInput().sendKeys(pass);
		Thread.sleep(5000); //for demo
		WebElement login = driver.findElement(By.cssSelector("input#Login"));
		login.click();
		super.waitForElementToStale(login, "login button", 30);
		return this;
	}
	
	/**
	 * @return username input box
	 */
	public WebElement getUsernameInput(){
		return driver.findElement(By.name(INPUT_USERNAME_CSS));
	}
	
	/**
	 * @return password input box
	 */
	public WebElement getPasswordInput(){
		return driver.findElement(By.name(INPUT_PASSWORD_CSS));
	}
	
	/**
	 * Waits for a unique page identifier to be displayed
	 */
	public void waitForPageLoad(){
		super.waitForPageLoad(PAGE_HOME_IDENTIFIER_ANCH);
	}
        
        public void gotoHomepage(){
            super.goToRelativeUrl(CommanVariable.HOME_URL);
        }
        
       
}
