package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class C03_DriverMethodlari {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        System.out.println(driver.getPageSource());//sayfanın kodları

        String pageSource = driver.getPageSource();
        String expectedPageSource ="10000px";

        if (pageSource.contains(expectedPageSource)) {
            System.out.println("test pass");
        }else{
        System.out.println("test fail");


    }
        Thread.sleep(3000);
        driver.close();
    }



}
