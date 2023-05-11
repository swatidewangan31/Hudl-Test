package com.hudl.pages;

import com.hudl.waits.WebWaits;
import com.hudl.webControls.ButtonControl;
import com.hudl.webControls.TextFieldControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "logIn")
    private WebElement logInTitle = null;
    @FindBy(id = "email")
    private WebElement emailElement = null;
    @FindBy(id = "password")
    private WebElement passwordElement = null;
    @FindBy(css = "h5[class = 'uni-avatar__initials uni-avatar__initials--user']")
    private WebElement userTitleElement = null;
    @FindBy(css = "button[data-qa-id = 'log-in-with-organization-btn']")
    private WebElement logInAsOrg = null;
    @FindBy(css = "h2.uni-headline uni-headline--2 uni-padding--one _3ZchjyyL4lRtJSkmDHSLIy")
    private WebElement orgTitleElement = null;
    @FindBy(css = "button[data-qa-id = 'log-in-with-sso']")
    private WebElement logInAsOrgButton = null;
    @FindBy(id = "uniId_1")
    private WebElement emailForOrgElement = null;

    //Log In

    public boolean verifyLogInPage(String text) {
        WebWaits.waitForTextToBePresent(logInTitle, text);
        return logInTitle.getAttribute("id").contains(text);
    }

    public void enterLogInDetails(String email, String password) {
        TextFieldControl.enterText(emailElement, email);
        TextFieldControl.enterText(passwordElement, password);
    }

    public void clickLogIn() {
        ButtonControl.clickButton(logInTitle);
    }

    public String verifySuccessfulLogIn() {
        WebWaits.waitForElement(userTitleElement);
        return userTitleElement.getText();
    }


    //LogIn As Org

    public LogInPage clickLogInAsOrg() {
        ButtonControl.clickButton(logInAsOrg);
        return PageFactory.initElements(webDriver, LogInPage.class);
    }


    public String verifyLogInAsOrgPage() {
        WebWaits.waitForElement(orgTitleElement);
        return orgTitleElement.getText();
    }

    public void clickLogInAsOrgButton() {
        ButtonControl.clickButton(logInAsOrgButton);
    }

    public void enterLogInAsOrgDetails(String email) {
        TextFieldControl.enterText(emailForOrgElement, email);
    }

    //EmptyDetails

    public void enterEmptyLogInDetails(String email) {
        TextFieldControl.enterText(emailElement, email);
    }
}
