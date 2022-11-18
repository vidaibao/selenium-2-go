/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.vidaibao.swt.selenium.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Owner
 */
public class Guru99Test {

    private static final String DRIVER_PATH = "chromedriver.exe";
    private static final String TARGET_WEBSITE = "https://demo.guru99.com/v4/";
    private static WebDriver myBrowser;
    //private static String drivePath = "chromedriver.exe";

    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito"); //mở Chrome ở chế độ ẩn danh

        myBrowser = new ChromeDriver(opt);
        //myBrowser = new ChromeDriver();//nếu cần option thì ChromeOptions

        myBrowser.manage().window().maximize();
    }

    @Test
    public void testLoginGivenRightAccountSayHelloUserName() throws InterruptedException {

        String userName = "mngr455426";
        String pass = "utaqedy";
        //String expectedMsg = "Manger Id : mngr455426";

        myBrowser.get(TARGET_WEBSITE);//
        //tìm thẻ username ^ pass qua
        //CSS Selector, JQuery, xPath, name, id, class...

        //WebElement userIDBox = myBrowser.findElement(By.name("uid"));
        WebElement userIDBox = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        //if OK     exception??
        userIDBox.sendKeys(userName);

        //WebElement passBox = myBrowser.findElement(By.name("password"));
        WebElement passBox = myBrowser.findElement(
                By.cssSelector("input[name='password']"));
        passBox.sendKeys(pass);

        WebElement btnLogin = myBrowser.findElement(
                By.name("btnLogin"));
        //WebElement btnLogin = myBrowser.findElement(By.tagName("input"));
        btnLogin.click();

        //async when browser render new page >> HAVE TO WAIT 4Sync
        Thread.sleep(3000);//

        //td[normalize-space()='Manger Id : mngr455426']
        WebElement helloTag = myBrowser.findElement(
                By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
        //System.out.println("Msg when successful login: " +"" );

        String helloActual = helloTag.getText();

        assertEquals("Manger Id : " + userName, helloActual);

        Thread.sleep(3000);//
    }

    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit();
    }

}
