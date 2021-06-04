package tests.grupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Amazon {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
    }
    @AfterMethod
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void test01() {
        WebElement kategori = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(kategori);

        select.selectByIndex(27);
        //select.selectByValue("search-alias=toys-and-games-intl-ship");
        //select.selectByVisibleText("Toys & Games");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("funko avatar" + Keys.ENTER);

        WebElement secondFunko = driver.findElement(
                By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        secondFunko.click();
        WebElement tikKutucugu = driver.findElement(By.xpath("//input[@id='gift-wrap']"));
        tikKutucugu.click();

        WebElement adet = driver.findElement(By.xpath("//select[@id='quantity']"));
        Select select2 = new Select(adet);
        select2.selectByValue("2");

        WebElement sepeteEkle = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        sepeteEkle.click();

        WebElement sepettenKaldir = driver.findElement(By.xpath("(//input[@class='a-button-input'])[2]"));
        sepettenKaldir.click();
    }


}
