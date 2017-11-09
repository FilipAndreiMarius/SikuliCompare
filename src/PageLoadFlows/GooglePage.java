package PageLoadFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.net.MalformedURLException;

import static Constants.Page_Objects_Constants.GsearchUrl;
import static Constants.Page_Objects_Constants.searchItem;

/**
 * Created by andrei.filip on 10/30/2017.
 */
public class GooglePage {

    static WebDriver driver;
    Boolean status;

    static By GoogleSearchBar = By.id("lst-ib");
    static By GoogleSearchButton = By.className("lsb");
    static By GoogleImage = By.xpath("//*[@class='q qs']");
     Notifications url=new Notifications("GSearchURL","GsearchUrl is accessed") ;
   // Notifications url2=new Notifications("aaa","23423423 is accessed") ;



    public GooglePage() throws MalformedURLException, AWTException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Commons\\geckodriver.exe");
        driver=new FirefoxDriver();
        accessGsearch();



    }

    public void accessGsearch() throws MalformedURLException, AWTException, InterruptedException {
       // url.thread.start();
        driver.get(GsearchUrl);
        Thread.sleep(3000);



    }

    public void searchGoogle() throws MalformedURLException, AWTException {
        driver.findElement(GoogleSearchBar).sendKeys(searchItem);
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(GoogleSearchButton));
        driver.findElement(GoogleSearchButton).click();

    }

    public static void accessImage() throws MalformedURLException, AWTException {

        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(GoogleImage));
        driver.findElement(GoogleImage).click();
    }

    public void runAllScenarios() throws MalformedURLException, AWTException, InterruptedException {
        accessGsearch();
        searchGoogle();
        accessImage();
    }
    public void quit(){
        System.out.println("FINISH TEST");
        driver.quit();

    }

    public Boolean changeStatus(Boolean status){
        this.status=status;
        return status;
    }

}
