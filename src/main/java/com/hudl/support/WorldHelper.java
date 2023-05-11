package com.hudl.support;

import com.hudl.browsers.WebDriverFactory;
import com.hudl.pages.BasePage;
import com.hudl.pages.LogInPage;
import com.hudl.pages.NeedHelpPage;
import com.hudl.pages.RememberMePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WorldHelper {

    private WebDriver driver = WebDriverFactory.getThreadedDriver();
    private static BasePage basePage = null;
    private static LogInPage getLogInPage = null;
    private static NeedHelpPage getNeedHelpPage = null;
    private static RememberMePage getRememberMePage = null;

    public BasePage getBasePage(){
        if(basePage != null) return basePage;
        return PageFactory.initElements(driver, BasePage.class);
    }

    public LogInPage getLogInPage(){
        if(getLogInPage != null) return getLogInPage;
        return PageFactory.initElements(driver, LogInPage.class);
    }

    public NeedHelpPage getNeedHelpPage(){
        if(getNeedHelpPage != null) return getNeedHelpPage;
        return PageFactory.initElements(driver, NeedHelpPage.class);
    }

    public RememberMePage getRememberMePage(){
        if(getRememberMePage != null) return getRememberMePage;
        return PageFactory.initElements(driver, RememberMePage.class);
    }
}
