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
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C71_AlertsTekrar {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void acceptAlert() {
        /*
        ● Bir metod olusturun: acceptAlert
            ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
            “You successfully clicked an alert” oldugunu test edin.
         */
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlertButton.click();
        driver.switchTo().alert().accept();

        String actualResultsYazisi = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResultsYazisi = "You successfully clicked an alert";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualResultsYazisi.contains(expectedResultsYazisi));
        softAssert.assertAll();
    }
    @Test
    public void dismissAlert() {
        /*
        ● Bir metod olusturun: dismissAlert
            ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
            “successfully” icermedigini test edin.
         */
        WebElement jsConfrimButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfrimButton.click();

        driver.switchTo().alert().dismiss();
        String actualResultsYazi = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String exceptedResultsYazi = "successfully";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(actualResultsYazi.contains(exceptedResultsYazi));
        softAssert.assertAll();

    }
    @Test
    public void sendKeysAlert() {
        /*
        ● Bir metod olusturun: sendKeysAlert
            ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
            OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
         */
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptButton.click();
        driver.switchTo().alert().sendKeys("Kazim Nihat");
        driver.switchTo().alert().accept();

        String actualResultsYazi = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResultsYazi = "Kazim Nihat";
        Assert.assertTrue(actualResultsYazi.contains(expectedResultsYazi));

    }
}
