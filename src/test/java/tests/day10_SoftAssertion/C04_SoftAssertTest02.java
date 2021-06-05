package tests.day10_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C04_SoftAssertTest02 {

    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown() {
        //driver.close();
    }
    /*
         1. “http://zero.webappsecurity.com/” Adresine gidin
         2. Sign in butonuna basin
         3. Login kutusuna “username” yazin
         4. Password kutusuna “password” yazin
         5. Sign in tusuna basin
         6. Pay Bills sayfasina gidin
         7. “Purchase Foreign Currency” tusuna basin
         8.
        */

    @Test
    public void test01() {
        driver.get("http://zero.webappsecurity.com/");
        WebElement signInButon = driver.findElement(By.xpath("//button[@id='signin_button']"));
        signInButon.click();

        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");

        WebElement pwBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        pwBox.sendKeys("password");

        WebElement keepMeSignInClick = driver.findElement(By.xpath("//input[@id='user_remember_me']"));
        keepMeSignInClick.click();

        WebElement signIn = driver.findElement(By.xpath("//input[@name='submit']"));
        signIn.click();

        WebElement gelismis = driver.findElement(By.xpath("//button[@id='details-button']"));
        gelismis.click();

        WebElement siteyeDevamEt = driver.findElement(By.xpath("//a[@id='proceed-link']"));
        siteyeDevamEt.click();

        WebElement transferFunds = driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
        transferFunds.click();

        WebElement fromAccount = driver.findElement(By.xpath("//select[@id='tf_fromAccountId']"));
        Select selectFromAccount = new Select(fromAccount);
        selectFromAccount.selectByValue("3");

        WebElement toAccount = driver.findElement(By.xpath("//select[@id='tf_toAccountId']"));
        Select selectToAccount = new Select(toAccount);
        selectToAccount.selectByValue("2");

        WebElement amountBox = driver.findElement(By.xpath("//input[@id='tf_amount']"));
        amountBox.sendKeys("500.2");

        WebElement descriptionBox = driver.findElement(By.xpath("//input[@id='tf_description']"));
        descriptionBox.sendKeys("For $500.2");

        WebElement continueBox = driver.findElement(By.xpath("//button[@id='btn_submit']"));
        continueBox.click();

        WebElement submitBox = driver.findElement(By.xpath("//button[@id='btn_submit']"));
        submitBox.click();

        WebElement onlineStatementsButon = driver.findElement(By.xpath("//a[text()='Online Statements']"));
        onlineStatementsButon.click();

        WebElement acilirListAccount = driver.findElement(By.xpath("//select[@id='os_accountId']"));
        Select select = new Select(acilirListAccount);
        List<WebElement> actualListWE = select.getOptions();
        List<String> expectedList = Arrays.asList("Savings",
                "Checking", "Savings", "Loan", "Credit Card", "Brokerage");
        List<String> actualList = new ArrayList<String>();
        for (WebElement w : actualListWE) {
            actualList.add(w.getText());
        }
        System.out.println(actualList);

        Assert.assertEquals(actualList,expectedList,"Listeler ayni degil");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualList,expectedList,"Listeler ayni degil");
        softAssert.assertAll();



        // "Saving", "Checking", "Savings", "Loan", "Credit Card", "Brokerage"

    }
}
