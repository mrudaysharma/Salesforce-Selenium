/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uday.accenture.salesforce.selenium.test;

import de.uday.accenture.salesforce.selenium.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author uysharma
 */
public class LoginTest {
    
     public static WebDriver driver = null;
    
    
    @BeforeSuite
    protected void login() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("project.basedir"));
            driver = new ChromeDriver();
          
            HomePage hp = new HomePage(driver).doLogin("https://udaysharma-dev-ed.lightning.force.com",
                    "mr.mickeysharma@gmail.com",
                    "Mayank223388");
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
