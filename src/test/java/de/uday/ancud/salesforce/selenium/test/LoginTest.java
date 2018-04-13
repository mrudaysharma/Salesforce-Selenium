/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uday.ancud.salesforce.selenium.test;

import de.uday.ancud.salesforce.selenium.pages.CommanVariable;
import de.uday.ancud.salesforce.selenium.pages.HomePage;
import java.util.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author uysharma
 */
public class LoginTest extends CommanVariable {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);
    public static WebDriver driver = null;

    @BeforeSuite
    protected void login() throws Exception {
        LOGGER.info("==============SALESFORCE-LOGIN=================");
        System.setProperty("webdriver.chrome.driver", System.getProperty("project.basedir"));
        driver = new ChromeDriver();
        LOGGER.info("LOGIN URL : https://udaysharma-dev-ed.lightning.force.com");
        LOGGER.info("USER_NAME :" + USER_ID);
        LOGGER.info("ENCRYPTED PASSWORD :" + PASSWORD);
        HomePage hp = new HomePage(driver).doLogin("https://udaysharma-dev-ed.lightning.force.com",
                USER_ID,
                new String(Base64.getDecoder().decode(PASSWORD)));
        if(driver.getTitle().equals("Home | Salesforce"))
        {
        LOGGER.info("==============LOGIN-SUCESSFULL=================");
        }
        hp.gotoHomepage();
        hp.waitForPageLoad();
        Thread.sleep(5000); //for demo
    }

    @AfterSuite
    protected void logout() throws Exception {
        driver.close();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}
