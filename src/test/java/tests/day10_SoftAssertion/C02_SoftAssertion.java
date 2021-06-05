package tests.day10_SoftAssertion;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C02_SoftAssertion {
    /*
        "Selenium ogrenmek cok zevkli" cumlesinde asagidaki testleri yapiniz
        1) Cumle "ogrenmek" iceriyor.
        2) Cumle "Java" icermiyor.
        3) Cumle 4 kelimeden olusuyor.
        4) Cumledeki karakter sayisi 25.
     */

    WebDriver driver;
    String cumle = "String ogrenmek cok zevkli";

    @Test
    public void hardAssertion() {
        Assert.assertTrue(cumle.contains("ogrenmek"));
        System.out.println("1");

        Assert.assertFalse(cumle.contains("Java"));
        System.out.println("2");

        String kelimeler [] = cumle.split(" ");
        Assert.assertEquals(kelimeler.length,4);
        System.out.println("3");

        String karakterler [] = cumle.split("");
        Assert.assertEquals(karakterler.length,25);
        System.out.println("4");
    }

    @Test
    public void softAssertionTesti() {
        // 1) Once bir obje olusturmaliyiz.
        SoftAssert softAssert = new SoftAssert();

        // 3) Olusturdugumuz obje uzerinden gidiyoruz.
        softAssert.assertTrue(cumle.contains("ogrenmek"));
        System.out.println("1");

        softAssert.assertFalse(cumle.contains("Java"));
        System.out.println("2");

        String kelimeler [] = cumle.split(" ");
        softAssert.assertEquals(kelimeler.length,4,"Kelime sayisi testi failed");
        System.out.println("3");

        String karakterler [] = cumle.split("");
        softAssert.assertEquals(karakterler.length,25, "Karakter sayisi testi failed");
        System.out.println("4");

        // 2) En alta direkt bunu yaziyoruz unutmamak icin. Bu olmazsa raporlama olmaz.
        softAssert.assertAll();
        // Bunu yazmazsak, hatayi anlamamiz imkansiz. Her seyi pass gosteriyor ve acıklamada yok.

        System.out.println("Bu yazi konsolda cikacak mi ? assertAll method'un altina yazdik.");
        // Cikmadi cunku ; Yapilan soft assertlerden 1 tanesi bile failed olursa bu satirda execution durur.

    }


}
