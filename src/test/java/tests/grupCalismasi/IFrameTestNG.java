package tests.grupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
       // driver.quit();
    }


    @Test
    public void test01() {
        driver.get("http://demo.guru99.com/test/guru99home/");
    }

}
