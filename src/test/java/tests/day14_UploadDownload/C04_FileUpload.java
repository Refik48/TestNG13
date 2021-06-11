package tests.day14_UploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import static org.testng.Assert.*;

public class C04_FileUpload extends TestBaseClass {
    /*
        1.https://the-internet.herokuapp.com/upload adresine gidelim
        2.chooseFile butonuna basalim
        3.Yuklemek istediginiz dosyayi secelim.
        4.Upload butonuna basalim.
        5.“File Uploaded!” textinin goruntulendigini test edelim.
     */
    @Test
    public void upload() throws InterruptedException {
        // 1) https://the-internet.herokuapp.com/upload sitesine gidiniz.
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2) chooseFile butonunu locate edin
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='file-upload']"));

        // 3) Yuklemek istediginiz dosyanin dosya yolunu kaydedelim.
        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\FLOWER.jpg";

        // 4) SendKeys ile dosyayi dosyasec butonuna yollayin
        chooseFileButton.sendKeys(dosyaYolu);

        Thread.sleep(5000);

        // 5) Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        // 6) “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYazisiElementi = driver.findElement(By.tagName("h3"));
        assertTrue(fileUploadedYazisiElementi.isDisplayed());
        assertTrue(fileUploadedYazisiElementi.getText().contains("File"));
        assertFalse(fileUploadedYazisiElementi.getText().contains("Nihat"));
        assertEquals(fileUploadedYazisiElementi.getText(),"File Uploaded");
        /*
         Birden fazla assert yapacaksak ;

         Basinda Assert. kismini siliyoruz sonra alt + enter yapiyoruz,
         import ediyoruz : import static org.testng.Assert.assertTrue;
         Eger ayni sayfada assertTrue,assertFalse,assertEquals yapilacak ise ,
            import kismina gidilir
            import org.testng.Assert; yazan kismi
            import org.testng.*; == ile update edilir

         Hard Assert'ler static oldugu icin olur. Static cunku.
         softAssert olmaz neden olmaz ? Cunku static degillerdir.
         */

    }
}
