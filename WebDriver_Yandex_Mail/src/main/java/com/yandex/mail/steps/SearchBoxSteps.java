package com.yandex.mail.steps;

import com.yandex.mail.bo.Letter;
import com.yandex.mail.pages.mailbox.SearchFieldResultPage;
/**
 * Steps for tests. It's a level between tests and pages.
 *
 * @author Siarhei_Tuzhyk
 */
public class SearchBoxSteps {

    SearchFieldResultPage searchFieldResultPage = new SearchFieldResultPage();

    public void findSubjectBySearch(Letter letter) {
        searchFieldResultPage.fillSearchField(letter.getSubject());
        searchFieldResultPage.search();
    }

    public boolean checkSearchResult(Letter letter) {
        return searchFieldResultPage.checkSearchResult(letter);
    }
}
