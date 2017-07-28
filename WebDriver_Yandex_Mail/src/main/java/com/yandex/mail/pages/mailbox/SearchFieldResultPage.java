package com.yandex.mail.pages.mailbox;

import com.yandex.mail.bo.Letter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchFieldResultPage extends MailBox {

    private static final By RESULT_MAILS_LOCATOR = By
        .xpath("//div[@class='mail-MessageSnippet-Content']");
    private static final By MAIL_SUBJECT_LOCATOR = By
        .xpath("//div[contains(@class,'mail-Message-Toolbar-Subject')]");
    private static final By BUTTON_BACK_TO_SEARCH_LOCATOR = By
        .xpath("//a[@class='b-message-headline__action']");
    private static final By SEARCH_FILED_LOCATOR = By
        .xpath("//input[contains(@class,'js-search-input')]");
    private static final By BUTTON_SEARCH_LOCATOR = By.xpath(".//*[@id='nb-4']");
    private Actions actions;

    public void fillSearchField(String subject) {
        browser.waitForElementEnabled(SEARCH_FILED_LOCATOR);
        browser.type(SEARCH_FILED_LOCATOR,subject);
    }

    public void search() {
        actions = new Actions(browser.getWebDriver());
        browser.waitForElementEnabled(BUTTON_SEARCH_LOCATOR);
        actions.moveToElement(browser.getElement(BUTTON_SEARCH_LOCATOR)).click().build().perform();
    }

    public boolean checkSearchResult(Letter letter) {
        boolean result = false;
        browser.waitForElementEnabled(RESULT_MAILS_LOCATOR);
        List<WebElement> elements = browser.getElements(RESULT_MAILS_LOCATOR);
        actions = new Actions(browser.getWebDriver());
        for (int i = 0; i <= elements.size(); i++) {
            browser.waitForElementEnabled(RESULT_MAILS_LOCATOR);
            elements = browser.getElements(RESULT_MAILS_LOCATOR);
            actions.moveToElement(elements.get(i)).click().build().perform();
            String title = browser.getElement(MAIL_SUBJECT_LOCATOR).getText();
            if (letter.getSubject().equals(title)) {
                result = true;
                break;
            } else {
                browser.click(BUTTON_BACK_TO_SEARCH_LOCATOR);
            }
        }
        return result;
    }
}
