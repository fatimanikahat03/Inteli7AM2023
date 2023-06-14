package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import resuable.BrowserCall;

public class ProductSpecifcPage extends BrowserCall {

    public static void clickAddtokart(){

        getDriver().findElement(By.id("add-to-cart-button")).click();

    }

    public static void selectQuantity(){


    }
}
