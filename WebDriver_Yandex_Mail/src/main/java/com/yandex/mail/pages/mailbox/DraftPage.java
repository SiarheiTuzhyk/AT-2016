package com.yandex.mail.pages.mailbox;

import org.openqa.selenium.By;

public class DraftPage extends MailBox {

    private static final By MESSAGES_IN_DRAFT_LOCATOR = By
        .xpath("//div[contains(@class,'ns-view-messages-item-wrap')]");
    private static final By LAST_DRAFT_MESSAGE_LOCATOR = By
        .xpath("//div[contains(@class,'mail-MessagesList')]/div[1]"
            + "//span[contains(@class,'js-message-snippet-body')]");

    public boolean verifyMailPresentedInDraft() {
        toDraftFolder();
        browser.refresh();
        return browser.isDisplayed(MESSAGES_IN_DRAFT_LOCATOR);
    }

    public void openLastMail() {
        browser.click(LAST_DRAFT_MESSAGE_LOCATOR);
    }
}
