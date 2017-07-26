package pages;

import org.openqa.selenium.By;

/**
 * Class be inheritance <>AbstractPage</>.
 * Classes, which have links to mail folders should extend this class.
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
}
