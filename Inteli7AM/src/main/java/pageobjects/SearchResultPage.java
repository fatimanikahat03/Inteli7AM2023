package pageobjects;

import org.openqa.selenium.By;
import resuable.BrowserCall;

public class SearchResultPage extends BrowserCall {

    public static void selectProduct(int productIndex){

        getDriver().findElement(By.xpath("//div[@data-cel-widget='search_result_"+productIndex+"']//a")).click();
    }


}
