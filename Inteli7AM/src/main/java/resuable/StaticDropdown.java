package resuable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

    public static void selectDropdownValue(WebElement e){

        Select s = new Select(e);
    }
}
