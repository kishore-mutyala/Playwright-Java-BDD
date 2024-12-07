package com.qa.orangehrm.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName){
        System.out.println("browser name = " + browserName);
        playwright = Playwright.create();

        switch (browserName){
            case "chromium" :
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome" :
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "safari" :
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox" :
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "edge" :
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
                break;
            default:
                System.out.println("Please pass the right browser name........");
                break;
        }
            browserContext = browser.newContext();
            page = browserContext.newPage();
            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

            return page;

    }
}
