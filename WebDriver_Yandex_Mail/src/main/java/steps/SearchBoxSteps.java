package steps;

import pages.SearchFieldResultPage;

public class SearchBoxSteps {

    SearchFieldResultPage searchFieldResultPage = new SearchFieldResultPage();

    public void findSubjectBySearch(String subject) {
        searchFieldResultPage.fillSearchField(subject);
        searchFieldResultPage.search();
    }

    public boolean checkSearchResult(String subject) {
        return searchFieldResultPage.checkSearchResult(subject);
    }
}
