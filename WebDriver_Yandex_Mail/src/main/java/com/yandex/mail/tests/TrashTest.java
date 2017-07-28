package com.yandex.mail.tests;

import com.yandex.mail.bo.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.yandex.mail.steps.MailSteps;
import com.yandex.mail.steps.TrashSteps;
import com.yandex.mail.utils.Browser;

/**
 * Test-class of Trash folder of Yandex Mail service.
 *
 * @author Siarhei_Tuzhyk
 */
public class TrashTest {

    MailSteps mailSteps;
    TrashSteps trashSteps;
    User user;

    @BeforeClass(description = "Start browser")
    public void initSteps() {
        mailSteps = new MailSteps();
        trashSteps = new TrashSteps();
        user = new User();
    }

    @DataProvider(name = "options for Yandex mail trash folder test")
    public Object[][] mailTestDataProvider() {
        return new Object[][]{
            {"pavel.yachkurynski@yandex.by"}
        };
    }

    @Test(dataProvider = "options for Yandex mail trash folder test")
    public void trashMailTest(String author) {
        mailSteps.navigateToHomePage();
        mailSteps.logIn(user);
        Assert.assertTrue(mailSteps.isLogin());
        trashSteps.changeInboxMailsFilter();
        trashSteps.moveMailsByAuthorToTrash(author);
        Assert.assertTrue(trashSteps.verifyMailsByAuthorInTrash(author));
        mailSteps.logOut();
    }

    @AfterClass
    public void closeBrowser() {
        Browser.kill();
    }

}
