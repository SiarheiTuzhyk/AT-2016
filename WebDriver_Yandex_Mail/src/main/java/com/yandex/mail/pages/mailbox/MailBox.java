package com.yandex.mail.pages.mailbox;

import org.openqa.selenium.By;
import com.yandex.mail.pages.mainpages.AbstractPage;

/**
 * Class be inheritance <>AbstractPage</>. Classes, which have links to mail folders should extend
 * this class.
 */
public class MailBox extends AbstractPage {

    protected static final By BUTTON_SENT_FOLDER_LOCATOR = By
        .xpath("//a[contains(@title,'Sent')]");
    protected static final By BUTTON_INBOX_FOLDER_LOCATOR = By
        .xpath("//a[contains(@title,'Inbox')]");
    protected static final By BUTTON_TRASH_FOLDER_LOCATOR = By
        .xpath("//a[contains(@title,'Trash')]");
    protected static final By BUTTON_DRAFT_FOLDER_LOCATOR = By
        .xpath("//a[contains(@title,'Drafts')]");
    protected static final By COMPOSE_MAIL_LOCATOR = By
        .xpath("//div[@class='mail-ComposeButton-Wrap']/a");
    protected static final String TITLE_ATTRIBUTE = "title";
    protected static final String VALUE_ATTRIBUTE = "value";
    protected static final String ADDRESSEE_EMAIL_ATTRIBUTE = "data-contact-email";


    public void toSentFolder() {
        browser.click(BUTTON_SENT_FOLDER_LOCATOR);
    }

    public void toInboxFolder() {
        browser.click(BUTTON_INBOX_FOLDER_LOCATOR);
    }

    public void toTrashFolder() {
        browser.click(BUTTON_TRASH_FOLDER_LOCATOR);
    }

    public void toDraftFolder() {
        browser.click(BUTTON_DRAFT_FOLDER_LOCATOR);
    }

    public void composeMail() {
        browser.click(COMPOSE_MAIL_LOCATOR);
    }
}
