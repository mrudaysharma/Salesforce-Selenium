package de.uday.accenture.salesforce.selenium.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPageCreate extends Page{
	

	public AccountPageCreate(WebDriver driver) {
		super(driver);
		this.goToRelativeUrl(CommanVariable.ACCOUNT_URL);
	}
	public WebElement getPhoneInput(){
		return driver.findElement(By.cssSelector(PHONE_INPUT_CSS));
	}
	
	/**
	 * @return save button
	 */
	public WebElement getSaveButton(){
		return driver.findElement(By.cssSelector(SAVE_BUTTON_CSS));
	}

	/**
	 * Click the save button
	 */
	public void save(){
		this.getSaveButton().click();
	}

	/**
	 * Waits for a unique page identifier to be displayed
	 */
	public void waitForPageLoad() {
		super.waitForPageLoad(PAGE_IDENTIFIER_CSS);
	}

	/**
	 * @return account name input field
	 */
	public WebElement getNameInput() {
		return driver.findElement(By.cssSelector(NAME_INPUT_CSS));
	}
        
         
        public void newAccountCreate() {
            try {
                super.waitForPageLoad(NEW_ACCOUNT_XPATH);
                driver.findElement(By.xpath(NEW_ACCOUNT_XPATH)).click();
                Thread.sleep(5000);
                driver.findElement(By.cssSelector("input.input.uiInput.uiInputText.uiInput--default.uiInput--input")).sendKeys("MyAccount");
                Thread.sleep(500);
                driver.findElement(By.xpath("//button[@type='button' and @title='Save']")).click();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(AccountPageCreate.class.getName()).log(Level.SEVERE, null, ex);
            }
                
	}
       
        
}
