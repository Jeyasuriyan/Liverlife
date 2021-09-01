package stepdef;

import baseUtils.Base;
import baseUtils.Baseutils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Interceptspage;

public class Tc_intercepts extends Base {

    private final Base base;
    Interceptspage iP;

    public Tc_intercepts(Base base) {
        this.base = base;
    }

    @When("I click on intercepts only")
    public void iClickOnInterceptsOnly() {
        iP = new Interceptspage(base.driver);
        iP.clickIntercepts();
    }

    @Then("Go to View and check whether able to open and close")
    public void goToViewAndCheckWhetherAbleToOpenAndClose() throws InterruptedException {
        for (int i = 1; i <= 6; i++) {
            iP.viewIntercepts(i);
//            iP.openSlide();
//            iP.closeSlide();
            base.driver.navigate().back();
        }
    }


}