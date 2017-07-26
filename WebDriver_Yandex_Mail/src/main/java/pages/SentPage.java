package pages;

import org.openqa.selenium.By;

public class SentPage extends MailBox {

    private static final By CHECK_ADDRESSEE_IN_MAIL_LOCATOR = By
        .xpath("//div[contains(@class,'js-messages-list')]/div[1]"
            + "//span[@class='mail-MessageSnippet-FromText']");
    private static final By CHECK_SUBJECT_IN_MAIL_LOCATOR = By
        .xpath("//div[contains(@class,'js-messages-list')]/div[1]"
            + "//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']/span");
    private static final String TITLE_ATTRIBUTE = "title";

    public boolean verifyMailInSent(String addressee, String subject) {
        browser.waitForElementVisible(CHECK_ADDRESSEE_IN_MAIL_LOCATOR);
        browser.waitForElementVisible(CHECK_SUBJECT_IN_MAIL_LOCATOR);

        String currentAddressee = browser
            .getElement(CHECK_ADDRESSEE_IN_MAIL_LOCATOR).getAttribute(TITLE_ATTRIBUTE);
        String currentSubject = browser
            .getElement(CHECK_SUBJECT_IN_MAIL_LOCATOR).getAttribute(TITLE_ATTRIBUTE);
        return addressee.equals(currentAddressee) && subject.equals(currentSubject);
    }
}
