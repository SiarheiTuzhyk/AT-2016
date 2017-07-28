package com.yandex.mail.pages.mainpages;

import org.openqa.selenium.By;

public class HomePage extends AbstractPage {

    private static final By BUTTON_LOGIN_PAGE_LOCATOR = By.
        xpath("//a[contains(@class,'user__login-link')]/div");
    private static final By BUTTON_LOG_OUT__LINK_LOCATOR = By
        .xpath("//a[contains(@class,' link user__exit')]");
    private static final By BUTTON_SWITCH_TO_ENGLISH_LOCATOR = By
        .xpath("//a[@class='link redir-link link_black_yes']");

    private static final String URL = "https://yandex.com/";

    public void navigateHere() {
        browser.open(URL);
    }

    public void toLoginPage() {
        browser.clickElementByJsScript(BUTTON_LOGIN_PAGE_LOCATOR);
    }

    public void logOut() {
        browser.click(BUTTON_LOG_OUT__LINK_LOCATOR);
    }

    public void switchToComDomain() {
        browser.click(BUTTON_SWITCH_TO_ENGLISH_LOCATOR);
    }
}
