package com.yandex.mail.steps;

import com.yandex.mail.bo.Letter;
import com.yandex.mail.bo.User;
import com.yandex.mail.pages.mailbox.DraftPage;
import com.yandex.mail.pages.mainpages.HomePage;
import com.yandex.mail.pages.mailbox.InboxPage;
import com.yandex.mail.pages.mainpages.LoginPage;
import com.yandex.mail.pages.mailbox.MailPage;
import com.yandex.mail.pages.mailbox.SentPage;

public class MailSteps {

    LoginPage loginPage = new LoginPage();
    MailPage mailPage = new MailPage();
    InboxPage inboxPage = new InboxPage();
    HomePage homePage = new HomePage();
    DraftPage draftPage = new DraftPage();
    SentPage sentPage = new SentPage();

    public void navigateToHomePage() {
        homePage.navigateHere();
        homePage.switchToComDomain();
    }

    public void logIn(User user) {
        homePage.toLoginPage();
        loginPage.login(user);
    }

    public boolean isLogin() {
        return loginPage.isSuccessLogin();
    }

    public void createMail(Letter letter) {
        inboxPage.composeMail();
        mailPage.fillMail(letter);
    }

    public void saveToDraft() {
        mailPage.saveToDraft();
    }

    public boolean verifyMailPresentsInDraft() {
        return draftPage.verifyMailPresentedInDraft();
    }

    public boolean verifyLastMail(Letter letter) {
        draftPage.openLastMail();
        return mailPage.verifyLastMail(letter);
    }

    public void sendMail() {
        mailPage.sendMail();
    }

    public void toSentFolder() {
        mailPage.toSentFolder();
    }

    public void toInboxFolder(){
        mailPage.toInboxFolder();
    }

    public boolean verifyMailInSentFolder(Letter letter) {
        return sentPage.verifyMailInSent(letter);
    }

    public void logOut() {
        homePage.navigateHere();
        //homePage.switchToComDomain();
        homePage.logOut();
    }
}
