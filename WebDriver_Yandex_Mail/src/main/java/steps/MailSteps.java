package steps;

import pages.DraftPage;
import pages.HomePage;
import pages.InboxPage;
import pages.LoginPage;
import pages.MailPage;
import pages.SentPage;

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

    public void logIn(String userName, String password) {
        homePage.toLoginPage();
        loginPage.login(userName, password);
    }

    public boolean isLogin() {
        return loginPage.isSuccessLogin();
    }

    public void createMail(String addressee, String subject, String body) {
        inboxPage.clickCompose();
        mailPage.fillMail(addressee, subject, body);
    }

    public void saveToDraft() {
        mailPage.saveToDraft();
    }

    public boolean verifyMailPresentsInDraft() {
        return draftPage.verifyMailPresentedInDraft();
    }

    public boolean verifyLastMail(String addressee, String subject, String body) {
        draftPage.openLastMail();
        return mailPage.verifyLastMail(addressee, subject, body);
    }

    public void sendMail() {
        mailPage.sendMail();
    }

    public void toSentFolder() {
        mailPage.toSentFolder();
    }


    public boolean verifyMailInSentFolder(String addressee, String subject) {
        return sentPage.verifyMailInSent(addressee, subject);
    }

    public void logOut() {
        homePage.navigateHere();
        //homePage.switchToComDomain();
        homePage.logOut();
    }
}
