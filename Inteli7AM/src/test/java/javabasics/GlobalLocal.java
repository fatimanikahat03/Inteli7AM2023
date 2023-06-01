package javabasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GlobalLocal {

    double pie = 3.14 ;  // Global variable

    WebDriver driver ; //null

    public void m1(){
          //local vara
        double pie = 3.89 ;
        System.out.println(pie);
        driver = new EdgeDriver(); //local
    }

    public void m2(){

        System.out.println(pie);

        int a = 1;
        int b= 2;
        System.out.println(a);

    }

}
