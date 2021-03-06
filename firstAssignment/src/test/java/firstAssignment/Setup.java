package firstAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup extends Assignment1{

	public static Properties CONFIG;
	public static Properties LOG;

	public static void logSetUp() {
		try {

			LOG = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"log4j.properties");
			LOG.load(fs);

			LOG.setProperty("log4j.appender.dest1.File",
					System.getProperty("user.dir") + File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"application.log");

			LOG.store(new FileOutputStream(System.getProperty("user.dir") + File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"log4j.properties"), null);
		}
		catch(Exception e) {
			// Log error
			APPLICATION_LOGS.debug("Error came while doing the Log setup : " + e.getMessage());
		}
	}

	public static void browserSetup(){
		try {
			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty("webdriver.chrome.driver",path+"\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			// Delete all browser cookies
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			APPLICATION_LOGS.debug("Browser Setup done for test execution.");
		}
		catch(Exception e) {
			// Log error
			APPLICATION_LOGS.debug("Error came while doing the browser setup : " + e.getMessage());
		}
	}

}
