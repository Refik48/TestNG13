package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseMethod {
    // public : Herkes ulasabilir.
    // protected : Ayni package veya child classlar
    // default (bir sey yaz yazmazsak default kabul edilir) : package private'da denir. Sadece package'e ozel.
    // private : sadece class icinde kullanabiliriz.

    protected WebDriver driver;

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
}
