package com.yandex.mail.pages.mainpages;

import com.yandex.mail.utils.Browser;
import org.openqa.selenium.By;

/**
 * All page-classes should inheritance this class.
 */
public class AbstractPage {

    protected Browser browser;

    public AbstractPage() {
        this.browser = Browser.getBrowserInstance();
    }

    public boolean isElementPresent(By locator) {
        return browser.isDisplayed(locator);
    }
}
