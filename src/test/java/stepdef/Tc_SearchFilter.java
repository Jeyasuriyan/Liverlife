package stepdef;

import baseUtils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Resourcepage;

import java.util.ArrayList;
import java.util.List;

public class Tc_SearchFilter extends Base {

    private final Base base;
    Resourcepage rp;

    public Tc_SearchFilter(Base base) {
        this.base = base;
    }

    @And("Enter the value for to check the search function {string}")
    public void enterTheValueForToCheckTheSearchFunction(String value) {
        rp = new Resourcepage(base.driver);
        rp.enterResourceSearch(value);
    }

    @Then("Verify that the same resource is showing {string}.")
    public void verifyThatTheSameResourceIsShowing(String acutalResourceName) {
        rp.validateSearch(acutalResourceName);
    }

    @And("Click on target audience and Check the filter is working or not")
    public void clickOnTargetAudienceAndCheckTheFilterIsWorkingOrNot() {
        rp.clickTargetAudience();
    }

    @Then("Validate the filter results by {string} and {string}")
    public void validateTheFilterResultsByAnd(String patient, String healthCare) {
        List<String> l = new ArrayList<String>();
        l.add(patient);
        l.add(healthCare);
        for (String i : l) {
            rp.selectTarget(i);
        }

    }
}
