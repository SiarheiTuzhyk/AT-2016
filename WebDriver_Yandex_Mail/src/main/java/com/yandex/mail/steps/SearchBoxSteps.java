package com.yandex.mail.steps;

import com.yandex.mail.bo.Letter;
import com.yandex.mail.pages.mailbox.SearchFieldResultPage;

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
