package stepdef;

import baseUtils.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Resourcepage;

public class Tc_GinaUrl extends Base {
    private final Base base;
    Resourcepage rp;

    public Tc_GinaUrl(Base base) {
        this.base = base;
    }

    @When("Click on Gina in the Resources")
    public void clickOnGinaInTheResources() {
        rp = new Resourcepage(base.driver);
        rp.clickGina();
    }

    @Then("It should redirect to the url {string}")
    public void itShouldRedirectToTheUrl(String expectedUrl) {
        rp.validateGinaUrl(expectedUrl);
    }
}
