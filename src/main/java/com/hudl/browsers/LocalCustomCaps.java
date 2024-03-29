package com.hudl.browsers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;

public class LocalCustomCaps {

    private static String filePath = File.separator;

    public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setCapability("marionette", true);
        options.addArguments("--headless");
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return new FirefoxDriver(options);
    }

    public static WebDriver getIeDriver(){
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.introduceFlakinessByIgnoringSecurityDomains();
        options.destructivelyEnsureCleanSession();
        options.ignoreZoomSettings();
        options.takeFullPageScreenshot();
        return new InternetExplorerDriver(options);
    }

    public static WebDriver getChromeDriver()  {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--enable-javascript");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--fast-start");
        options.addArguments("--remote-allow-origins=*");

        final String headless = System.getProperty("headless");
        if (Boolean.TRUE.toString().equals(headless) ) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("window-size=1920,1080");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            System.setProperty("webdriver.chrome.whitelistedIps", "");
        }
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getHtmlChromeUnitDriver(String browserName){
        WebDriver driver = null;
        if(browserName.toLowerCase().contains("chrome")){
            driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        }else if(browserName.toLowerCase().contains("firefox")) {
            driver = new HtmlUnitDriver(BrowserVersion.FIREFOX);
        }else if(browserName.toLowerCase().contains("ie")) {
            driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
        }else if(browserName.toLowerCase().contains("edge")) {
            driver = new HtmlUnitDriver(BrowserVersion.EDGE);
        }
        ((HtmlUnitDriver)driver).setJavascriptEnabled(true);
        return driver;
    }

    public static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
