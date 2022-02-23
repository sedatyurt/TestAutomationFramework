package Scenarios;

import Configurations.Configuration;
import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LoginTest2 extends Configuration {

    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @Test
    public void positiveLoginTest(){
        loginPage = new LoginPage(webDriver);
        secureAreaPage = loginPage.beLogin(Configuration.username, Configuration.password);
        pass("Username and Password filled correctly, Login clicked");
        AssertJUnit.assertTrue(secureAreaPage.getLoginMessage().contains("You logged into a secure area!"));
        pass("Login message checked");
    }

    @Test
    public void logoutTest(){
        loginPage = new LoginPage(webDriver);
        secureAreaPage = loginPage.beLogin(Configuration.username, Configuration.password);
        pass("Successful login");

        loginPage = secureAreaPage.beLogout();
        AssertJUnit.assertTrue(loginPage.getLogoutMessage().contains("You logged out of the secure area!"));
        pass("Successful logout");

    }
}
