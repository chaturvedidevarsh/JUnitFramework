package utility;

import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BaseUtils {

    WebDriver driver;

    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    public BaseUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static void elementVisibilityWait(WebDriver driver, WebElement element) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(15, TimeUnit.SECONDS);
        wait.pollingEvery(10, TimeUnit.SECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(TimeoutException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollToElement(WebDriver driver, WebElement el) {
        if (driver instanceof JavascriptExecutor) {
            elementVisibilityWait(driver, el);
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + (el.getLocation().getY() - 175) + ")");
        }
    }

    public static void waitForPageToLoad(WebDriver driver){
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }


}