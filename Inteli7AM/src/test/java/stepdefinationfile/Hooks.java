package stepdefinationfile;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageobjects.SignInPage;
import resuable.BrowserCall;

import java.io.IOException;

public class Hooks extends BrowserCall{



    @Before(order=0,value ="@Table")
    public void m1(){
        System.out.println("additional step");
    }

    @Before(order= 1)
    public void setup() throws IOException {

        BrowserCall.bowserInvocation();

    }

    @After()
    public void teardown(){

    getDriver().quit();

    }

    @AfterStep()
    public void takeScreenshot(Scenario sc){

       byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
       sc.attach(screenshot,"image/png",sc.getName());

    }

    @BeforeStep()
    public  void beforeStep(){


    }


}
