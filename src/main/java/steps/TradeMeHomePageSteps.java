package steps;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DetailedListingPage;
import pages.HomePage;
import pages.MotorsPage;

public class TradeMeHomePageSteps {

    TestContext testContext;
    HomePage homePage;
    MotorsPage motorsPage;
    DetailedListingPage detailedListingPage;

    public TradeMeHomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        motorsPage = testContext.getPageObjectManager().getMotorsPage();
        detailedListingPage = testContext.getPageObjectManager().getDetailedListingPage();
    }

    @Given("^I am on the TradeMe SandBox WebPage$")
    public void i_am_on_the_TradeMe_SandBox_WebPage() {
        homePage.navigateTo_HomePage();
    }


    @When("^I navigate to \"([^\"]*)\" category$")
    public void i_navigate_to_category(String available) {
        homePage.selectCategory(available);
    }

    @When("^I select \"([^\"]*)\" from the options$")
    public void i_select_from_the_options(String carStatus) {
        motorsPage.validateMotorsPage();
        motorsPage.selectCarOption(carStatus);
    }

    @Then("^I should be able to see atleast one listing in that category$")
    public void i_should_be_able_to_see_atleast_one_listing_in_that_category() {
        motorsPage.checkAvailableCars();
    }

    @Given("^I search for \"([^\"]*)\" cars$")
    public void i_search_for_cars(String carName) {
        homePage.searchByCarName(carName);
    }

    @Then("^I should only see cars related to my search option$")
    public void i_should_only_see_cars_related_to_my_search_option() {
        motorsPage.checkNoAvailableCars();
        //if listing is available then the function will return true
    }

    @When("^I search for \"([^\"]*)\" car on Motors page$")
    public void i_search_for_car_on_Motors_page(String carName) {
        motorsPage.searchByCarName(carName);
    }

    @When("^I select the available car$")
    public void i_select_the_available_car() {
        motorsPage.selectAvailableCar();
    }

    @Then("^I should be able to see the following details$")
    public void i_should_be_able_to_see_the_following_details(DataTable dataTable) {
        detailedListingPage.validateDetailsDisplayed(dataTable);
    }

}
