package stepdefinationfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import resuable.BrowserCall;

import java.io.IOException;

public class AutomationMappingSteps {

 WebDriver driver;   //Global Variable
 WebElement currencyElement ;

 WebElement ctsTable;

 @When("User enter the username {string} and password {string}")
public void enterUsernamePassword(String userName , String password){

// driver.findElement(By.id("username")).sendKeys(userName);
// driver.findElement(By.name("pw")).sendKeys(password);
// //driver.findElement(By.name("pw")).sendKeys("Madurai" + Keys.ENTER);

  driver.findElement(By.cssSelector("input[id='username']")).sendKeys(userName);
  driver.findElement(By.cssSelector("#password")).sendKeys(password);

//  driver.findElement(By.cssSelector(".mb16.wordwrap"));
//
//  driver.findElement(By.linkText("Forgot Your Password?")).click();
//  driver.findElement(By.partialLinkText("got Your P")).click();

}

@Given("User launch the browser and navigate to the URL")
 public void  lauchBrowser() throws IOException {

 driver = BrowserCall.bowserInvocation();

}

 @And("user clicks the login button")
 public void loginButton() {
  driver.findElement(By.id("Login")).click();

 }

 @Then("Validate the error message")
 public void errorMessageValidation() {

  String actualErrorMessage =   driver.findElement(By.id("error")).getText();
  String ExpectedErrorMessage = "check your username and password. If you still can't log in, contact your Salesforce administrator.";
  if(actualErrorMessage.equals(ExpectedErrorMessage)){

   System.out.println("Equal");
  }
  else{
   System.out.println("Error message are not equal");
  }


 }

 @Then("validate whether the user navigates to homepage")
 public void validateWhetherTheUserNavigatesToHomepage() {


 }

 @When("User selects the specifc dropdown value")
 public void handleDropdown() {

 currencyElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));
 Select selectCurrency = new Select(currencyElement);
  // selectCurrency.selectByIndex(3);
 //  selectCurrency.selectByVisibleText("EUR");
  selectCurrency.selectByValue("GBP");

  driver.findElement(By.id("divpaxinfo")).click();

  WebElement adultElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT"));
  Select adultDropdown = new Select(adultElement);
  adultDropdown.selectByIndex(4);

 }

 @And("User iterates the dropdownvalues")
 public void userIteratesTheDropdownvalues() {

  int sample = driver.findElements(By.tagName("option")).size();
  System.out.println(sample);
 int currencyDropdownSize = currencyElement.findElements(By.tagName("option")).size();

 for(int i =0 ; i < currencyDropdownSize ;i++ ){

  String value =currencyElement.findElements(By.tagName("option")).get(i).getText();
  System.out.println(value);

 }

 //driver.findElement(By.xpath("//input[@id='username']/parent::div")).sendKeys("");

 }


 @Given("user naviagates and click on the table")
 public void userNaviagatesAndClickOnTheTable() throws IOException {

  driver = BrowserCall.bowserInvocation();


 }

 @When("user iterates the value from column one")
 public void userIteratesTheValueFromColumnOne() {


 //WebElement ctsTable = driver.findElement(By.xpath("//table[@class='infobox vcard']"));

   ctsTable = driver.findElement(By.cssSelector(".infobox.vcard"));

  for (int i=0; i<ctsTable.findElements(By.tagName("th")).size();i++){

   System.out.println(ctsTable.findElements(By.tagName("th")).get(i).getText());
  }

 }

 @And("user iterates the value from column two")
 public void userIteratesTheValueFromColumnTwo() {

  for (int i=0; i<ctsTable.findElements(By.tagName("td")).size();i++){

   System.out.println(ctsTable.findElements(By.tagName("td")).get(i).getText());
  }

  WebElement acq =driver.findElement(By.cssSelector(".wikitable.sortable.jquery-tablesorter"));


 }

 @And("iterate the acq table values")
 public void iterateTheAcqTableValues() {

WebElement acqTable =  driver.findElement(By.cssSelector(".wikitable.sortable.jquery-tablesorter"));

//row - tr

 int size = acqTable.findElements(By.xpath("//tr/td[4]")).size();
  System.out.println(size);

  for(int i =0 ; i < acqTable.findElements(By.xpath("//tr/td[4]")).size(); i++ ){

   System.out.println( acqTable.findElements(By.xpath("//tr/td[4]")).get(i).getText());

  }

 }

 @When("handle dynamic dropdown")
 public void handleDynamicDropdown() {

  driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
  driver.findElement(By.xpath("//a[@value='MAA']")).click();

// WebElement fromDrop = driver.findElement(By.id("glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR"));
// fromDrop.findElement(By.xpath("//a[@value='BLR']")).click();
  
 driver.findElement(By.xpath("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR']//a[@value='BLR']")).click();


 }

 @When("handle the mouse actions")
 public void handleTheMouseActions() {

  WebElement log = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
  Actions actions = new Actions(driver);
  actions.clickAndHold(log).build().perform();
  driver.findElement(By.linkText("Baby Wishlist")).click();


 }

 @When("handle the drag and drop")
 public void handleTheDragAndDrop() {

  WebElement frameee = driver.findElement(By.className("demo-frame"));
 driver.switchTo().frame(frameee);

 WebElement source = driver.findElement(By.id("draggable"));
 WebElement target = driver.findElement(By.id("droppable"));

  Actions a = new Actions(driver);
  a.dragAndDrop(source,target).build().perform();

  driver.switchTo().defaultContent();

 }
}
