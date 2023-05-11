package com.hudl.pages;

import com.hudl.waits.WebWaits;
import com.hudl.webControls.ButtonControl;
import com.hudl.webControls.TextFieldControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeedHelpPage extends BasePage {

    @FindBy(css = "a.uni-link uni-link--default")
    private WebElement needHelpLink = null;
    @FindBy(css = "h3.uni-headline uni-headline--3 uni-margin--one--top")
    private WebElement needHelpTitle = null;
    @FindBy(css = "input[data-qa-id='password-reset-input']")
    private WebElement emailField = null;
    @FindBy(css = "button[type='submit']")
    private WebElement sendResetPassButton = null;
    @FindBy(css = "h3.uni-headline uni-headline--3")
    private WebElement needHelpSucessTitle = null;

    public NeedHelpPage(WebDriver webDriver) {
        super(webDriver);
    }

    public NeedHelpPage clickNeedHelpLink() {
        ButtonControl.clickButton(needHelpLink);
        return PageFactory.initElements(webDriver, NeedHelpPage.class);
    }

    public String verifyNeedHelpPage() {
        WebWaits.waitForElement(needHelpTitle);
        return needHelpTitle.getText();
    }

    public void enterEmailAddress(String email) {
        TextFieldControl.enterText(emailField, email);
    }

    public void clickSendResetPassButton() {
        ButtonControl.clickButton(sendResetPassButton);
    }

    public String verifyNeedHelpSucessMsg() {
        WebWaits.waitForElement(needHelpSucessTitle);
        return needHelpSucessTitle.getText();
    }
}
