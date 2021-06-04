package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C01_DependsOnTest {

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
        // driver.close();
    }
    /*
     https://www.walmart.com/ adresine gidin.
    1. Test : Wallmart ana sayfaya gittiginizi test edin
    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        arama yapin ve aramanizin gerceklestigini Test edin
    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
        $7.97 oldugunu test edin
     */
    /*
        BeforeClass ve AfterClass neden oldu ? Cunku BeforeMethod ve AfterMethod her test'den once
        calisiyordu. Burada testler birbirine bagli oldugu icin her test oncesinde ve sonrasinda
        calismasi hata vermesine sebep oluyor.
     */

    @Test
    public void test01HomePage() {
        driver.get("https://www.walmart.com/");
        String expectedUrl = "https://www.walmart.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"niye olmadi ki ?");
    }

    @Test (dependsOnMethods = "test01HomePage")
    public void test02Search() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='query']"));
        String aranacakKelime = "Nutella";
        searchBox.sendKeys(aranacakKelime);
        searchBox.submit();

        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(aranacakKelime));
    }

    @Test (dependsOnMethods = "test02Search")
    // Sadece 3'u calistirdigimiz zaman calismaz. 2.method'a gider bakar fakat 2. method 1'e gitmez.
    // Burada calistirmak icin class leveldan calistirmak daha saglikli ve dogrudur.
    public void test03() {
        WebElement firstNutellaImg = driver.findElement(By.xpath("(//img[@data-pnodetype='item-pimg'])[1]"));
        firstNutellaImg.click();

        WebElement nutellaValue = driver.findElement(By.xpath("(//span[@class='price-group'])[1]"));

        String actualNutellaValue = nutellaValue.getText();
        String expextedNutellaValue = "7.97";
        Assert.assertEquals(actualNutellaValue,expextedNutellaValue);

        /*

         */
    }
}
