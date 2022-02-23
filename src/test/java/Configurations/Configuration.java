package Configurations;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class Configuration extends GeneralMethods{

    public static String url = "http://the-internet.herokuapp.com/login";
    public static String username = "tomsmith";
    public static String password = "SuperSecretPassword!";
    public static String reportPath = "target/reports/";
    public static String documentTitle = "DocumentTitle";
    public static String reportName = "ReportName";
    public static boolean snapShot = true;

    @Parameters({ "browser" })
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser){

        switch (browser) {
            case "chrome" -> {
                System.out.println("Starting with Chrome Driver.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                webDriver = new ChromeDriver();
            }
            case "firefox" -> {
                System.out.println("Starting with Firefox Driver.");
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                webDriver = new FirefoxDriver();
            }
            default -> {
                System.out.println("Driver not undefined! Starting with Chrome Driver.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                webDriver = new ChromeDriver();
            }
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
