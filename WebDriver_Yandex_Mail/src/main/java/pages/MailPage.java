package pages;

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

    public void fillMail(String addressee, String subject, String body) {
        this.setAddresseeField(addressee);
        this.setSubjectField(subject);
        this.setBodyField(body);
    }

    public void sendMail() {
        browser.click(BUTTON_SEND_MAIL_LOCATOR);
        clickSaveToPopUp();
    }

    public void saveToDraft() {
        browser.click(BUTTON_DRAFT_FOLDER_LOCATOR);
        clickSaveToPopUp();
    }

    private void clickSaveToPopUp() {
        if (isElementPresent(BUTTON_SAVE_MAIL_LOCATOR)) {
            browser.click(BUTTON_SAVE_MAIL_LOCATOR);
        }
    }

    public boolean verifyLastMail(String addressee, String subject, String body) {
        String currentAddressee = browser.getElement(CHECK_ADDRESSEE_LOCATOR)
            .getAttribute("data-contact-email");
        String currentSubject = browser.getElement(CHECK_SUBJECT_LOCATOR)
            .getAttribute(VALUE_ATTRIBUTE);
        String currentBody = browser.getElement(CHECK_BODY_LOCATOR)
            .getText();

        return (addressee.equals(currentAddressee)
            && subject.equals(currentSubject)
            && body.equals(currentBody));
    }

    public void toSentFolder() {
        browser.click(BUTTON_SENT_FOLDER_LOCATOR);
    }
}
