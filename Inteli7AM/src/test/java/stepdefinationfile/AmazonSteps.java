package stepdefinationfile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;
import pageobjects.SignInPage;
import resuable.ReadExcel;

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

    @Given("User search the product with any of keyword")
    public void searchProduct() {

        HomePage.searchProduct(ReadExcel.fetchData("products",0,0));
        HomePage.clickSearchButton();
        Assert.assertTrue(HomePage.getUIText());

    }

    @When("user select the product from search list")
    public void selectProduct() {

        SearchResultPage.selectProduct(6);

    }

    @Then("user validated whether the product added to kart")
    public void validateProduct() {


    }
}
