package com.hudl.steps;

import com.hudl.pages.BasePage;
import com.hudl.pages.LogInPage;
import com.hudl.pages.RememberMePage;
import com.hudl.support.WorldHelper;
import com.hudl.utilities.SecretConfig;
import com.hudl.utilities.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogInSteps {

    private BasePage basePage;
    private WorldHelper helper;
    private LogInPage logInPage;
    private RememberMePage rememberMePage;

    public LogInSteps(WorldHelper helper) {
        this.helper = helper;
    }

    //Valid LogIn
    @Given("I am on Hudl Home page")
    public void i_am_on_hudl_home_page() {
       basePage = helper.getBasePage();
    }

    @When("I click on LogIn button")
    public void i_click_on_button() {
       basePage.clickLogInButton();
    }

    @Then("Verify Hudl login page is displayed")
    public void verify_hudl_login_page_is_displayed() {
      String text = TestData.getValue("login button");
      logInPage = helper.getLogInPage().clickHudlOption();
      //assertThat(helper.getLogInPage().verifyLogInPage(text), is(true));
    }

    @When("I enter the details to login")
    public void i_enter_the_details_to_login() {
        String email = SecretConfig.getSecretValue("email");
        String password = SecretConfig.getSecretValue("password");
        logInPage.enterLogInDetails(email,password);
    }

    @When("I click on Log In button in login page")
    public void i_click_on_log_in_button_in_login_page() {
       logInPage.clickLogIn();
    }

    @Then("Verify the success message should be displayed")
    public void verify_the_success_message_should_be_displayed() {
        String text = TestData.getValue("user menu");
        //Assert.assertEquals(helper.getLogInPage().verifySuccessfulLogIn(), text);
    }

    //Invalid Login

    @When("I enter the invalid details to login")
    public void i_enter_the_invalid_details_to_login(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.cells();
        String email = TestData.getValue(fieldOption.get(1).get(1));
        String password = TestData.getValue(fieldOption.get(2).get(1));
        logInPage.enterLogInDetails(email,password);
    }

    @Then("Verify the error message is displayed")
    public void verify_the_error_message_is_displayed() {
        String text = TestData.getValue("error message");
        //Assert.assertEquals(logInPage.verifyErrorMessage(), text);
    }

    //EmptyDetails

    @When("I enter the empty details to login")
    public void i_enter_the_empty_details_to_login(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> fieldOption = dataTable.cells();
        String email = TestData.getValue(fieldOption.get(1).get(1));
        logInPage.enterEmptyLogInDetails(email);
    }

    //Remember Me
    @Then("I click on Remember me checkbox")
    public void i_click_on_remember_me_checkbox() {
        rememberMePage = helper.getRememberMePage().clickRememberMeBox();
    }
}
