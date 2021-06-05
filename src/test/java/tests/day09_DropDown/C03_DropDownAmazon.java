package tests.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_DropDownAmazon {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // driver.close();
    }
    /*
    https://www.amazon.com/ adresine gidin.
    - Test 1
        Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    -Test 2
        1. Kategori menusunden Books secenegini  secin
        2. Arama kutusuna Java yazin ve aratin
        3. Bulunan sonuc sayisini yazdirin
        4. Sonucun Java kelimesini icerdigini test edin
    */
    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        WebElement dropdownMenusu = driver.findElement(By.xpath("//select[@name='url']"));
        Select select = new Select(dropdownMenusu);
        List<WebElement> tumOpsiyonlar = select.getOptions();

        int expectedOpsiyonSayisi = 45;
        int actualOpsiyonSayisi = tumOpsiyonlar.size();

        Assert.assertEquals(actualOpsiyonSayisi,expectedOpsiyonSayisi,"Beklenen sayi yanlis");
        // Testimiz failed oldu cunku 45 mi diye baktik fakat 28 cikti.

        // JUnit'te once expected sonra actual yaziyorduk.
        // TestNG'de ise once actual daha sonra expected yaziyor.
        // Eger istersek bir virgul daha koyarak mesaj verebiliriz.

    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com/");
        WebElement dropdownMenusu = driver.findElement(By.xpath("//select[@name='url']"));
        Select select = new Select(dropdownMenusu);
        select.selectByValue("search-alias=stripbooks-intl-ship");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java");
        searchBox.submit();

        WebElement results = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println("Toplam : " + results.getText() + " Adet sonuc vardir.");

        Assert.assertTrue(results.getText().contains("Java"));
    }
}
