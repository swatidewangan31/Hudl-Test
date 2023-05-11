package com.hudl.webControls;

import com.hudl.browsers.WebDriverFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptControl extends BaseControl {

    private static Logger logger = LogManager.getLogger("TestLogger");
    private static WebDriver driver = WebDriverFactory.getThreadedDriver();

    public static Object runJsScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script);
    }
}
