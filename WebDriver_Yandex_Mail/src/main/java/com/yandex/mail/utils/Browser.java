package com.yandex.mail.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Singleton Browser-class. Include many methods for implementation some actions (click, type,
 * refresh and more). Consist javascript executors methods.
 *
 * @author Siarhei_Tuzhyk
 */
public class Browser {

    private WebDriver driver;
    private static Browser instance;
    private static final int WAIT_ELEMENT_TIMEOUT = 10;
    private static final int PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS = 15;
    private static final int COMMAND_DEFAULT_TIMEOUT_SECONDS = 5;

    private Browser(WebDriver driver) {
        this.driver = driver;
    }

    public static Browser getBrowserInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = init();
    }

    private static Browser init() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        /*
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //For Selenium Grid
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),
                DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            System.err.println("Error with creating URL");
        }
        */
        driver.manage().timeouts()
            .pageLoadTimeout(PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts()
            .implicitlyWait(COMMAND_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        return new Browser(driver);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void waitForElementVisible(By locator) {
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementEnabled(By locator) {
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT)
            .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void highlightElement(By locator) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].style.border='5px solid green'", getElement(locator));
    }

    public void unHighlightElement(By locator) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].style.border='0px'", getElement(locator));
    }

    public void open(String url) {
        driver.get(url);
    }

    public void clickElementByJsScript(By locator) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click()", getElement(locator));
    }

    public void click(final By locator) {
        waitForElementEnabled(locator);
        highlightElement(locator);
        Screenshoter.takeScreenshot();
        unHighlightElement(locator);
        getElement(locator).click();
    }

    public void type(final By locator, String text) {
        waitForElementEnabled(locator);
        highlightElement(locator);
        getElement(locator).sendKeys(text);
        Screenshoter.takeScreenshot();
        unHighlightElement(locator);
    }

    public boolean isDisplayed(By locator) {
        return !getElements(locator).isEmpty();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public static void kill() {
        if (instance != null) {
            try {
                instance.driver.quit();
            } catch (Exception e) {
                System.err.println("Can not kill browser");
            } finally {
                instance = null;
            }
        }
    }
}