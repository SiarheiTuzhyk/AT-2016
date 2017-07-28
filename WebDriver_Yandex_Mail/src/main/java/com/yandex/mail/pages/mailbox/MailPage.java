package com.yandex.mail.pages.mailbox;

import com.yandex.mail.bo.Letter;
import org.openqa.selenium.By;

public class MailPage extends MailBox {

    private static final By ADDRESSEE_FIELD_LOCATOR = By
        .xpath("//label[contains(@class,'mail-Compose-Field_to')]");
    private static final By SUBJECT_FIELD_LOCATOR = By
        .xpath("//label[contains(@class,'mail-Compose-Field_subject')]");
    private static final By BODY_FIELD_LOCATOR = By
        .xpath("//div[@role='textbox']");
    private static final By CHECK_ADDRESSEE_LOCATOR = By
        .xpath("//span[@class='js-bubble mail-Bubble']");
    private static final By CHECK_SUBJECT_LOCATOR = By
        .xpath("//label[contains(@class,'mail-Compose-Field_subject')]//input");
    private static final By CHECK_BODY_LOCATOR = By
        .xpath("//div[@role='textbox']/div");
    private static final By BUTTON_SAVE_MAIL_LOCATOR = By
        .xpath("//button[@data-action='save']");
    private static final By BUTTON_SEND_MAIL_LOCATOR = By
        .xpath("//button[contains(@class,'js-send-button')]");


    private void setAddresseeField(String addressee) {
        browser.type(ADDRESSEE_FIELD_LOCATOR, addressee);
    }

    private void setSubjectField(String subject) {
        browser.type(SUBJECT_FIELD_LOCATOR, subject);
    }

    private void setBodyField(String body) {
        browser.type(BODY_FIELD_LOCATOR, body);
    }

    public void fillMail(Letter letter) {
        this.setAddresseeField(letter.getAddressee());
        this.setSubjectField(letter.getSubject());
        this.setBodyField(letter.getBody());
    }

    public void sendMail() {
        browser.click(BUTTON_SEND_MAIL_LOCATOR);
        clickSaveToPopUp();
    }

    public void saveToDraft() {
        toDraftFolder();
        clickSaveToPopUp();
    }

    private void clickSaveToPopUp() {
        if (isElementPresent(BUTTON_SAVE_MAIL_LOCATOR)) {
            browser.click(BUTTON_SAVE_MAIL_LOCATOR);
        }
    }

    public boolean verifyLastMail(Letter letter) {
        String currentAddressee = browser.getElement(CHECK_ADDRESSEE_LOCATOR)
            .getAttribute(ADDRESSEE_EMAIL_ATTRIBUTE);
        String currentSubject = browser.getElement(CHECK_SUBJECT_LOCATOR)
            .getAttribute(VALUE_ATTRIBUTE);
        String currentBody = browser.getElement(CHECK_BODY_LOCATOR)
            .getText();

        return (letter.getAddressee().equals(currentAddressee)
            && letter.getSubject().equals(currentSubject)
            && letter.getBody().equals(currentBody));
    }
}
