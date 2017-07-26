package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.MailSteps;
import steps.SearchBoxSteps;
import steps.TrashSteps;
import utils.Browser;

public class MailTest {

    MailSteps mailSteps;
    TrashSteps trashSteps;
    SearchBoxSteps searchBoxSteps;

    @BeforeClass(description = "Start browser")
    public void initSteps() {
        mailSteps = new MailSteps();
        trashSteps = new TrashSteps();
        searchBoxSteps = new SearchBoxSteps();
    }

    @DataProvider(name = "options for Yandex mail test")
    public Object[][] mailTestDataProvider() {
        return new Object[][]{
            {"ya.mail-testing@yandex.ru", "qwerty12345",
                "pavel.yachkurynski@yandex.by", "test", "test body"}
        };
    }

    @Test(dataProvider = "options for Yandex mail test")
    public void mailTest(String userName, String password, String addressee,
        String subject, String body) {

        mailSteps.navigateToHomePage();
        mailSteps.logIn(userName, password);
        Assert.assertTrue(mailSteps.isLogin());
        mailSteps.createMail(addressee, subject, body);
        mailSteps.saveToDraft();
        Assert.assertTrue(mailSteps.verifyMailPresentsInDraft());
        Assert.assertTrue(mailSteps.verifyLastMail(addressee, subject, body));
        mailSteps.sendMail();
        mailSteps.toSentFolder();
        Assert.assertTrue(mailSteps.verifyMailInSentFolder(addressee, subject));
        Assert.assertFalse(mailSteps.verifyMailPresentsInDraft());
        mailSteps.logOut();
    }

    @AfterClass
    public void closeBrowser() {
        Browser.kill();
    }
}
