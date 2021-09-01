package stepdef;

import baseUtils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.Loginpage;

public class Tc_login extends Base {

    private final Base base;
    Loginpage lp;

    public Tc_login(Base base) {
        this.base = base;
    }

    @Given("I hit the login url")
    public void iHitTheLoginUrl() {
    }

    @When("I enter the details {string}, {string}, {string}")
    public void iEnterTheDetails(String userName, String password, String check) throws InterruptedException {
        lp = new Loginpage(base.driver);
        lp.login(userName, password);
    }

    @And("click on login")
    public void clickOnLogin() throws InterruptedException {
        lp.clickLogin();
    }

    @Then("if the details are valid it will redirect home page else it will stay in login page with error")
    public void ifTheDetailsAreValidItWillRedirectHomePageElseItWillStayInLoginPageWithError() {
        lp.loginValidate();
    }
}
