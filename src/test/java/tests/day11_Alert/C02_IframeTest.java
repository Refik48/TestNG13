package tests.day11_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_IframeTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
    }

        /*
        https://the-internet.herokuapp.com/iframe adresine gidin.
        ● Bir metod olusturun: iframeTest
        ○ “An IFrame containing....” textinin erisilebilir oldugunu test edin ve konsolda
            yazdirin.
        ○ Text Box’a “Merhaba Dunya!” yazin.
        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
            oldugunu dogrulayin ve konsolda yazdirin.
        */

    @Test
    public void iframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // *********** 1) “An IFrame containing....” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iFrameYazisiWebElementi = driver.findElement(By.tagName("h3"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(iFrameYazisiWebElementi.isEnabled()); // Erisilebilir oldugunu test edecek
        System.out.println(iFrameYazisiWebElementi.getText());
                // Sout sonucu => An iFrame containing the TinyMCE WYSIWYG Editor

        // *********** 2) Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeLocator = driver.findElement(By.id("mce_0_ifr")); // 3 Yontem ile ifram'e girebiliriz.
        driver.switchTo().frame(iframeLocator); // WEBELEMENTI ILE
        // driver.switchTo().frame(0);          // INDEX ILE
        // driver.switchTo().frame("mce_0_ifr");// ID ILE
        WebElement yaziAlani = driver.findElement(By.cssSelector(".mce-content-body "));
        /*
            Eger biz gondermek, secmek... yapmak istedigimiz islemin yolundan eminsek ve
            gene de olmuyorsa burada iframe olabilir ve switchTo() method'unu kullanmak gerekebilir.

            Sayfanin icinde sayfa gibi dusunebiliriz.
            dolayisiyla kullanmak icin sayfanin icinde switchTo() yapmamiz gerekiyor.
                    driver.switchTo().frame(0); yazarak girdim. (0 index degeri)
        */
        yaziAlani.clear();
        yaziAlani.sendKeys("Merhaba Dunya");

        // *********** 3) TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
        // oldugunu dogrulayin ve konsolda yazdirin.

        driver.switchTo().defaultContent(); // Girmis oldugum iframe'den ciktim.
        WebElement linkWebElementi=driver.findElement(By.linkText("Elemental Selenium"));
        softAssert.assertTrue(linkWebElementi.isDisplayed());
        System.out.println(linkWebElementi.getText());

        softAssert.assertAll();
    }
}
