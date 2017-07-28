package com.yandex.mail.tests;

import com.yandex.mail.bo.Letter;
import com.yandex.mail.bo.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.yandex.mail.steps.MailSteps;
import com.yandex.mail.utils.Browser;

/**
 * Class test Yandex Mail service with elementary steps.
 *
 * @author Siarhei_Tuzhyk
 */
public class MailTest {

    MailSteps mailSteps;
    User user;

    @BeforeClass(description = "Start browser")
    public void initSteps() {
        mailSteps = new MailSteps();
        user = new User();
    }

    @DataProvider(name = "options for Yandex mail test")
    public Object[][] mailTestDataProvider() {
        return new Object[][]{
            {"pavel.yachkurynski@yandex.by", "test", "test body"}
        };
    }

    @Test(dataProvider = "options for Yandex mail test")
    public void mailTest(String addressee, String subject, String body) {
        user.setLetter(new Letter(addressee, subject, body));
        mailSteps.navigateToHomePage();
        mailSteps.logIn(user);
        Assert.assertTrue(mailSteps.isLogin());
        mailSteps.createMail(user.getLetter());
        mailSteps.saveToDraft();
        Assert.assertTrue(mailSteps.verifyMailPresentsInDraft());
        Assert.assertTrue(mailSteps.verifyLastMail(user.getLetter()));
        mailSteps.sendMail();
        mailSteps.toSentFolder();
        Assert.assertTrue(mailSteps.verifyMailInSentFolder(user.getLetter()));
        Assert.assertFalse(mailSteps.verifyMailPresentsInDraft());
        mailSteps.logOut();
    }

    @AfterClass
    public void closeBrowser() {
        Browser.kill();
    }
}
