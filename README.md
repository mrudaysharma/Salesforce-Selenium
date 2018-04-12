## Project Set-up
* Install maven
* Install Eclipse
* Clone this project to your local machine
* In Eclipse, go to File -> Import... -> Maven -> Existing Maven Projects
* Browse to this project location on your local filesystem and use that as the root directory
* Check the box for the dream.force.selenium pom.xml file and click finish

## Salesforce Org setup
* Load the Lightning Design System into org as a static resource
 
* Create new Visualforce page called Account.page
  *  Paste the contents of /git/download/location/Account.page into VF page.
  * Save
* Create new account via standard UI, save ID.

## Salesforce Selenium specific set-up
* Download latest chromedriver
  * https://sites.google.com/a/chromium.org/chromedriver/downloads
  * In AccountEditTest.java, replace ${project.build}/src/test/chromedriver with location of chromedriver on your machine.


## Run
* Create a new run configuration of type JUnit
  * Select radio to run all tests in Dreamforce16Selenium project
* Click run!
