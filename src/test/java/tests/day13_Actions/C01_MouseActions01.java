package tests.day13_Actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

import java.util.Set;

public class C01_MouseActions01 extends TestBaseMethod {
    /*
        1 - https://the-internet.herokuapp.com/context_menu sitesine gidelim
        2 - Cizili alan uzerinde sag click yapalim
        3 - Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        4 - Tamam diyerek alert’I kapatalim
        5 - Elemental Selenium linkine tiklayalim
        6 - Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test01() {
        // 1 - https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 2 - Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver); // driver yazmak onemli
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot")); // Sag click yerinin path'i
        actions.contextClick(cizgiliAlan).perform(); // actions islemim (perform() olmazsa calismaz)

        // 3 - Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String alertYazisi = driver.switchTo().alert().getText();
        String expectedYazi = "You selected a context menu";
        Assert.assertEquals(alertYazisi,expectedYazi);

        // 4 - Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
            // tamam icin accept, iptal veya esc islemi icin dismiss
        // context click yapinca


        // 5 - Elemental Selenium linkine tiklayalim
        String ilksayfaHandleDegeri = driver.getWindowHandle();
        WebElement elementalLinki = driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(elementalLinki).perform();
        // elementalLinki.click(); // Bu ikisi ayni islemi yapiyor, ikisiyle olur.

        // 6 - Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> handleKumesi = driver.getWindowHandles();
        // Kume sirali olarak getirmek zorunda degil,
        // index olarak alirsak yanlis degeri alabilir ve hata alabiliriz.

        String ikinciSayfaHandleDegeri = "";
        for (String w : handleKumesi) {
            if (!w.equals(ilksayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri = w;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        String actualIkinciSayfaTitle = driver.getTitle();
        String expectedIkinciSayfaTitle = "Elemental Selenium";
        Assert.assertTrue(actualIkinciSayfaTitle.contains(expectedIkinciSayfaTitle));

    }
}
