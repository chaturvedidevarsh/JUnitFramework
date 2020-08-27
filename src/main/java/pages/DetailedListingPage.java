package pages;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.fail;
import static utility.BaseUtils.scrollToElement;

public class DetailedListingPage {

    WebDriver driver;

    public DetailedListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Key details')]")
    private WebElement keyDetailsLabel;

    @FindBy(xpath = "//div[@class='key-details-attribute-label']")
    private List<WebElement> carSpecsLabel;

    @FindBy(xpath = "//label[contains(text(),'Number plate')]")
    private WebElement numberPlateLabel;

    @FindBy(xpath = "//label[contains(text(),'Kilometres')]")
    private WebElement kilometresLabel;

    @FindBy(xpath = "//label[contains(text(),'Body')]")
    private WebElement bodyLabel;

    @FindBy(xpath = "//label[contains(text(),'Fuel type')]")
    private WebElement fuelTypeLabel;

    @FindBy(xpath = "//label[contains(text(),'Engine size')]")
    private WebElement engineSizeLabel;

    @FindBy(xpath = "//label[contains(text(),'Transmission')]")
    private WebElement transmissionLabel;

    @FindBy(xpath = "//label[contains(text(),'History')]")
    private WebElement historyLabel;

    @FindBy(xpath = "//label[contains(text(),'Registration expires')]")
    private WebElement registrationExpiresLabel;

    @FindBy(xpath = "//label[contains(text(),'WoF expires')]")
    private WebElement woFExpiresLabel;

    @FindBy(xpath = "//label[contains(text(),'Stereo description')]")
    private WebElement stereoDescriptionLabel;

    @FindBy(xpath = "//span[@class='motors-attribute-value']")
    private List<WebElement> carDetails;

    @FindBy(xpath = "//div[@id='description-tabs']")
    private WebElement descriptionTabs;

    public void checkValueOfRequiredField() {
        scrollToElement(driver, stereoDescriptionLabel);
        for (WebElement we : carDetails) {
            System.out.println(we.getText());
        }
    }


    public void validateDetailsDisplayed(DataTable carDetails) {
        Collection<String> carSpecs = new ArrayList<>(carDetails.asList(String.class));
        Collection<String> displayedOptions = checkCarSpecsAvailable();

        System.out.println(carSpecs);
        carSpecs.removeAll(displayedOptions);

        if(!carSpecs.isEmpty()){
            fail(carSpecs + " : not displayed \n validateDetailsDisplayed --- All required specs are not displayed");
        }
    }

    public List checkCarSpecsAvailable() {
        List<String> displayedSpecs = new ArrayList<>();
        for (WebElement we : carSpecsLabel) {
            displayedSpecs.add(we.getText());
        }
        System.out.println(displayedSpecs);
        return displayedSpecs;
    }

}
