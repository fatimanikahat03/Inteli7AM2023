package stepdefinationfile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.SignInPage;

public class AmazonSteps {

    @Given("user enter the credi and login the application")
    public void enterCredit(){

        HomePage.clickSignIn();
        SignInPage.enterUserName();
        SignInPage.clickContinueButton();
        SignInPage.enterPassword();
    }

    @Then("Validate the user navigate to homepage")
    public void validateTheUserNavigateToHomepage() {

    }
}
