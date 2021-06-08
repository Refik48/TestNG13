package tests.day13;

public class C98_GecenDersNoldu {
    /*
        1) TestBase Class : Her test icin gerekli olan ayarlamalari
        tekrar tekrar yapmak yerine before ve after methodlarini "utilities"
        class'i altindaki TestBase class'inda olusturuyoruz.

        - Testlerde ihtiyacimiz oldugunda yeniden obje olusturmakla ugrasmamak
        icin TestBase class'ina extends yaparak oradaki method'lari inherit ederiz.

        - TestBase class'i bizim test class'larimizin bulundugu package'da
        olmadigi icin TestBase'de olusturudgumuz driver'a ulasmak icin
        access modifier'ini protected yapariz.

        - TestBase class'indan obje olusturulmasini engellemek istersek class'i abstract yapariz.

        2) Windows Handle : Bir test sirasinda kullandigimiz bir link
        yeni sekmede acilirsa, acilan yeni sekmeye gecebilmek icin o
        sayfanin window handle degerine ihtiyacimiz var.
        a) Link'e tiklamadan once var olan window'un handle degerini
        alip string bir variable'a kaydederiz.
        b) Link'e tikladiktan sonra elimizde bulunan 2 sayfanin window handle
        degerlerini bir set icine koyariz.
        c) Foreach loop kullanarak set'teki her bir handle degerini alip
        ilk sayfanin handle degeri ile karsilastiririz, ilk sayfanin handle
        degerine esit olmayan ikinci sayfanin handle degeridir.
        d) Bu sekilde elde ettigimiz 2. sayfanin handle degerini kullanarak o sayfaya switch yapariz.
     */
}
