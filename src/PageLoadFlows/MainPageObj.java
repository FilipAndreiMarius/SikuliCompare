package PageLoadFlows;

import VideoProcessor.VideoCapture;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by andrei.filip on 10/31/2017.
 */
public class MainPageObj {
     WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Commons\\geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();

    }

          @After
        public void tearDown() {
            driver.quit();

    }

    @org.junit.Test
    public void testGsearch() throws AWTException, InterruptedException, IOException {
        VideoCapture video = new VideoCapture("30", "15");
        video.runVideo("runVideo");
        GooglePage google = new GooglePage(driver);
        google.runAllScenarios();
    }
}

   /* @Test
    public void testsFacebook() throws InterruptedException {

        FacebookPage facebookPage = new FacebookPage(driver1);
        facebookPage.LoginFacebook();
        facebookPage.accessGroup();
        facebookPage.goHome();
        facebookPage.accessUser();
    }

    @Test
    public void testsGmail() throws InterruptedException, MalformedURLException, AWTException {

        GmailPage gmail = new GmailPage(this.driver1);
        gmail.loginGmail();
        gmail.accessEmail();
        gmail.accessYoutubeLink();
    }
*/

/*

    @Test
    public void testYoutube() throws InterruptedException {
        YoutubePage youtube = new YoutubePage(driver1);
        youtube.runAllScenarios();
    }

    @Test
    public void testAmazon() throws InterruptedException {
        AmazonPage amazon = new AmazonPage(driver1);
        amazon.runAllScenarios();
    }
*/




