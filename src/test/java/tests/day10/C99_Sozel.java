package tests.day10;

public class C99_Sozel {

    /*
        Assert ile SoftAssert Farki :

        - Assert fail oldugu anda calismayi durdurur ve kalanlarda islem yapmaz, sonuc ekranina yazdirmaz.

        - SoftAssert fail old. zaman calismaya devam eder.
            Kalanlarda isleme devam eder ve sonuc ekranina yazdirir.
            FAKAT failed bir adim var assertAll() method'una kadar calisir.

            assertAll() method'u gorundugunde softAssert test bitti olarak algilar ve durumu rapor eder.
            Tum testler pass olduysa calismaya devam eder,
            Testlerden 1 tanesi bile failed olursa assertAll() method'unda calismayi durdurur
            ve devamini calistirmaz
     */
}
