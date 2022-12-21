package day02_driverMethodlar;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class C02_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("maximize window boyutları: "+driver.manage().window().getSize());

        Thread.sleep(3000);


        driver.manage().window().fullscreen();
        System.out.println("fullscreen window Boyutları: "+driver.manage().window().getSize());
        System.out.println("fullscreen window Boyutları: "+driver.manage().window().getPosition());
Thread.sleep(5000);
        // browser i istediğmiz konuma ve boyuta getirelim
        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(300,300));



        Thread.sleep(5000);
        driver.close();

    }
}
