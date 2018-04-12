package de.uday.accenture.salesforce.selenium.pages;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page extends CommanVariable{

    protected final WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navivates to a relative URL on the current domain.
     *
     * @param partialUrl The relative URL to go to
     * @throws MalformedURLException
     */
    public void goToRelativeUrl(String partialUrl) {
        try {
            URL currentUrl = new URL(driver.getCurrentUrl());
            partialUrl = partialUrl.startsWith("/") ? partialUrl : "/" + partialUrl;
            URL targetUrl = new URL(currentUrl.getProtocol(), currentUrl.getHost(), partialUrl);
            System.out.println("Navigating to " + targetUrl.toExternalForm());
            driver.get(targetUrl.toExternalForm());
             //driver.get(partialUrl);
        } catch (Exception exc) {
            throw new RuntimeException("could not navigate to relative url: " + partialUrl);
        }
    }

    /**
     * Waits for an element to go stale, which means that the page has been torn
     * down This is best used after a click, when waiting for the new page to
     * load.
     * http://www.obeythetestinggoat.com/how-to-get-selenium-to-wait-for-page-load-after-a-click.html
     *
     * @param webElement - a WebElement object that already exists
     * @param descriptor - An English description of the element.
     * @param secondsToWait - timeout for how long to poll the element
     */
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

    /**
     * Wait for an an element to be loaded into the DOM and then wait for it to
     * be clickable
     *
     * @param locator - css selector for the element to be waited upon
     * @param secondsToWait - number of seconds to wait
     */
    public void waitForElementToBeClickable(String locator, int secondsToWait) {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

    }

    /**
     * Waits for a unique page identifier to be available for interaction
     *
     * @param pageIdentifierCss - css selector of unique page element.
     */
    public void waitForPageLoad(String pageIdentifierCss) {
        this.waitForElementToBeClickable(pageIdentifierCss, 60);
    }
}
