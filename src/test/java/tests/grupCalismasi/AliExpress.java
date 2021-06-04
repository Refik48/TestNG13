package tests.grupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AliExpress {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://aliexpress.com");
        driver.findElement(By.xpath("//div[@class='Sk1_X _1-SOk']")).click();
    }
    @AfterMethod
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void test01() {

        WebElement kategoriler = driver.findElement(By.xpath("//select[@id='search-dropdown-box']"));
        Select select = new Select(kategoriler);

        //select.selectByIndex(8);
        //select.selectByValue("26");
        //select.selectByVisibleText("Oyuncaklar ve Hobi Ürünleri");

        System.out.println("Sectgimiz kategori : " + select.getFirstSelectedOption().getText());
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search-key']"));
        searchBox.sendKeys("zuko avatar");
        searchBox.submit();
    }
}
