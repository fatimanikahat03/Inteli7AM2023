package stepdefinationfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resuable.BrowserCall;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

public class AutomationMappingSteps {

 private WebDriver driver;   //Global Variable
 private WebElement currencyElement ;
 private WebElement ctsTable;
 private List<String> firstColumn;

 @When("User enter the username {string} and password {string}")
public void enterUsernamePassword(String userName , String password){

WebElement enterUserName =  driver.findElement(By.id("username"));
WebElement enterPassword = driver.findElement(By.name("pw"));

  enterUserName.sendKeys(userName);
  enterPassword.sendKeys(password);

  driver.navigate().refresh();

  try{

   enterUserName.sendKeys("Aravinth");
   enterPassword.sendKeys("678");

  }
  catch (StaleElementReferenceException a){

    enterUserName =  driver.findElement(By.id("username"));
    enterPassword = driver.findElement(By.name("pw"));
   enterUserName.sendKeys("Aravinth");
   enterPassword.sendKeys("678");

  }
  catch (TimeoutException j){

   WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(10));


  }





// //driver.findElement(By.name("pw")).sendKeys("Madurai" + Keys.ENTER);

//  driver.findElement(By.cssSelector("input[id='username']")).sendKeys(userName);
//  driver.findElement(By.cssSelector("#password")).sendKeys(password);

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

  Assert.assertNotNull(actualErrorMessage);

  String ExpectedErrorMessage = "your username and password. If you still can't log in, contact your Salesforce administrator.";
//  if(actualErrorMessage.equals(ExpectedErrorMessage)){
//
//    Assert.assertTrue(true);
//
//  }
//  else{
//
//   Assert.assertTrue(false);
//
//  }

  Assert.assertEquals(actualErrorMessage,ExpectedErrorMessage);



  Boolean field =driver.findElement(By.id("custom_date_picker_id_2")).isEnabled(); //true , false

  Assert.assertFalse(field);

  driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay")).isSelected();


  driver.findElement(By.id("divpaxinfo")).isDisplayed();
 }

 @Then("validate whether the user navigates to homepage")
 public void validateWhetherTheUserNavigatesToHomepage() {

 //Dynamic Waits

  WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
  driverWait.pollingEvery(Duration.ofSeconds(10));
  driverWait.ignoring(NoSuchElementException.class);
  driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("123")));

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

  List<WebElement> currency = currencyElement.findElements(By.tagName("option"));
  List<String> currencyValue = new ArrayList<String>();
  for (WebElement h:currency){
    currencyValue.add(h.getText());
  }

  System.out.println(currencyValue);
//
//  int sample = driver.findElements(By.tagName("option")).size();
//  System.out.println(sample);
// int currencyDropdownSize = currencyElement.findElements(By.tagName("option")).size();
//
// for(int i =0 ; i < currencyDropdownSize ;i++ ){
//
//  String value =currencyElement.findElements(By.tagName("option")).get(i).getText();
//  System.out.println(value);
//
// }

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

//   List<WebElement> dropvalue = ctsTable.findElements(By.tagName("th"));
//   for (WebElement e:dropvalue){
//    e.getText();
//   }
   firstColumn = new ArrayList<String>();
  for (int i=0; i<ctsTable.findElements(By.tagName("th")).size();i++){
   firstColumn.add(ctsTable.findElements(By.tagName("th")).get(i).getText());
  }

  System.out.println(firstColumn);

 }

 @And("user iterates the value from column two")
 public void userIteratesTheValueFromColumnTwo() {

  List <String > secondCol = new ArrayList<String>();
  for (int i=1; i<ctsTable.findElements(By.tagName("td")).size();i++){

   secondCol.add(ctsTable.findElements(By.tagName("td")).get(i).getText());

  }

  System.out.println(secondCol);

  Map<List, List > mappingValues = new HashMap<List, List >();
  mappingValues.put(firstColumn,secondCol);

  System.out.println(mappingValues.get("Type"));

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

 @When("Handle Auto sugg")
 public void handleAutoSugg() throws InterruptedException {

  driver.findElement(By.id("flying_from_N")).click();
  WebElement fromDrop =  driver.findElement(By.id("flying_from"));
  fromDrop.sendKeys("che");
  Thread.sleep(2000);
  int i =0;
  while (i<4){
   fromDrop.sendKeys(Keys.ARROW_DOWN);
   i++;
  }

  fromDrop.sendKeys(Keys.ENTER);

 }

 public  void logic(){


  driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-month']")).getText();
  driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();

 }

 @When("hello")
 public void hello() {


 }

 @When("Handle the Cal icon")
 public void handleTheCalIcon() {


  driver.findElement(By.className("ui-datepicker-trigger")).click();
//  driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

  while( !driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']")).getText().contains("December")){

   driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();

  }

  WebElement firstSection = driver.findElement(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-first"));
  int enabledDateCount = firstSection.findElements(By.xpath("//a[@class='ui-state-default']")).size();

  for (int i =0 ; i < enabledDateCount ;i++){

   String date = firstSection.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).getText();

   if(date.equals("22")){
    firstSection.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).click();
    break;
   }

  }

 }
}
