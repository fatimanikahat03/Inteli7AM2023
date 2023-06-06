package resuable;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserCall {


    static WebDriver driver;

    public static WebDriver bowserInvocation() throws IOException {

       String path = System.getProperty("user.dir");
        System.out.println(path);
        FileInputStream inputStream = new FileInputStream(new File(path + "/src/main/resources/utility/environment.properties"));
        Properties prob = new Properties();
        prob.load(inputStream);

        switch (prob.getProperty("browser").toLowerCase()){

            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                 break;
            default:
                throw new InvalidArgumentException("invalid browser name");
        }

//        if(prob.getProperty("browser").equalsIgnoreCase("chrome")){
//
//            driver = new ChromeDriver();
//        }
//        else if (prob.getProperty("browser").equalsIgnoreCase("edge")){
//
//            driver = new EdgeDriver();
//        }
//        else{
//            throw new InvalidArgumentException("invalid browser name");
//        }

     //   driver.get(prob.getProperty("url"));
        driver.navigate().to(prob.getProperty("url"));
        driver.navigate().refresh();
        driver.manage().window().maximize();

        return driver;

    }

}
