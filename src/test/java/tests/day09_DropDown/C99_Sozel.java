package tests.day09_DropDown;

public class C99_Sozel {
    /*
        Eger bazilarinda priority yazip bazinlarin da yazmadiysam ;
        1- PRIORITY YAZILMAYAN METHODLAR EN BASTA CALISIR, ALFABETIK SIRAYLA CALISIR.
        2- PRIORITY YAZILAN METHODLAR ISE ; VERILEN ONCELIK SIRASINA GORE CALISIR
        3- EGER HERHANGI BIR PRIORITY VERILMEDIYSE ALFABETIK SIRAYA GORE CALISIR.
     */
    /*
        Handle Dropdown :
        1) Dropdown menuyu herhangi bir locator ile locate edin.
            WebElement selectElement = driver.findElement(By.id("value of id"));
        2) Yeni bir "select" objesi olusturun ve daha once locate ettigimiz
        WebElement'i parameter olarak yeni objeye ekleyin.
            Select options = new Select(selectElement);
        3) Dropdown icin kullanilan 3 yontemden biriyle dropdown menusundeki
        elemanlardan istediginizi seciniz.
            options.SelectByIndex(1);

        - Dropdown menuleri her zaman <select> tag'i ile baslar.
        - Dropdown'u nasil handle edersin ?
            <select> tag'i ile
     */
    /*
        ASSERT ILE ILGILI OLARAK :
        JUnit'te once expected sonra actual yaziyorduk.
        TestNG'de ise once actual daha sonra expected yaziyor.
        Eger istersek bir virgul daha koyarak mesaj verebiliriz.
     */
}
