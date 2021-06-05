package tests.grupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Avon {
    // (//span[@class='ng-binding ng-scope'])[34]
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
    @Test
    public void test01() {
        driver.get("https://kozmetik.avon.com.tr/");
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        WebElement reklamKapama = driver.findElement(By.xpath("//i[@id='icon-close-button-1454703945249']"));
        reklamKapama.click();
        WebElement musteriGiris = driver.findElement(By.linkText("Müşteri Girişi"));
        musteriGiris.click();
    }
}
