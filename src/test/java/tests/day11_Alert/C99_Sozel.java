package tests.day11_Alert;

public class C99_Sozel {
    /*
        Alert Nedir ?
        - Alert kullaniciya

        - Alert aldigimizda alert'in HTML Alert mu yoksa JS Alert mu oldugunu anlamamiz gerekmektedir.
        HTML ALert'u ise uyari penceresine sag click yapinca incele diyebiliyoruz.
        JS Alert'unde incele secenegi cikmaz.

        - JS Alert'unun 3 cesidi vardir.
        Alert sayfada acildiginda inceleme yapilamaz ve biz alert'u handle edene kadar bekler.
        1) Sadece "Tamam" secenegine tiklanabilen.
        2) JS Alert'unde "Tamam" veya "Iptal" butonu cikan.
        Tamam'a tiklarsak arkada baska bir kod calisir.
        Iptal'e basarsak bambaska bir kod calisir.
        3) Icerisine yazi yazilan bir kutucuk ile alert veren.
        Burada iptal'e basarsak null deger gonderir ve o calisir, uyari verebilir bos girilemeyecegine dair.
        Eger yazi kutucuguna deger girersek girdigimiz degere gore kodu yapilandirir.

        - Handle Allert Merhods
        4 yontemi vardir.
        1) accept() => Bir uyarida (alert) OK'i tiklamakla aynidir.
            driver.switchTo().alert.accept();
        2) dismiss() => Bir uyarida (alert) Cancel'a tiklamakla aynidir.
            driver.switchTo().alert.dismiss();
        3) getText() => Uyaridaki (alert) mesaji almak icin.
            driver.switchTo().alert.getText();
        4) sendKeys("Text") => Uyari (Alert) text kutusuna text gondermek icin kullanilir.
            driver.switchTo().alert.sendKeys("Text");

        Iframe Nedir ?
        - IFrame, bir web sayfasina icine yerlestirilmis baska bir web sayfasidir veya bir HTML
        dokumaninin icine yerlestirilmis baska bir HTML dokumanidir.
        - IFrame genellikle bir web sayfasina dokuman, video veya interaktif media gibi baska bir
        kaynaktan icerik eklemek icin kullanilir. <iframe> tag'i bir "inline frame" belirtir.

        Handle Iframe :
        - Bir sayfada iframe varsa, selenium bir iframe icindeki elementleri dogrudan goremez.
        - Switching to iframe : iframe'i gecmenin 3 yolu vardir ;
        1) index ile
            driver.switchTo().frame(index of the iframe); //index start from 0
        2) id veya name value ile
            driver.switchTo().frame("id of the iframe");
        3) WebElement ile
            driver.switchTo().frame(WebElement of the iframe);

        Iframe’den cikmak icin :
        - driver.switchTo().parentFrame(); 1 ust seviyedeki frame’e cikartir
        - driver.switchTo().defaultContent(); En ustteki frame’e cikmak icin kullanilir
        - Birden fazla iframe varsa gecislerde dikkatli olmak lazim.
        - Gecisler her zaman basit olamayabilir

        Neden iframe'den cikiyoruz ?
        - Cunku switchTo() ile girdiysek cikmamizda gerekmektedir. Bir onceki sayfaya donmek gibi.
     */
}
