package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utility.BaseUtils;

import static org.junit.Assert.fail;
import static utility.BaseUtils.*;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='SiteHeader_SiteTabs_homeLink']")
    private WebElement tradeMeSymbol;

    @FindBy(xpath = "//input[@id='searchString']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='icon-search-large']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='SearchTabs1_JobsLink']")
    private WebElement jobsLink;

    @FindBy(xpath = "//a[@id='SearchTabs1_MarketplaceLink']")
    private WebElement marketPlaceLink;

    @FindBy(xpath = "//a[@id='SearchTabs1_MotorsLink']")
    private WebElement motorsLink;

    @FindBy(xpath = "//a[@id='SearchTabs1_PropertyLink']")
    private WebElement propertyLink;

    public void perform_Search(String search) {
//        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + "/?s=" + search + "&post_type=product");
    }

    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void selectCategory(String availableCategory) {
        waitForPageToLoad(driver);
        switch (availableCategory.toLowerCase()) {
            case "motors":
                elementVisibilityWait(driver, motorsLink);
                motorsLink.click();
                break;
            case "marketplace":
                elementVisibilityWait(driver, marketPlaceLink);
                marketPlaceLink.click();
                break;
            case "mobs":
                elementVisibilityWait(driver, jobsLink);
                jobsLink.click();
                break;
            case "property":
                elementVisibilityWait(driver, propertyLink);
                propertyLink.click();
                break;
            default:
                fail("Invalid category selected");
        }
    }

    public void searchByCarName(String carName) {
        waitForPageToLoad(driver);
        scrollToElement(driver, searchField);
        searchField.sendKeys(carName);
        searchField.sendKeys(Keys.ENTER);
    }
}