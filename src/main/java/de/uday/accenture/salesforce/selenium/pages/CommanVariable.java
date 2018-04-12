/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uday.accenture.salesforce.selenium.pages;

/**
 *
 * @author uysharma
 */
public class CommanVariable {
    
    public static final String USER_ID = "mr.mickeysharma@gmail.com";
    public static final String PASSWORD = "TWF5YW5rMjIzMzg4";

    public static String BASE_URL = "https://udaysharma-dev-ed.lightning.force.com/lightning/";
    public static String HOME_URL = "/lightning/page/home";
    public static String ACCOUNT_URL = "/lightning/o/Account/home/";
    public static String ACCOUNT_ID_VIEW = "/view";

    public static final String URL = "/r/Account/";
    public static final String PAGE_IDENTIFIER_CSS = "//a[@href='/lightning/o/Account/home']";
    public static final String NEW_ACCOUNT_XPATH = "//a[@title='New']";
    public static final String NAME_INPUT_CSS = "input[id*='name']";
    public static final String PHONE_INPUT_CSS = "input[id*='phone']";
    public static final String SAVE_BUTTON_CSS = "input[id*='save']";

    public static final String INPUT_PASSWORD_CSS = "pw";
    public static final String INPUT_USERNAME_CSS = "username";
    public static final String PAGE_HOME_IDENTIFIER_ANCH = "//a[@href='/lightning/page/home']";
}
