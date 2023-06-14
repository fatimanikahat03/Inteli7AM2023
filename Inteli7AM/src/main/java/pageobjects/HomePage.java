package pageobjects;

import org.openqa.selenium.By;
import resuable.BrowserCall;

public class HomePage extends BrowserCall {

    //------------Locotors Properties---------------
   static private By seachBoxLocotor = By.id("twotabsearchtextbox");
  static private By loginButtonLocotor = By.id("nav-link-accountList-nav-line-1");

  static private By searchButton = By.id("nav-search-submit-button");
    //------------Methods---------------

    public static void searchProduct(String searchText){

        getDriver().findElement(seachBoxLocotor).sendKeys(searchText);
    }

    public static void clickSignIn(){
        getDriver().findElement(loginButtonLocotor).click();
    }

    public static void clickSearchButton(){

        getDriver().findElement(searchButton).click();
    }

}
