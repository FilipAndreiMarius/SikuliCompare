package PageLoadFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    static By GoogleSearchBar = By.id("lst-ib");
    static By GoogleSearchButton = By.className("lsb");
    static By GoogleImage = By.xpath("//*[@class='q qs']");
     Notifications url=new Notifications("GSearchURL","GsearchUrl is accessed") ;
   // Notifications url2=new Notifications("aaa","23423423 is accessed") ;



    public GooglePage(WebDriver driver) throws MalformedURLException, AWTException {

        this.driver = driver;
    }

    public void accessGsearch() throws MalformedURLException, AWTException {
        url.thread.start();

        driver.get(GsearchUrl);



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

    public void runAllScenarios() throws MalformedURLException, AWTException {
        accessGsearch();
        searchGoogle();
        accessImage();
    }

}
