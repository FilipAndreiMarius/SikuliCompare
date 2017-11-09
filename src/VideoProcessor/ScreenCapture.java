package VideoProcessor;

import PageLoadFlows.GooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.net.MalformedURLException;

/**
 * Created by andrei.filip on 11/7/2017.
 */
public class ScreenCapture  extends Thread{


    static WebDriver driver;


    public ScreenCapture() throws MalformedURLException, AWTException, InterruptedException {
        runTest();

    }


    public static  void runTest() throws MalformedURLException, AWTException, InterruptedException {
           System.setProperty("webdriver.gecko.driver", "C:\\Commons\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        GooglePage google = new GooglePage();
        //google.runAllScenarios();
        driver.quit();
    }

}
