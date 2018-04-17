package de.uday.ancud.salesforce.selenium.test;

import de.uday.ancud.salesforce.selenium.pages.AccountPageCreate;
import de.uday.ancud.salesforce.selenium.pages.LoginPage;
import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountEditTest extends TestCase {

    WebDriver driver = null;

    public void testPhoneNumber() throws InterruptedException {
            //hardcoded chrome driver and login info to simplify demo
        System.setProperty("webdriver.chrome.driver", System.getProperty("project.basedir"));
            driver = new ChromeDriver();
          
            LoginPage hp = new LoginPage(driver).doSignIn("https://udaysharma-dev-ed.lightning.force.com",
                    "mr.mickeysharma@gmail.com",
                    "Mayank223388");
            hp.gotoIndexPage();
            hp.renderingPage();
            Thread.sleep(5000); //for demo
            
            AccountPageCreate acp = new AccountPageCreate(driver);
            acp.progressingPageLoad();
            Thread.sleep(5000); //for demo
            acp.newAccountCreate(); //used for blurring the phone input
            Thread.sleep(5000);
         
            driver.close();
        
    }
}
