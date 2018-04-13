package de.uday.ancud.salesforce.selenium.pages;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page extends CommanVariable {

    public static final Logger LOGGER = LoggerFactory.getLogger(Page.class);
    protected final WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRelativeUrl(String partialUrl) {
        try {
            URL currentUrl = new URL(driver.getCurrentUrl());
            partialUrl = partialUrl.startsWith("/") ? partialUrl : "/" + partialUrl;
            URL targetUrl = new URL(currentUrl.getProtocol(), currentUrl.getHost(), partialUrl);
            LOGGER.info("NAVIGATING TO: " + targetUrl.toExternalForm());
            driver.get(targetUrl.toExternalForm());
        } catch (Exception exc) {
            throw new RuntimeException("could not navigate to relative url: " + partialUrl);
        }
    }

    public void waitForElementToStale(WebElement webElement, String descriptor, int secondsToWait) {
        System.out.println("Waiting for " + descriptor + " to stale.");
        long timeout = System.currentTimeMillis() + (secondsToWait * 1000);
        while (timeout > System.currentTimeMillis()) {
            try {
                webElement.isDisplayed();
            } catch (StaleElementReferenceException e) {
                return;
            }
        }
        throw new RuntimeException("Timed out while waiting for a WebElement described as: '" + descriptor + "' to go stale.");
    }

    public void waitForElementToBeClickable(String locator, int secondsToWait) {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

    }

    public void waitForPageLoad(String pageIdentifierCss) {
        this.waitForElementToBeClickable(pageIdentifierCss, 60);
    }
}
