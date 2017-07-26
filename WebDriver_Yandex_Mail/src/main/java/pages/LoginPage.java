package pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {

    private static final By LOGIN_FIELD_LOCATOR = By
        .cssSelector("._nb-input-controller[name='login']");
    private static final By PASSWORD_FIELD_LOCATOR = By
        .cssSelector("._nb-input-controller[name='passwd']");
    private static final By BUTTON_LOGIN_LOCATOR = By
        .cssSelector(".nb-group-start[type='submit']");
    private static final By ERROR_LOGIN_LOCATOR = By
        .xpath("//div[@class='passport-Domik-Form-Error passport-Domik-Form-Error_active']");

    private void setUserName(String userName) {
        browser.type(LOGIN_FIELD_LOCATOR, userName);
    }

    private void setPassword(String password) {
        browser.type(PASSWORD_FIELD_LOCATOR, password);
    }

    private void clickLogin() {
        browser.click(BUTTON_LOGIN_LOCATOR);
    }

    public void login(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
        this.clickLogin();
    }

    public boolean isSuccessLogin() {
        return !browser.isDisplayed(ERROR_LOGIN_LOCATOR);
    }
}
