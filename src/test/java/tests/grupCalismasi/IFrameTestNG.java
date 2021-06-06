package tests.grupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IFrameTestNG {

    // We can even identify total number of iframes by using below snippet.
    // int iframeSize = driver.findElements(By.tagName("iframe")).size();
    // System.out.println("IFrame Sayısı "+iframeSize);
    /*
    // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    // sayfadaki iframe sayısını bulunuz.
    // ilk iframe'deki (Youtube) play butonuna tıklayınız.
    // ilk iframe'den çıkıp ana sayfaya dönünüz
    // ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
     */

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        // sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        for (WebElement w : iframeList) { // iframe tag'inda id'ye sahip olanlari getirdi.
            System.out.println(w.getAttribute("id")); // a077aa5e
        }
        System.out.println("IFrame Adeti : " + iframeList.size()); // IFrame Adeti : 2

        // ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeIframeWE = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeIframeWE);
        WebElement youtubeVideo = driver.findElement(
                By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        youtubeVideo.click();

        // ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        // ikinci iframe'deki (Jmeter Made Easy)linke (https://www.guru99.com/live-selenium-project.html) tıkla
        Thread.sleep(5000);
        WebElement linkliIframeWE = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(linkliIframeWE);
        WebElement linkeTiklama = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
        linkeTiklama.click();

    }
}
