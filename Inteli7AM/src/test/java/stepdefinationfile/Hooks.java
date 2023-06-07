package stepdefinationfile;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;
    @Before()
    public void setup(){

        System.out.println("Before each scenario Starts");

    }

    @After()
    public void teardown(){

     //   driver.close();

    }

    @AfterStep()
    public void takeScreenshot(){

        System.out.println("Take Screenshot");
    }

    @BeforeStep()
    public  void beforeStep(){
        System.out.println("before");
    }


}
