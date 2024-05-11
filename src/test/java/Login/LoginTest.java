package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.ReadDataFromExcelFile;

public class LoginTest {
    @Test(dataProviderClass = ReadDataFromExcelFile.class,dataProvider = "testdata")
    public static  void LoginTest(String username,String password){

        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Form Authentication")).click();


        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        driver.quit();

    }
}
