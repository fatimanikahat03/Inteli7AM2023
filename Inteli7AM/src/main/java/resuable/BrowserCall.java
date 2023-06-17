package resuable;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserCall {

    public static Properties prob;
    static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    public static WebDriver bowserInvocation() throws IOException {

       String path = System.getProperty("user.dir");
        System.out.println(path);
        FileInputStream inputStream = new FileInputStream(new File(path + "/src/main/resources/utility/environment.properties"));
        prob = new Properties();
        prob.load(inputStream);

        switch (prob.getProperty("browser").toLowerCase()){

            case "chrome":
              threadLocal.set(new ChromeDriver());
                break;
            case "edge":
               threadLocal.set(new EdgeDriver());
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
        getDriver().navigate().to(prob.getProperty("url"));
        getDriver().navigate().refresh();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return getDriver();

    }

    public static WebDriver getDriver(){

        return threadLocal.get();
    }

}
