package PageLoadFlows;

import com.paulgavrikov.notification.Notification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static Constants.Page_Objects_Constants.GsearchUrl;
import static Constants.Page_Objects_Constants.searchItem;

/**
 * Created by andrei.filip on 10/30/2017.
 */
public class GooglePage {

    WebDriver driver;
    Boolean status;



    static By GoogleSearchBar = By.id("lst-ib");
    static By GoogleSearchButton = By.className("lsb");
    static By GoogleImage = By.xpath("//*[@class='q qs']");
   // Notifications url=new Notifications("GSearchURL","GsearchUrl is accessed") ;
    Notification notificationP=new Notification();


   // Notifications url2=new Notifications("aaa","23423423 is accessed") ;



    public GooglePage(WebDriver driver) throws MalformedURLException, AWTException, InterruptedException {

       this.driver = driver;

    }

    public void accessGsearch() throws MalformedURLException, AWTException, InterruptedException {
        //url.thread.start();

        TimeUnit.SECONDS.sleep(2);

        notificationP.push("GSearch","Access GSearch");
        driver.get(GsearchUrl);

        //Thread.sleep(3000);
        //driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);



    }

    public void searchGoogle() throws MalformedURLException, AWTException, InterruptedException {
        driver.findElement(GoogleSearchBar).sendKeys(searchItem);
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(GoogleSearchButton));
        notificationP.push("GSearch","Search Google");
        driver.findElement(GoogleSearchButton).click();

        //Thread.sleep(1000);
    }

    public  void accessImage() throws MalformedURLException, AWTException, InterruptedException {

        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(GoogleImage));
        notificationP.push("GSearch","Access Images");
        driver.findElement(GoogleImage).click();
        //Thread.sleep(1000);

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
