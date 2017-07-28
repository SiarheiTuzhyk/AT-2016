package com.yandex.mail.tests;

import com.yandex.mail.bo.Letter;
import com.yandex.mail.bo.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.yandex.mail.steps.MailSteps;
import com.yandex.mail.steps.SearchBoxSteps;
import com.yandex.mail.utils.Browser;

/**
 * Test-class of Search field of Yandex Mail service.
 *
 * @author Siarhei_Tuzhyk
 */
public class SearchFieldTest {

    MailSteps mailSteps;
    SearchBoxSteps searchBoxSteps;
    User user;

    @BeforeClass(description = "Start browser")
    public void initSteps() {
        mailSteps = new MailSteps();
        searchBoxSteps = new SearchBoxSteps();
        user = new User();
    }

    @DataProvider(name = "options for Yandex mail search field test")
    public Object[][] mailTestDataProvider() {
        return new Object[][]{
            {"pavel.yachkurynski@yandex.by", "searchField", "test body", "simple_subject"}
        };
    }

    @Test(dataProvider = "options for Yandex mail search field test")
    public void searchFieldTest(String addressee, String checkSubject, String body,
        String simpleSubject) {

        user.setLetter(new Letter(addressee, checkSubject, body));
        mailSteps.navigateToHomePage();
        mailSteps.logIn(user);
        Assert.assertTrue(mailSteps.isLogin());
        mailSteps.createMail(user.getLetter());
        mailSteps.sendMail();
        mailSteps.toInboxFolder();
        //body of this letter consist subject of previous letter
        mailSteps.createMail(new Letter(addressee, simpleSubject, checkSubject));
        mailSteps.sendMail();
        mailSteps.toSentFolder();
        searchBoxSteps.findSubjectBySearch(user.getLetter());
        Assert.assertTrue(searchBoxSteps.checkSearchResult(user.getLetter()));
        mailSteps.logOut();
    }

    @AfterClass
    public void closeBrowser() {
        Browser.kill();
    }
}
