package tests.day13;

public class C99_Sozel {
    /*
        Actions Class :
        - Fare ve klavye eylemlerini gerçekleştirmek için Actions class’ı kullanmamız gerekir.

        - Actions Class birçok kullanışlı fare ve klavye işlevine sahiptir.

        - Cift tıklama (double click), surukleme ve birakma (drag and drop), fareyi hareket ettirme
        (mouse actions) gibi karmasik fare eylemleri icin veya Keyword ile yapabilecegimiz
        pageUp,pageDown,shift,arrowDown gibi islemleri Actions classindan object ureterek
        yapariz.

        Action yapmak icin 3 adim vardir :
        1) Actions class'ta bir object olusturulur.
            Actions actions= new Actions(driver);
        2) Uzerinde calismak istediginiz WebElement ogesini barindirir.
            WebElement element = driver.findElement(By.id("ID"));
        3) Ardından bu webelement üzerinde action gerçekleştirilir. Ornegin sag tiklamak icin.
            actions.contextClick(element).perform();
            NOT : Eger sonunda perform() yazilmazsa kod calismaz.

        Action ceistleri :
        1) doubleClick() : Ogeye cift tiklamak icin
        2) clickAndHold() : Fareyi serbest birakmadan uzun tiklama yapar.
        3) dragAndDrop() : Ogeyi bir noktadan digerine surukler ve birakir.
        4) moveToElement() : Fare isaretcisini ogenin ortasina kaydirir.
        5) contextClick() : Fare uzerinde sag click yapar.

        Klavye aksiyonlari ile klavyedeki tuslari control edebiliriz.
        Bunun icin 3 tane aksiyon kullaniriz.

        1) sendKeys (): Öğeye bir dizi anahtar gönderir
        2) keyDown (): Klavyede tusa basma islemi gerceklestirir
        3) keyUp (): Klavyede tusu serbest birakma islemi gerceklestirir

     */
}
