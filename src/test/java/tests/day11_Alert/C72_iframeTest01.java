package tests.day11_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C72_iframeTest01 {
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
        WebElement textWE = driver.findElement(By.xpath
                ("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(textWE.isEnabled());

        System.out.println(textWE.getText());

        WebElement yaziBoxIF = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(yaziBoxIF);
        WebElement yaziBoxWE = driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziBoxWE.clear();
        yaziBoxWE.sendKeys("Hello Word");

        driver.switchTo().defaultContent(); // IFrame'den cikis yapmak icin ; En basa donuyor.
        // driver.switchTo().parentFrame(); // Bir onceki iframe'e donuyor.

        WebElement elementalSeleniumYazisi = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elementalSeleniumYazisi.isDisplayed());
        System.out.println(elementalSeleniumYazisi.getText());

    }

}
