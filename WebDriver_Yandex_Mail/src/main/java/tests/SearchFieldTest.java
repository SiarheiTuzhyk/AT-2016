package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.MailSteps;
import steps.SearchBoxSteps;
import utils.Browser;

public class SearchFieldTest {

    MailSteps mailSteps;
    SearchBoxSteps searchBoxSteps;

    @BeforeClass(description = "Start browser")
    public void initSteps() {
        mailSteps = new MailSteps();
        searchBoxSteps = new SearchBoxSteps();
    }

    @DataProvider(name = "options for Yandex mail search field test")
    public Object[][] mailTestDataProvider() {
        return new Object[][]{
            {"ya.mail-testing@yandex.ru", "qwerty12345",
                "pavel.yachkurynski@yandex.by", "searchField", "test body"}
        };
    }

    @Test(dataProvider = "options for Yandex mail search field test")
    public void searchFieldTest(String userName, String password, String addressee,
        String subject, String body) {

        mailSteps.navigateToHomePage();
        mailSteps.logIn(userName, password);
        Assert.assertTrue(mailSteps.isLogin());
        mailSteps.createMail(addressee, subject, body);
        mailSteps.sendMail();
        mailSteps.toSentFolder();
        searchBoxSteps.findSubjectBySearch(subject);
        Assert.assertTrue(searchBoxSteps.checkSearchResult(subject));
        mailSteps.logOut();
    }

    @AfterClass
    public void closeBrowser() {
        Browser.kill();
    }
}
