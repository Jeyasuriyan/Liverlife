package vishnu;

import baseUtils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Loginpage;
import pages.Resourcepage;


public class Tc_preloadedlogo extends Base {

    private final Base base;
    Loginpage lp;
    Resourcepage rp;

    public Tc_preloadedlogo(Base base) {
        this.base = base;
    }

    @Given("I login using {string} and {string}")
    public void iLoginUsingAnd(String userName, String password) throws InterruptedException {
        lp = new Loginpage(base.driver);

        lp.login(userName, password);
        lp.clickLogin();
    }

    @When("I click on resources")
    public void iClickOnResources() {
        rp = new Resourcepage(base.driver);
        rp.clickResource();
    }

    @Then("Go to View or Customize button and click on the check box to generate the url with validation")
    public void goToViewOrCustomizeButtonAndClickOnTheCheckBoxToGenerateTheUrlWithValidation() throws InterruptedException {
        for (int i = 1; i <= 6; i++) {
            rp.viewOrCustomize(i);
            rp.clickGenerateUrl();
            rp.validateUrl();
            base.driver.navigate().back();
        }
    }
}
