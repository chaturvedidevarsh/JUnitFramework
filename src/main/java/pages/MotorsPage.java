package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.fail;
import static utility.BaseUtils.*;

public class MotorsPage {

    WebDriver driver;

    public MotorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='attribute-search-motors']")
    private WebElement attributeMotorsSearch;

    @FindBy(xpath = "//input[@id='searchString']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='SiteHeader_SideBar_Quicklinks_PanelDefault']")
    private WebElement sideBarQuickLinks;

    @FindBy(xpath = "//h2/a[contains(text(),'Used cars')]")
    private WebElement usedCarsHeading;

    @FindBy(xpath = "//h2/a[contains(text(),'New cars')]")
    private WebElement newCarsHeading;

    @FindBy(xpath = "//a[contains(text(),'Cars for sale')]")
    private WebElement carsForSaleLink;

    @FindBy(xpath = "//a[contains(text(),'Parts for sale')]")
    private WebElement partsForSaleLink;

    @FindBy(xpath = "//a[contains(text(),'Car stereos')]")
    private WebElement carStereoLink;

    @FindBy(xpath = "//a[contains(text(),'Specialist cars')]")
    private WebElement specialistCarsLink;

    @FindBy(xpath = "//a[contains(text(),'Wrecked cars')]")
    private WebElement wreckedCarsLink;

    @FindBy(xpath = "//h2/a[contains(text(),'Motorbikes')]")
    private WebElement motorbikesHeading;

    @FindBy(xpath = "//h2[contains(text(),'Other vehicles')]")
    private WebElement otherVehiclesHeading;

    @FindBy(xpath = "//h2[contains(text(),'Related categories')]")
    private WebElement relatedCategoriesHeading;

    @FindBy(xpath = "//h2/a[contains(text(),'Boats & marine')]")
    private WebElement boatsAndMarinesHeading;

    @FindBy(xpath = "//li[@class='tmm-search-card-list-view']")
    private List<WebElement> availableListing;

    @FindBy(xpath = "//td")
    private WebElement noCarsAvailableLabel;

    public void validateMotorsPage() {
        waitForPageToLoad(driver);
        attributeMotorsSearch.isDisplayed();
        motorbikesHeading.isDisplayed();
        usedCarsHeading.isDisplayed();

        scrollToElement(driver, sideBarQuickLinks);
        sideBarQuickLinks.isDisplayed();
        newCarsHeading.isDisplayed();
        otherVehiclesHeading.isDisplayed();
    }

    public void clickUsedCars() {
        elementVisibilityWait(driver, usedCarsHeading);
        usedCarsHeading.click();
    }

    public Boolean checkAvailableCarsStatus() {
        waitForPageToLoad(driver);
        for (WebElement we : availableListing) {
            try {
                if (we.isDisplayed()) {
                    scrollToElement(driver, we);
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public void checkAvailableCars(){
        if(checkAvailableCarsStatus())
            System.out.println("Listings available in the selected category");
        else
            fail(" checkAvailableCars --- Listing is not available in the selected category");
    }

    public void checkNoAvailableCars(){
        if(!checkAvailableCarsStatus())
            System.out.println("No Listings available in the selected category");
        else
            fail(" checkNoAvailableCars --- Listing is available in the selected category");
    }

    public void assertCarsAvailable() {
        scrollToElement(driver, noCarsAvailableLabel);
        noCarsAvailableLabel.isDisplayed();
        System.out.println(noCarsAvailableLabel.getText());
    }

    public void selectCarOption(String motorsFilter) {
        switch (motorsFilter.toLowerCase()) {
            case "used cars":
                scrollToElement(driver, usedCarsHeading);
                usedCarsHeading.click();
                break;
            case "new cars":
                scrollToElement(driver, newCarsHeading);
                newCarsHeading.click();
                break;
            case "motorbikes":
                scrollToElement(driver, motorbikesHeading);
                motorbikesHeading.click();
                break;
            case "other vehicles":
                scrollToElement(driver, otherVehiclesHeading);
                otherVehiclesHeading.click();
                break;
            case "boats & marines":
                scrollToElement(driver, boatsAndMarinesHeading);
                boatsAndMarinesHeading.click();
                break;
            case "related categories":
                scrollToElement(driver, relatedCategoriesHeading);
                relatedCategoriesHeading.click();
                break;
            default:
                fail("selectCarOption -- Invalid category Selected");
        }
        waitForPageToLoad(driver);
    }

    public void selectAvailableCar() {
        waitForPageToLoad(driver);
        for (WebElement we : availableListing) {
            scrollToElement(driver, we);
            we.click();
            break;
        }
    }


    public void searchByCarName(String carName) {
        waitForPageToLoad(driver);
        scrollToElement(driver, searchField);
        searchField.sendKeys(carName);
        searchField.sendKeys(Keys.ENTER);
    }

}
