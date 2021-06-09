package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

import javax.swing.*;

public class C03_MouseActions04 extends TestBaseMethod {

    /*
        1) facebook.com'a gidin
        2) Yeni hesap olustur butonuna tiklayin
        3) Ad, soyad, mail ve sifre kutularina deger yazalim
        4) Kaydol tusuna basalim
     */
    @Test
    public void test01() {
        // 1) facebook.com'a gidin
        driver.get("http://www.facebook.com");

        // 2) Yeni hesap olustur butonuna tiklayin
        WebElement kaydolButonu = driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']"));
        kaydolButonu.click();

        // 3) Ad, soyad, mail ve sifre kutularina deger yazalim
        Actions actions = new Actions(driver);
        WebElement isimKutusu = driver.findElement(By.name("firstname"));
        /*actions.click(isimKutusu).perform();
        actions.sendKeys("Kazim Nihat").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Te").perform();
        actions.sendKeys(Keys.TAB).perform();*/
        // Boyle uzun uzadiya yazmak yerine ;
        actions.
                click(isimKutusu).
                sendKeys("Kazim Nihat").
                sendKeys(Keys.TAB).
                sendKeys("Tek").
                sendKeys(Keys.TAB).
                sendKeys("xxxxgmailcom").
                sendKeys(Keys.TAB).
                sendKeys("xxxxgmailcom").
                sendKeys(Keys.TAB).
                sendKeys("sifre").
                perform();
        // Her seferinde action ve perform yazmak yerine aralarina bu sekilde yazabiliriz.
    }
}
