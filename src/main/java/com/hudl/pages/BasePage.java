package com.hudl.pages;

import com.hudl.waits.WebWaits;
import com.hudl.webControls.ButtonControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver webDriver;
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(css = "body > div.outer > header > div > div > a")
    private WebElement buttonElement = null;
    @FindBy(css = "body > div.outer > header > div > div > div > div > div:nth-child(1) > div > a > span")
    private WebElement hudlOption = null;
    @FindBy(css = "p.uni-text")
    private WebElement errorMsg = null;

    public void clickLogInButton() {
        ButtonControl.clickButton(buttonElement);

    }
    public LogInPage clickHudlOption() {
        ButtonControl.clickButton(hudlOption);
        return PageFactory.initElements(webDriver, LogInPage.class);
    }

    public String verifyErrorMessage() {
        WebWaits.waitForNoOfSeconds(5);
        WebWaits.waitForElement(errorMsg);
        return errorMsg.getText();
    }
}
