# Dreamforce16Selenium
Project download for presentation at DF16 (https://success.salesforce.com/Sessions?eventId=a1Q3000000qQOd9EAG#/session/a2q3A000000LBdpQAG)

## Project Set-up
* Install maven
* Install Eclipse
* Clone this project to your local machine
* In Eclipse, go to File -> Import... -> Maven -> Existing Maven Projects
* Browse to this project location on your local filesystem and use that as the root directory
* Check the box for the dream.force.selenium pom.xml file and click finish
This is great tutorial on setting up a selenium and maven project.  It's for creating a brand new project from scratch, where you are probably looking to download this existing project and import it, but it will still provide more details on getting everything set up.
http://www.wunderkraut.com/blog/creating-and-running-a-simple-selenium-webdriver-test/2011-09-15 

## Salesforce Org setup
* Load the Lightning Design System into org as a static resource
  * Since this is a Visualforce page with Lightning styling, you'll have to load the SLDS css into your org.
  * Instructions for how to do this are here:
    * https://trailhead.salesforce.com/en/lightning_design_system/lightning-design-system2
    * https://www.lightningdesignsystem.com/faq/#how-do-i-link-to-visualforce-static-resources-like-stylesheets-and-icons
  * Note: The Account.page Visualforce page is referencing a static resource called SLDS212 
    * `<apex:stylesheet value="{!URLFOR($Resource.SLDS212, 'assets/styles/salesforce-lightning-design-system.css')}" />`
    * So either name your static resource "SLDS212" or change the reference in the VF Account.page.

* Create new Visualforce page called Account.page
  *  Paste the contents of /git/download/location/Account.page into VF page.
  * Save
* Create new account via standard UI, save ID.

## Dreamforce16Selenium specific set-up
* Download latest chromedriver
  * https://sites.google.com/a/chromium.org/chromedriver/downloads
  * In AccountEditTest.java, replace /location/of/chromedriver with location of chromedriver on your machine.
* Input Salesforce credentials
  * In AccountEditTest.java, replace test@df.test / password with your own username and password
* Replace the hardcoded ID in `String accountId = "00141000003Nm5F";` with the ID from your newly created account.

## Run
* Create a new run configuration of type JUnit
  * Select radio to run all tests in Dreamforce16Selenium project
* Click run!
