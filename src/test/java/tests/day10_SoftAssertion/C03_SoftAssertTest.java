package tests.day10_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_SoftAssertTest {

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
         1. “http://zero.webappsecurity.com/” Adresine gidin
         2. Sign in butonuna basin
         3. Login kutusuna “username” yazin
         4. Password kutusuna “password.” yazin
         5. Sign in tusuna basin
         6. Pay Bills sayfasina gidin
         7. “Purchase Foreign Currency” tusuna basin
         8. “Currency” drop down menusunden Eurozone’u secin
         9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
         10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",
         "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
         "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
         "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
         "Singapore (dollar)","Thailand (baht)"
        */
    @Test
    public void test01() {
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        WebElement signInButon = driver.findElement(By.xpath("//i[@class='icon-signin']"));
        signInButon.click();

        // 3. Login kutusuna “username” yazin
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        usernameBox.sendKeys("username");

        // 4. Password kutusuna “password.” yazin
        // 5. Sign in tusuna basin
        WebElement pwBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        pwBox.sendKeys("password");
        pwBox.submit();

        // guvenlik asamasini gecmesi icin
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        // 6. Pay Bills sayfasina gidin
        WebElement payBillsButon = driver.findElement(By.linkText("Pay Bills"));
        payBillsButon.click();

        // 7. “Purchase Foreign Currency” tusuna basin
        WebElement purchaseForeignCurrencyButton = driver.findElement
                (By.linkText("Purchase Foreign Currency"));
        purchaseForeignCurrencyButton.click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement acilirListe = driver.findElement(By.id("pc_currency"));
        Select select = new Select(acilirListe);
        select.selectByValue("EUR");

        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String actualSeciliOpsiyon = select.getFirstSelectedOption().getText();
        String expectedValue = "Eurozone (euro)";
        softAssert.assertEquals(actualSeciliOpsiyon,expectedValue);


        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> liste = select.getOptions(); // Acilir Liste'deki elemanlari aldik.
        List<String> expectedList = Arrays.asList("Select One",
        "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
                "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)");
        List<String> actualList = new ArrayList<String>();
        for (WebElement w : liste) {
            actualList.add(w.getText());
        }
        softAssert.assertEquals(actualList,expectedList,"liste birbirine esit degil");

        softAssert.assertAll(); // softAssertun raporlarinin yazdirilmasi icin gerekli method.
    }


}
