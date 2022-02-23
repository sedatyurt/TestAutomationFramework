package Scenarios;

import Configurations.Configuration;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LoginTest extends Configuration {

    @Test
    public void ilkTest(){

        webDriver.findElement(By.id("username")).sendKeys("tomsmith");
        webDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

        pass("Username and Password field, Login clicked");

        AssertJUnit.assertEquals("Welcome to the Secure Area. When you are done click logout below.", webDriver.findElement(By.xpath("//h4[@class='subheader']")).getText());

        pass("Subheader text checked");
    }

    @Test
    public void negativeLoginTest(){
        webDriver.findElement(By.id("username")).sendKeys("tomsmith");
        webDriver.findElement(By.id("password")).sendKeys("SuperSecretPasswo");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

        pass("Username and Password filled in wrong, Login clicked");

        AssertJUnit.assertTrue(webDriver.findElement(By.id("flash-messages")).getText().contains("Your password is invalid!"));

        pass("Warning message checked");

    }
}
