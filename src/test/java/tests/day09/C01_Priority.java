package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Before Method Calisti");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("After Method Calisti");
    }

    @Test (priority = 10)
    public void test01() {
        System.out.println("test01 calisti");
    }

    @Test (priority = 5)
    public void ikincitest() {
        System.out.println("ikincitest calisti");
    }
    @Test (priority = 2)
    public void yazdimTest() {
        System.out.println("yazdimTest calisti");
    }

    /*
        Eger bazilarinda priority yazip bazinlarin da yazmadiysam ;
        1- PRIORITY YAZILMAYAN METHODLAR EN BASTA CALISIR, ALFABETIK SIRAYLA CALISIR.
        2- PRIORITY YAZILAN METHODLAR ISE ; VERILEN ONCELIK SIRASINA GORE CALISIR
        3- EGER HERHANGI BIR PRIORITY VERILMEDIYSE ALFABETIK SIRAYA GORE CALISIR.
     */
    /*
        Handle Dropdown :
        1) Dropdown menuyu herhangi bir locator ile locate edin.
            WebElement selectElement = driver.findElement(By.id("value of id"));
        2) Yeni bir "select" objesi olusturun ve daha once locate ettigimiz
        WebElement'i parameter olarak yeni objeye ekleyin.
            Select options = new Select(selectElement);
        3) Dropdown icin kullanilan 3 yontemden biriyle dropdown menusundeki
        elemanlardan istediginizi seciniz.
            options.SelectByIndex(1);



        - Dropdown menuleri her zaman <select> tag'i ile baslar.
        - Dropdown'u nasil handle edersin ?
            <select> tag'i ile
     */


}
