package tests.day12_TestBase;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseClass;

import java.util.Set;

public class C03_HandleWindows02 extends TestBaseClass {

    @Test
    public void test01() {
        /*
        https://the-internet.herokuapp.com/windows adresine gidin.
        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Click Here butonuna basın.
        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Sayfadaki textin “New Window” olduğunu doğrulayın.
        Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
       */

        driver.get("https://the-internet.herokuapp.com/windows");
        SoftAssert softAssert = new SoftAssert();

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingYazisiWE = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String actualOpeningYazisi = openingYazisiWE.getText();
        String expectedOpeningYazisi = "Opening a new window";
        softAssert.assertEquals(actualOpeningYazisi,expectedOpeningYazisi);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String sayfaTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        softAssert.assertEquals(sayfaTitle,expectedTitle);

        // Click Here butonuna basın.
        String ilkSayfaHandle = driver.getWindowHandle();
        WebElement clickHere = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        clickHere.click();

        Set<String> sayfaHandleleri = driver.getWindowHandles();

        String ikinciSayfaHandle = "";
        for (String w : sayfaHandleleri) {
            if (!w.equals(ilkSayfaHandle)) {
                ikinciSayfaHandle = w;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualYeniSayfaTitle = driver.getTitle();
        String expectedYeniSayfaTitle = "New Window";
        softAssert.assertEquals(actualYeniSayfaTitle,expectedYeniSayfaTitle);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement sayfaTextiWE = driver.findElement(By.tagName("h3"));
        String actualSayfaTexti = sayfaTextiWE.getText();
        String expectedSayfaTexti = "New Window";
        softAssert.assertEquals(actualSayfaTexti,expectedSayfaTexti);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);
        String ilkSayfaTitle = driver.getTitle();
        String expectedIlkSayfaTitle = "New Window";
        softAssert.assertEquals(ilkSayfaTitle,expectedIlkSayfaTitle);

        softAssert.assertAll();
    }
}
