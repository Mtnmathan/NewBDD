package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class BasePage {
	
	static WebDriver driver;
	
	public BasePage(WebDriver driver) {
        this.driver = driver;
    }
	
	 public static String captureScreenshot(WebDriver driver, String screenshotName) {
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
	            File finalDestination = new File(destination);
	            FileUtils.copyFile(source, finalDestination);
	            return destination;
	        } catch (IOException e) {
	            System.out.println("Exception while taking screenshot: " + e.getMessage());
	            return null;
	        }
	    }
		
	public static String getURL(String url) throws IOException {
		driver.get(url);
		return url;
	}
	
	public static void maximizePage() {
		driver.manage().window().maximize();
	}

	public static void impWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void clickMethod(WebElement btn) {
		btn.click();
	}
}