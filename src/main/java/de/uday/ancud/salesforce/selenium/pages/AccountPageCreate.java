package de.uday.ancud.salesforce.selenium.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

public class AccountPageCreate extends Page {

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AccountPageCreate.class);

    public AccountPageCreate(WebDriver driver) {
        super(driver);
        this.goToRelativeUrl(CommanVariable.ACCOUNT_URL);
    }

    public WebElement getPhoneInput() {
        return driver.findElement(By.cssSelector(PHONE_INPUT_CSS));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.cssSelector(SAVE_BUTTON_CSS));
    }

    public void save() {
        this.getSaveButton().click();
    }

    public void waitForPageLoad() {
        super.waitForPageLoad(PAGE_IDENTIFIER_CSS);
    }

    public WebElement getNameInput() {
        return driver.findElement(By.cssSelector(NAME_INPUT_CSS));
    }

    public void newAccountCreate() {
        try {
            String accountName;
            super.waitForPageLoad(NEW_ACCOUNT_XPATH);
            LOGGER.info("CLICK ON NEW BUTTON");
            driver.findElement(By.xpath(NEW_ACCOUNT_XPATH)).click();
            Thread.sleep(5000);
            if(System.getProperty("account.name")== null ||System.getProperty("account.name").isEmpty() )
            {
             System.setProperty("account.name","MyAccount");  
            }
            LOGGER.info("FILL FORM: ACCOUNT NAME: "+System.getProperty("account.name"));
            driver.findElement(By.cssSelector("input.input.uiInput.uiInputText.uiInput--default.uiInput--input")).sendKeys(System.getProperty("account.name"));
            Thread.sleep(500);
            LOGGER.info("CLICK SAVE");
            driver.findElement(By.xpath("//button[@type='button' and @title='Save']")).click();
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountPageCreate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
