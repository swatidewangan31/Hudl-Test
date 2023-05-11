package com.hudl.steps;

import com.hudl.pages.BasePage;
import com.hudl.pages.LogInPage;
import com.hudl.support.WorldHelper;
import com.hudl.utilities.SecretConfig;
import com.hudl.utilities.TestData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogInAsOrgSteps {

    private BasePage basePage;
    private WorldHelper helper;
    private LogInPage logInPage;

    public LogInAsOrgSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("I click on Log In with an Organisation button")
    public void i_click_on_login_as_org_button() {
      logInPage = helper.getLogInPage().clickLogInAsOrg();
    }

    @Then("Verify Hudl login as organisation page is displayed")
    public void verify_hudl_login_as_organisation_page_is_displayed() {
        String header = TestData.getValue("org title");
        Assert.assertEquals(logInPage.verifyLogInAsOrgPage(), header);
    }

    @When("I enter the details to login as Org")
    public void i_enter_the_details_to_login_as_org() {
        String email = SecretConfig.getSecretValue("email");
        logInPage.enterLogInAsOrgDetails(email);
    }

    @When("I click on Log In button in org page")
    public void i_click_on_log_in_button_in_org_page() {
       logInPage.clickLogInAsOrgButton();
    }

    @Then("Verify the error message is displayed for an org")
    public void verify_the_error_message_is_displayed_for_an_org() {
        String text = TestData.getValue("error message3");
        Assert.assertEquals(helper.getBasePage().verifyErrorMessage(), text);
    }

}
