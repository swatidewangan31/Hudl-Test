package com.hudl.steps;

import com.hudl.pages.BasePage;
import com.hudl.pages.NeedHelpPage;
import com.hudl.support.WorldHelper;
import com.hudl.utilities.SecretConfig;
import com.hudl.utilities.TestData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NeedHelpSteps {

    private BasePage basePage;
    private WorldHelper helper;
    private NeedHelpPage needHelpPage;

    public NeedHelpSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @When("I click on Need Help? link")
    public void i_click_on_need_help_link() {
        needHelpPage = helper.getNeedHelpPage().clickNeedHelpLink();
    }

    @Then("Verify the Login Help page is displayed")
    public void verify_the_login_help_page_is_displayed() {
        String text = TestData.getValue("help title");
        Assert.assertEquals(needHelpPage.verifyNeedHelpPage(), text);
    }

    @When("I enter the email address for resetting the password")
    public void i_enter_the_email_address_for_resetting_the_password() {
        String email = SecretConfig.getSecretValue("email");
        needHelpPage.enterEmailAddress(email);
    }

    @When("I click on Send Password Reset button")
    public void i_click_on_send_password_reset_button() {
       needHelpPage.clickSendResetPassButton();
    }

    @Then("Verify the email has successfully sent to the user")
    public void verify_the_email_has_successfully_sent_to_the_user() {
        String text = TestData.getValue("success msg1");
        Assert.assertEquals(needHelpPage.verifyNeedHelpSucessMsg(), text);
    }

    //invalid user to reset password

    @When("I enter the invalid email address for resetting the password")
    public void i_enter_the_invalid_email_address_for_resetting_the_password() {
        String email = TestData.getValue("email address2");
        needHelpPage.enterEmailAddress(email);
    }

    @Then("Verify error message for invalid user in help page")
    public void verify_error_message_for_invalid_user_in_help_page() {
        String text = TestData.getValue("error message2");
        Assert.assertEquals(needHelpPage.verifyErrorMessage(), text);
    }
}
