package generic;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements iAutoconstant {
public  static WebDriver driver;
	
    static {
    	System.setProperty(CHROME_KEY, GECKO_VALUE);
    	System.setProperty(CHROME_KEY, CHROME_VALUE);
    }	
	
	@BeforeMethod
	public void openApplication() {
		WebDriver driver =new FirefoxDriver();
		String url= LiB.getProperty(CONFIG_PATH,"URL");
		driver.get("url");
		String ITO = LiB.getProperty(CONFIG_PATH, "ImplicitTimeOut");
		int timeoutperiod =Integer.parseInt(ITO);

		driver.manage().timeouts().implicitlyWait(timeoutperiod, TimeUnit.SECONDS);

	}

	@AfterMethod

	public void closeApplication() {
		driver.close();
	}

	public void takeScreenshot(String testname) {
		Date d = new Date();
		String currentdate = d.toString().replaceAll(":","_");
		
		TakesScreenshot cs = (TakesScreenshot) driver;
		File srcFile = cs.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(".\\AutomationsPhotos\\"+currentdate+"\\"+testname+"_screenshot.png");
		try {
			FileUtils.copyFile(srcFile, destFile);

		} catch (IOException e) {

			e.printStackTrace();
		}



	}


}
