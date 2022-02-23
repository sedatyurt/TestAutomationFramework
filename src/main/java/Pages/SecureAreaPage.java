package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage{

    public SecureAreaPage(WebDriver webDriver) {
        super(webDriver);
    }

    By flashMessage  = By.id("flash");
    By pageHeader    = By.xpath("//i[@class='icon-lock']");
    By pageSubHeader = By.xpath("//h4[@class='subheader']");
    By logoutButton  = By.xpath("//a[@href='/logout']");

    public String getLoginMessage(){
        return getText(flashMessage);
    }

    public LoginPage beLogout(){
        click(logoutButton);
        return new LoginPage(webDriver);
    }
}
