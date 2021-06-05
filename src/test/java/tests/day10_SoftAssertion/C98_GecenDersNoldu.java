package tests.day10_SoftAssertion;

public class C98_GecenDersNoldu {
    /*
        Priority : TestNG ile gelen bir yenilik, JUnit'te testler belli bir siraya gore calismaz ama
        testNG'de isim sirasina gore calisir. Eger alfabetik siralama disinda ozel bir siralama yapmak
        istersek priority ile test method'larini suralayabiliriz. Priority numarasi kucuk olan once calisir.
        Priority olmayan testler de varsa once onlar calisir, sonra priority olan testler kendi iclerinde
        siralanir.
        - Dropdown webelementilerini handle etmek icin 3 adim atmamiz gerekiyor.
            a) Dropdown'u locate etmek
            b) Locate ettigimiz webelementini parametre olarak kullanip select objesi olusturuyoruz.
            c) Select objesini kullanarak 3 yontemle istedigimiz option'i secebiliriz.
                1) index 2) value 3) visibleText

        - Dropdown webelementi genelde html tag olarak select secilir.
        - Eger tum opsiyonlari testimizde kullanmak istiyorsak Web elementlerden olusan bir liste
        olusturup opsiyonlari bu listeye kaydedebiliriz. Bu islem icin getOptions() method'u kullanilir.
        - Eger select objesi ile bir opsiyonu secersek, sectigimiz opsiyonu yazdirmak icin
        select.getFirstSelectedOption() method'u kullanilir.

        - TestNG ve JUnit kutuphanelerinin bir projede ayni zamanda kullanilmasi tavsiye edilmez.

     */
}
