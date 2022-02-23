package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void click(WebElement webElement){
        try {
            webElement.click();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void click(By by){
        try {
            webDriver.findElement(by).click();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isDisplayed(WebElement webElement){
        try {
            return webElement.isDisplayed();
        }   catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isDisplayed(By by){
        try {
            return webDriver.findElement(by).isDisplayed();
        }   catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void sendKey(WebElement webElement, String key){
        try {
            webElement.sendKeys(key);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendKey(By by, String key){
        try {
            webDriver.findElement(by).sendKeys(key);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getText(WebElement webElement){
        try {
            return webElement.getText();
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getText(By by){
        try {
            return webDriver.findElement(by).getText();
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}