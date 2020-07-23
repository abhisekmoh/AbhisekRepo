package firstAssignment;
//${user.dir}\\src\\test\\java\\application.log

import java.io.File;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;


public class Assignment1 {
	public static WebDriver driver = null;
	public static Logger APPLICATION_LOGS = Logger.getLogger("Debugger");
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Setup.logSetUp();
		
		Setup.browserSetup();
		
		TestScript.navigateToUrl("https://www.airbnb.co.in/");
		
		TestScript.getWebPageTitle();
		
		TestScript.handleCookies();
		
		TestScript.searchAndSelectExpressionsInSicily();
		
		TestScript.selectingGuests();
		
		TestScript.priceFilter();
		
		TestScript.navigateToFirstAndThirdResult();
		
		//TestScript.closeBrowser();

	}

}
