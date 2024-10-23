package com.assignment.facebook;


import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * Hello world!
 */
public class App {
	
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        
        
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://54.145.235.3:8081/contact.html");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        
        driver.findElement(By.name("your_name")).sendKeys("Amrita");
        driver.findElement(By.name("phone_number")).sendKeys("1234");
        driver.findElement(By.name("email_address")).sendKeys("Amrita@sharma.com");
        driver.findElement(By.name("your_message")).sendKeys("congratulations!");
        driver.findElement(By.id("my-button")).click();
   
        System.out.print(driver.findElement(By.id("response")).getText());
        
        TakesScreenshot shot = ((TakesScreenshot) driver);
        File sFile = shot.getScreenshotAs(OutputType.FILE);
        File fdest = new File("test.jpg");
        FileUtils.copyFile(sFile, fdest);
        driver.quit();
    }
}
