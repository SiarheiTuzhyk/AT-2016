package com.yandex.mail.bo;

/**
 * Objects of this class will be use in logic between test scenarios and web-pages.
 *
 * @author Siarhei_Tuzhyk
 */
public class Letter {

    private String addressee;
    private String subject;
    private String body;

    public Letter(String addressee, String subject, String body) {
        this.addressee = addressee;
        this.subject = subject;
        this.body = body;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
