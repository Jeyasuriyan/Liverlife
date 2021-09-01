package stepdef;

import baseUtils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Ehrpluginpage;
import pages.Resourcepage;

public class Tc_EhrPlugin extends Base {

    private final Base base;
    Ehrpluginpage eP;

    public Tc_EhrPlugin(Base base) {
        this.base = base;
    }

    @When("Click on EHRPlugin")
    public void clickOnEHRPlugin() {
        eP = new Ehrpluginpage(base.driver);
        eP.clickEhrplugin();
    }

    @And("Click on View live sample")
    public void clickOnViewLiveSample() {
        eP.clickViewLiveSample();
    }

    @Then("It should redirect to the static url {string}")
    public void itShouldRedirectToTheStaticUrl(String expectedEhrUrl) {
        eP.validateEhrSampleUrl(expectedEhrUrl);
    }


}
