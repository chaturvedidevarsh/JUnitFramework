package managers;



import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {
    private WebDriver driver;

    private HomePage homePage;
    private MotorsPage motorsPage;
    private DetailedListingPage detailedListingPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
        //This method has two responsibilities:
        //
        //To create an Object of Page Class only if the object is null.
        //To supply the already created object if it is not null
    }


    public MotorsPage getMotorsPage() {
        return (motorsPage == null) ? motorsPage = new MotorsPage(driver) : motorsPage;
    }

    public DetailedListingPage getDetailedListingPage() {
        return (detailedListingPage == null) ? new DetailedListingPage(driver) : detailedListingPage;
    }
}