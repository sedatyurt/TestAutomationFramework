package Configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {

        String fileName = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + ".html";
        String path = Configuration.reportPath + fileName;

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);

        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle(Configuration.documentTitle);
        htmlReporter.config().setReportName(Configuration.reportName);

        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("OS", "macOS Monterey");
        extentReports.setSystemInfo("Version", "12.0.1");
        extentReports.setSystemInfo("Browser", "Google Chrome");
        extentReports.setSystemInfo("Browser Version", "97.0.4692.71");

        return extentReports;
    }
}
