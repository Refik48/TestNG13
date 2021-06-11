package tests.day14_UploadDownload;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileDownload extends TestBaseClass {
    /*
        1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
        2. Iki tane metod oluşturun : isExistTesti() ve downloadTesti()
        3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
         - https://the-internet.herokuapp.com/download adresine gidelim.
         - code.txt dosyasını indirelim
        4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
     */
    @Test
    public void downloadTesti() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement codetxtClickButon = driver.findElement(By.xpath("//a[text()='code.txt']"));
        codetxtClickButon.click();
        Thread.sleep(5000);
        String codetxtDosyaPath = System.getProperty("user.home") + "\\Downloads\\code.txt";
        System.out.println(codetxtDosyaPath); // C:\Users\nihat\Downloads\code.txt
        Assert.assertTrue(Files.exists(Paths.get(codetxtDosyaPath)));
    }
    @Test
    public void isExistTesti() {

    }
}
