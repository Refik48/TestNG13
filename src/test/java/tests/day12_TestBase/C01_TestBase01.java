package tests.day12_TestBase;

import org.testng.annotations.Test;
import utilities.TestBaseMethod;

public class C01_TestBase01 extends TestBaseMethod {

    /*
        Before ve After'lari artik TestBase olarak baska class'da tanimladik.
        Her seferinde bunlari her class'a yazmaya gerek kalmadi.
        Ama kullanilabilmesi icin parent-child iliskisi kuralmasi gerekir.
        3 farkli yontem vardir, biz TestBase'ler icin exteds tercih ediyoruz.
     */
    @Test
    public void test01() { // TestBase icin extends tercih ediyoruz.

        driver.get("http://youtube.com");


    }
}
