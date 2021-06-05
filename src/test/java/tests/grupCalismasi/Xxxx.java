package tests.grupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Xxxx {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://youtube.com");
        driver.findElement(By.xpath("//span[text()='Kabul ediyorum']")).click();
        WebElement sb = driver.findElement(By.xpath("//input[@id='search']"));
        sb.click();
        sb.sendKeys("yorgun yillarim");
        sb.submit();
        WebElement fs = driver.findElement(By.xpath("(//yt-formatted-string[@class='style-scope ytd-video-renderer'])[1]"));
        fs.click();


    }
    @Test
    public void test02() {

    }
}
