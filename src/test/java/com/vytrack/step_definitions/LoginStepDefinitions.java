package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Map;

public class LoginStepDefinitions {
    //Write code here that turns the phrase above into concrete actions
  LoginPage loginPage= new LoginPage(); // created login page object
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("I am on the login page");
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user logs in as store manager")
    public void user_logs_in_as_store_manager() {

        System.out.println("Login as store manager");
        //We read user name and password from properties files
        String userName=ConfigurationReader.getProperty("user_name");
        String password=ConfigurationReader.getProperty("password");
        loginPage.login(userName,password);
       // throw new RuntimeException("Error");
    }

    @Then("user verifies that {string} page subtitle displayed")
    public void user_verifies_that_page_subtitle_displayed(String string) {
        //use loader mask to fix page loading issue
        loginPage.waitUntilLoaderMaskDisappear();
        //Browser utile will make it slow
        BrowserUtils.wait(3);
        Assert.assertEquals(string, loginPage.getPageSubTitle());
        System.out.println("Verifying the page subtitle: "+string);
    }

    @Then("user logs in as driver")
    public void user_logs_in_as_driver() {
        System.out.println("Login as driver");
        String userName=ConfigurationReader.getProperty("driver.username");
        String password=ConfigurationReader.getProperty("password");
        loginPage.login(userName,password);
    }

    @Then("user logs in as sales manager")
    public void user_logs_in_as_sales_manager() {
        System.out.println("Login as sales manager");
        String userName=ConfigurationReader.getProperty("store.manager.username");
        String password=ConfigurationReader.getProperty("password");
        loginPage.login(userName,password);
       // throw new RuntimeException("test fialed just because!");
    }

  // Then user enter "storemanager85" username and "Wrong"password
    @Then("user enter {string} username and {string} password")
    public void user_enter_username_and_password(String string, String string2) {
        System.out.println("Login with "+string+" Username and "+string2+" password");
        loginPage.login(string,string2);
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        System.out.println("Verified that warning message is displayed:"+string);
    }


    @Then("user logs in as driver with following credentials")
    public void user_logs_in_as_driver_with_following_credentials(Map<String,String> dataTable) {
       System.out.println(dataTable);
       loginPage.login(dataTable.get("username"),dataTable.get("password"));
    }

    @Then("user logs in as {string}")
    public void user_logs_in_as(String role) {
   loginPage.login(role);
    }
    @Then("the page title should be {string}")
    public void the_page_title_should_be(String string) {

        BrowserUtils.wait(2);
        BrowserUtils.waitForPageTitle(string);
       // Assert.assertEquals(string, Driver.get().getTitle());
        Assert.assertEquals("Title is incorrect", string, Driver.get().getTitle());
        //masla tha  mera dost
    }

}
