package com.demoqa.factory;

import com.demoqa.config.ConfigManager;
import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page initBrowser() {
        playwright.set(Playwright.create());
        String browserName = ConfigManager.getBrowser();
        boolean headless = ConfigManager.isHeadless();

        switch (browserName.toLowerCase()) {
            case "firefox":
                browser.set(playwright.get().firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
                break;
            case "webkit":
                browser.set(playwright.get().webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
                break;
            case "chrome":
            default:
                browser.set(playwright.get().chromium()
                        .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless)));
                break;
        }

        browserContext.set(browser.get().newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080))); // Set default viewport

        page.set(browserContext.get().newPage());
        page.get().navigate(ConfigManager.getUrl());
        return page.get();
    }

    public static Page getPage() {
        return page.get();
    }

    public static void closeBrowser() {
        if (page.get() != null) {
            page.get().close();
            page.remove();
        }
        if (browserContext.get() != null) {
            browserContext.get().close();
            browserContext.remove();
        }
        if (browser.get() != null) {
            browser.get().close();
            browser.remove();
        }
        if (playwright.get() != null) {
            playwright.get().close();
            playwright.remove();
        }
    }
}
