package com.yandex.mail.steps;

import com.yandex.mail.pages.mailbox.InboxPage;
import com.yandex.mail.pages.mailbox.TrashPage;
/**
 * Steps for tests. It's a level between tests and pages.
 *
 * @author Siarhei_Tuzhyk
 */
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
