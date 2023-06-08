package pageobjects;

import org.openqa.selenium.By;
import resuable.BrowserCall;

public class SignInPage extends BrowserCall {


    //--------Locotors------------

  static private By emailTextBoxLocotor = By.id("ap_email");
   static private By continueButtonLocotor = By.id("continue");
  static private By passwordTextboxLocotor = By.id("ap_password");

  static private By signInButtonLocotor = By.id("signInSubmit");

  static private By getLoginTextLocotor = By.className("a-spacing-small");

    //--------------Methods--------------

public static void enterUserName(){
    getDriver().findElement(emailTextBoxLocotor).sendKeys(prob.getProperty("user"));
}

public static void clickContinueButton(){

    getDriver().findElement(continueButtonLocotor).click();
}

public static void enterPassword(){

    getDriver().findElement(passwordTextboxLocotor).sendKeys(prob.getProperty("password"));
}

public static void clickSignIn(){

    getDriver().findElement(signInButtonLocotor).click();
}

public static String getSignInText(){

    return getDriver().findElement(getLoginTextLocotor).getText();
}

}
