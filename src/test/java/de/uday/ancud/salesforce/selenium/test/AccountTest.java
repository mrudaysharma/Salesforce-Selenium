/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uday.ancud.salesforce.selenium.test;

import de.uday.ancud.salesforce.selenium.pages.AccountPageCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 *
 * @author uysharma
 */
public class AccountTest extends LoginTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(AccountTest.class);

    @Test
    protected void testAccountCreate() throws Exception {
        LOGGER.info("==============CREATE ACCOUNT=================");
        AccountPageCreate acp = new AccountPageCreate(driver);
        acp.progressingPageLoad();
        Thread.sleep(5000); //for demo
        acp.newAccountCreate(); //used for blurring the phone input
        LOGGER.info("==============ACCOUNT CREATED=================");
        Thread.sleep(5000);
    }
    
     @Test
    protected void testAccountDelete() throws Exception {
        LOGGER.info("==============CREATE ACCOUNT=================");
        AccountPageCreate acp = new AccountPageCreate(driver);
        acp.progressingPageLoad();
        Thread.sleep(5000); //for demo
        acp.newAccountCreate(); //used for blurring the phone input
        LOGGER.info("==============ACCOUNT CREATED=================");
        Thread.sleep(5000);
    }
 
}
