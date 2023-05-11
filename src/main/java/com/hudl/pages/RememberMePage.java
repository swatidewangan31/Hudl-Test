package com.hudl.pages;

import com.hudl.webControls.CheckBoxControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RememberMePage extends BasePage{

    public RememberMePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "rect.uni-form__check-indicator__background")
    private WebElement rememberMe = null;

    public RememberMePage clickRememberMeBox() {
        CheckBoxControl.tickCheckBox(rememberMe);
        return PageFactory.initElements(webDriver, RememberMePage.class);
    }

}
