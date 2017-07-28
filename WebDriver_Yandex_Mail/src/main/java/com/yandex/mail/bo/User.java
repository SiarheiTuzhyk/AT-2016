package com.yandex.mail.bo;

/**
 * User class. Consist attributes, which needed in test scenarios;
 *
 * @author Siarhei_Tuzhyk
 */
public class User {

    private final String userName = "ya.mail-testing@yandex.ru";
    private final String password = "qwerty12345";
    private Letter letter;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }
}
