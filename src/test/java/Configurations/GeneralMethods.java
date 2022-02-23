package Configurations;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import static Configurations.TestListener.extentTestThreadLocal;

public class GeneralMethods {

    public static WebDriver webDriver;

    public static void pass(String details){

        if (Configuration.snapShot){
            try {
                extentTestThreadLocal.get().log(Status.PASS, details, MediaEntityBuilder.createScreenCaptureFromPath(takeSnapShot()).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            extentTestThreadLocal.get().log(Status.PASS, details);
        }
    }

    public static void info(String details){

        extentTestThreadLocal.get().log(Status.INFO, details);
    }

    public static String takeSnapShot() throws IOException {

        String simpleDate = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
        TakesScreenshot takesScreenshot = ((TakesScreenshot) webDriver);
        File fileScreenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String pathName = Configuration.reportPath + simpleDate  + ".png";
        File copyFile = new File(pathName);
        FileUtils.copyFile(fileScreenshot, copyFile);
        pathName = simpleDate + ".png";
        return pathName;
    }
}
