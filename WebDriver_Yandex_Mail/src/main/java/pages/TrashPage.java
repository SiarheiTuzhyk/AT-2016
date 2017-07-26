package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TrashPage extends MailBox {

    private static final By TRASH_MAILS_LOCATOR = By
        .xpath("//div[@class='mail-MessageSnippet-Content']");
    private static final By MAIL_AUTHOR_LOCATOR = By
        .xpath("//span[contains(@class,'mail-Message-Sender-Email')]");
    private static final By BUTTON_TO_FOLDER_LOCATOR = By
        .xpath("//span[contains(@class,'js-toolbar-item-title-folders-actions')]");
    private static final By BUTTON_TO_INBOX_FOLDER_LOCATOR = By
        .xpath("//a[@data-params='fid=1&toolbar=1']/span[@class='js-folder-name']");


    public boolean verifyMailsByAuthor(String author) {
        List<WebElement> elements = browser.getElements(TRASH_MAILS_LOCATOR);
        Actions actions = new Actions(browser.getWebDriver());
        for (int i = 0; i <= elements.size(); i++) {
            browser.waitForElementEnabled(TRASH_MAILS_LOCATOR);
            elements = browser.getElements(TRASH_MAILS_LOCATOR);
            actions.moveToElement(elements.get(0)).click().build().perform();
            String title = browser.getElement(MAIL_AUTHOR_LOCATOR)
                .getAttribute(TITLE_ATTRIBUTE);
            if (author.equals(title)) {
                browser.click(BUTTON_TO_FOLDER_LOCATOR);
                browser.click(BUTTON_TO_INBOX_FOLDER_LOCATOR);
                browser.click(BUTTON_TRASH_FOLDER_LOCATOR);
            }
            browser.click(BUTTON_TRASH_FOLDER_LOCATOR);
        }
        browser.refresh();
        return browser.getElements(MAIL_AUTHOR_LOCATOR).size() == 0;
    }
}














