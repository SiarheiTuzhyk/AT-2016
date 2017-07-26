package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.MailSteps;
import steps.TrashSteps;
import utils.Browser;

public class TrashTest {

    MailSteps mailSteps;
    TrashSteps trashSteps;

    @BeforeClass(description = "Start browser")
    public void initSteps() {
        mailSteps = new MailSteps();
        trashSteps = new TrashSteps();
    }

    @DataProvider(name = "options for Yandex mail trash folder test")
    public Object[][] mailTestDataProvider() {
        return new Object[][]{
            {"ya.mail-testing@yandex.ru", "qwerty12345", "pavel.yachkurynski@yandex.by"}
        };
    }

    @Test(dataProvider = "options for Yandex mail trash folder test")
    public void trashMailTest(String userName, String password, String author) {
        mailSteps.navigateToHomePage();
        mailSteps.logIn(userName, password);
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
