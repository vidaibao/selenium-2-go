/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.vidaibao.swt.selenium;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Owner
 */
//App so sánh giá cả kakaku dùng công nghệ crawler cào data từ website
//selenium là 1 bộ thư viện tự động hóa nhiều công việc
//điều khiển browser từ cây data - web driver
public class Selenium2Go {

    public static void main(String[] args) {
        try {
            searchGoogle();
        } catch (InterruptedException ex) {
            Logger.getLogger(Selenium2Go.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void searchGoogleV2(){
        //1. declare pointer
        WebDriver myBrowser;//biến obj thuộc bộ thư viện Selenium
                            //thằng này sẽ trỏ đến cái trình duyệt khi đc new
                            //mỗi lần new là browser đc mở ra, 1 vùng ram đc cấp
                            //1 obj browser đc new trong HEAP
        //2. Khai báo ae song sinh, web driver. Version = browser đang xài                    
        //là file .exe/ .dll 
        String drivePath = "chromedriver.exe";
        
        //3. new Browser connect to web browser driver (chrome.exe <> chromedriver.exe)
        //báo với JVM rằng có thằng .exe muốn tham gia vào dsasch class mà JVM quản lý
        //xả nhiều class điều khiển browser into JVM lúc run-time
        //và gọi nhóm class này là webdriver.chrome.driver -> hằng số quy ước sẵn
        //code Selenium qua class Webdriver, Chromedriver sẽ dùng dưới đây
        //biết cách chơi với các class của .exe vì chúng đang ơ trong máy ảo
        System.setProperty("webdriver.chrome.driver", drivePath);
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito"); //duyet ẩn danh
        opt.addArguments("--lang=zh-cn"); //en-GB; vi; zh-cn
        myBrowser = new ChromeDriver(opt);
        
        //4. Coding Selenium talk to driver. 
        //Driver talk to newed browser
        //Browser will give all data (web in ram) in DOM (Document Object Model)
        //via driver.
        //trang HTML trả về trong RAM của browser đc xem là 1 cây các obj
        //node/tag đc xem là 1 obj thuộc nhóm web element
        myBrowser.get("https://google.com");//open Google page, default 1/2 screen
        //leak memory > free(pointer)                    
        //myBrowser.manage().window().maximize();
        
        
    }
    // ném lỗi ra thì phải xử lý ở trên hoặc chỗ nào đó
    //không làm gì thì giao OS giải quyết
    public static void searchGoogle() throws InterruptedException{
        //1. declare pointer
        WebDriver myBrowser;//biến obj thuộc bộ thư viện Selenium
                            //thằng này sẽ trỏ đến cái trình duyệt khi đc new
                            //mỗi lần new là browser đc mở ra, 1 vùng ram đc cấp
                            //1 obj browser đc new trong HEAP
        //2. Khai báo ae song sinh, web driver. Version = browser đang xài                    
        //là file .exe/ .dll 
        String drivePath = "chromedriver.exe";
        
        //3. new Browser connect to web browser driver (chrome.exe <> chromedriver.exe)
        //báo với JVM rằng có thằng .exe muốn tham gia vào dsasch class mà JVM quản lý
        //xả nhiều class điều khiển browser into JVM lúc run-time
        //và gọi nhóm class này là webdriver.chrome.driver -> hằng số quy ước sẵn
        //code Selenium qua class Webdriver, Chromedriver sẽ dùng dưới đây
        //biết cách chơi với các class của .exe vì chúng đang ơ trong máy ảo
        System.setProperty("webdriver.chrome.driver", drivePath);
        
        myBrowser = new ChromeDriver();
        
        //4. Coding Selenium talk to driver. 
        //Driver talk to newed browser
        //Browser will give all data (web in ram) in DOM (Document Object Model)
        //via driver.
        //trang HTML trả về trong RAM của browser đc xem là 1 cây các obj
        //node/tag đc xem là 1 obj thuộc nhóm web element
        myBrowser.get("https://google.com");//open Google page, default 1/2 screen
        //leak memory > free(pointer)                    
        myBrowser.manage().window().maximize();
        
        //ta sẽ đi tìm các thẻ/tag, và hành xử trên các tag. các tag này là obj
        //nằm trong obj bự là myBrowser (là field đặc tính của obj bự)
        WebElement searchBox = myBrowser.findElement(By.name("q"));
        //lấy đc ô search dưới dạng obj
        searchBox.sendKeys("gét gô");
        searchBox.submit();
        
        Thread.sleep(3000);//có nguy cơ gây lỗi tại đây do lệnh ngắt CPU
        
        myBrowser.quit();//or kill in TaskManager
    }
    
    
    
}
