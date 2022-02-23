package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    By flashMessage  = By.id("flash");
    By pageHeader    = By.xpath("//h2");
    By pageSubHeader = By.xpath("//h4[@class='subheader']");
    By usernameLabel = By.id("username");
    By passwordLabel = By.id("password");
    By loginButton   = By.xpath("//button[@type='submit']");

    public SecureAreaPage beLogin(String username, String password){
        sendKey(usernameLabel, username);
        sendKey(passwordLabel, password);
        click(loginButton);
        return new SecureAreaPage(webDriver);
    }

    public String getLogoutMessage(){
        return getText(flashMessage);
    }
}
