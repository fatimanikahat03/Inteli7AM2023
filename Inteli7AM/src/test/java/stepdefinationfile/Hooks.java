package stepdefinationfile;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before()
    public void setup(){

        System.out.println("Before Class Starts");

    }

    @After()
    public void teardown(){
        System.out.println("End");
    }


}
