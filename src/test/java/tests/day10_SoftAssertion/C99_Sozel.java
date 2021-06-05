package tests.day10_SoftAssertion;

public class C99_Sozel {

    /*
        Assert ile SoftAssert Farki :

        - Assert fail oldugu anda calismayi durdurur ve kalanlarda islem yapmaz, sonuc ekranina yazdirmaz.

        - SoftAssert fail old. zaman calismaya devam eder.
            Kalanlarda isleme devam eder ve sonuc ekranina yazdirir.
            FAKAT failed bir adim var assertAll() method'una kadar calisir.

            assertAll() method'u gorundugunde softAssert test bitti olarak algilar ve durumu rapor eder.
            Tum testler pass olduysa assertAll()'dan sonraki kodlar icin calismaya devam eder,
            Testlerden 1 tanesi bile failed olursa assertAll() method'unda calismayi durdurur
            ve devamini calistirmaz.
     */
    /*
        SoftAssert :
        1) Once bir obje olusturmaliyiz.
            SoftAssert softAssert = new SoftAssert();
        2) En alta direkt bunu yaziyoruz unutmamak icin. Bu olmazsa raporlama olmaz.
            softAssert.assertAll();
        3) Olusturdugumuz obje uzerinden gidiyoruz.
            softAssert.assertTrue(cumle.contains("ogrenmek"));
     */
}
