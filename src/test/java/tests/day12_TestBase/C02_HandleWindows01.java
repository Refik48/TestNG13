package tests.day12_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import java.util.Set;

public class C02_HandleWindows01 extends TestBaseClass {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe adresine gidelim
        // Elemantal selenium yazisina tiklayin
        // Yeni acilan penceredeki "Sponsored by Sauce Labs" yazisi locate edip yazdirin.

        driver.get("https://the-internet.herokuapp.com/iframe");

        // System.out.println(driver.getWindowHandle()); // Ilk sayfamizin window handle'i
        // System.out.println(driver.getWindowHandles()); // Colections seklinde liste icinde verdi.

        // Ben click yapmadan var olan (acik olan) window'un handle'ni alsam
        String ilkSayfaHandleDeger = driver.getWindowHandle();

        WebElement elemantalSeleniumYazisiWE = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        elemantalSeleniumYazisiWE.click();

        // click yaptiktan sonra tum handle degerlerini alsam
        Set<String> handleDegerleri = driver.getWindowHandles();
        // getWindowHandles() set donduruyor o yuzden set'e atiyorum.

        // elimizde icinde 2 handle degeri bulunan bir set var, bunlardan biri ilk sayfanin handle degeri
        // Ikinci sayfanin handle degerini nasil bulabilriim ?
        // Degerleri for dongusu ile getirecegim

        String ikinciSayfaHandleDegeri = "";
        for (String w : handleDegerleri) {
            if (!w.equals(ilkSayfaHandleDeger)) {
                // Eger ilk sayfa degerine esit degilse bu deger bizim acilan yeni sayfamizin degeridir.
                // Cunku bize acilan 2. sayfanin handle degeri lazim onu da String'e atiyorum.
                ikinciSayfaHandleDegeri = w;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri); // Bu sayfada 2. sayfaya gecmis yapmis oldum.


        // System.out.println(driver.getWindowHandle());
        // System.out.println(driver.getWindowHandles());
        // Click yaptiktan sonra 2 deger verdi.
        // Bu iki deger koseli deger icinde yani bir collection ama ne oldugunu anlayamayiz.
        // Ilk deger 1. sayfanin window handle'i, 2.si click ile acilanin.

        WebElement sauceLabsYazisiWE = driver.findElement(By.xpath("//a[text()='Sauce Labs']"));
        System.out.println(sauceLabsYazisiWE.getText());

    }
}
