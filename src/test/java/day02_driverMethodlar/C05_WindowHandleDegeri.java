package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_WindowHandleDegeri {
    static  WebDriver driver;


    public static void main(String[] args) throws InterruptedException {
    System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");

        driver= new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println(driver.getWindowHandle());//CDwindow-75FFDB7023B80CC18B7B9A4F480B5B47
       // her sayfa için farklı bir handle değeri verir
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getWindowHandle());





        Thread.sleep(5000);
        driver.quit();
}}
