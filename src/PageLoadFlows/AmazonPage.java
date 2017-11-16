package PageLoadFlows;

import com.paulgavrikov.notification.Notification;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static Constants.Page_Objects_Constants.AmazonSearchItem;
import static Constants.Page_Objects_Constants.AmazonUrl;

/**
 * Created by andrei.filip on 10/30/2017.
 */
public class AmazonPage {

    static WebDriver driver;
    static By AmazonSearchBarElement = By.id("twotabsearchtextbox");
    static By AmazonSearchButton = By.id("nav-search-submit-text");
    static By VideoElement = By.xpath("//*[contains(text(),'The Lord Of The Rings: The Fellowship Of The Ring')]");
    static By bookResultElement = By.xpath("//*[contains(text(),'The Lord of the Rings: 50th Anniversary, One Vol. Edition')]");

    Notification notificationP = new Notification();


    public AmazonPage(WebDriver driver) {
        this.driver = driver;

    }


    public void accessAmazon() throws InterruptedException {

        TimeUnit.SECONDS.sleep(2);

        Alert alert = null;
        notificationP.push("Amazon","Access Amazon");
        driver.get(AmazonUrl);
        JOptionPane.showMessageDialog(null, "Website accessed");
        Thread.sleep(5000);

    }

    public  void searchAmazon() {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(AmazonSearchBarElement));
        driver.findElement(AmazonSearchBarElement).sendKeys(AmazonSearchItem);
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(AmazonSearchButton));
        notificationP.push("Amazon","Search Amazon");
        driver.findElement(AmazonSearchButton).click();

    }


    public  void accessVideoResult() throws InterruptedException {
        Thread.sleep(5000);
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(VideoElement));
        notificationP.push("Amazon","Access Video");
        driver.findElement(VideoElement).click();

    }

    public  void backAction() {

        notificationP.push("Amazon","Back Action");
        driver.navigate().back();
    }

    public  void accessBookResult() {
        (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.visibilityOfElementLocated(bookResultElement));
        notificationP.push("Amazon","Access Book");
        driver.findElement(bookResultElement).click();
    }

    public void runAllScenarios() throws InterruptedException {
        accessAmazon();
        searchAmazon();
        accessVideoResult();
        backAction();
        accessBookResult();
    }

}
