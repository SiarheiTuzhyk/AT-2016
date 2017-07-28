package com.yandex.mail.pages.mailbox;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Page-class of "Inbox" folder in MailBox.
 *
 * @author Siarhei_Tuzhyk
 */
public class InboxPage extends MailBox {

    private static final By INBOX_MAILS_LOCATOR = By
        .xpath("//div[@class='mail-MessageSnippet-Content']");
    private static final By MAIL_AUTHOR_LOCATOR = By
        .xpath("//span[contains(@class,'mail-Message-Sender-Email')]");
    private static final By BUTTON_RETURN_TO_SEARCH = By
        .xpath("//a[@class='b-message-headline__action']");
    private static final By BUTTON_CHANGE_FILTER_LOCATOR = By
        .xpath("//*[@id='nb-7']/div/span");
    private static final By FILTER_BY_PEOPLE_LOCATOR = By
        .xpath("//*[@id='ui-id-4']");
    private static final By BUTTON_DELETE_MAIL_LOCATOR = By
        .xpath("//span[contains(@class,'js-toolbar-item-title-delete')]");

    public void moveMailsByAuthorToTrash(String author) {
        List<WebElement> elements = browser.getElements(INBOX_MAILS_LOCATOR);
        Actions actions = new Actions(browser.getWebDriver());
        for (int i = 0; i < elements.size(); i++) {
            browser.isDisplayed(INBOX_MAILS_LOCATOR);
            elements = browser.getElements(INBOX_MAILS_LOCATOR);
            actions.moveToElement(elements.get(i)).click().build().perform();
            String title = browser.getElement(MAIL_AUTHOR_LOCATOR).getAttribute(TITLE_ATTRIBUTE);
            if (author.equals(title)) {
                browser.click(BUTTON_DELETE_MAIL_LOCATOR);
            } else {
                browser.click(BUTTON_RETURN_TO_SEARCH);
            }
        }
    }

    public void changeFilterMessages() {
        browser.click(BUTTON_CHANGE_FILTER_LOCATOR);
        browser.click(FILTER_BY_PEOPLE_LOCATOR);
        browser.refresh();
    }
}
