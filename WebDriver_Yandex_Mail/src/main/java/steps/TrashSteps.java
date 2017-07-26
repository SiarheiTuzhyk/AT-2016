package steps;

import pages.*;

public class TrashSteps {

    InboxPage inboxPage = new InboxPage();
    TrashPage trashPage = new TrashPage();

    public void changeInboxMailsFilter() {
        inboxPage.changeFilterMessages();
    }

    public void moveMailsByAuthorToTrash(String author) {
        inboxPage.moveMailsByAuthorToTrash(author);
    }

    public boolean verifyMailsByAuthorInTrash(String author) {
        inboxPage.toTrashFolder();
        return trashPage.verifyMailsByAuthor(author);
    }

}
