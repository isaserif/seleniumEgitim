package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        //Biz browser leri oluşturduğumuz driver sayesinde otomate edebiliyoruz
        // Bunun için her testin basında mutlaka driver objesi oluşturacağız.
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        String expectedKelime="Amazon.com. Spend less. Smile more.";
        String actualResault=driver.getTitle();

        if (actualResault.contains(expectedKelime)){
            System.out.println("title testi pass");
        }else {
            System.out.println("title testi field");
        }

        //soru gittiğimiz sayfanın url inin https://www.amazon.com/ olduğunu test edin

        String expectedUrl = "https://www.amazon.com/";
        String actualUrl =driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)){
            System.out.println("url testi pass");
        }else{
            System.out.println("url testi field");
        }
        System.out.println(driver.getCurrentUrl());



Thread.sleep(5000);
driver.close();

    }

}
