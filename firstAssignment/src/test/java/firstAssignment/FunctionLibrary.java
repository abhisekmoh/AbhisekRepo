package firstAssignment;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class FunctionLibrary extends Assignment1{
	public static String screenshotPath = System.getProperty("user.dir") + File.separator+"ScreenShots"+File.separator;

	// highlight the element on which action will be performed
	public static void highlightElement(WebDriver driver, By Locator) {
		try {
			for (int i = 0; i < 3; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(Locator),
						"color: red; border: 2px solid red;");
			}
		}
		catch (Throwable t) {
			APPLICATION_LOGS.debug("Error came : " + t.getMessage());
		}
	}

	public static void clickOnElement(By locator, String elemName) {
		APPLICATION_LOGS.debug("Clicking on : " + elemName);
		try {
			// Wait for link to appear on the page
			waitForElementToLoad(locator);
			// Highlight link
			FunctionLibrary.highlightElement(driver, locator);
			// Click on the link
			driver.findElement(locator).click();
			// Log result
			APPLICATION_LOGS.debug("Clicked on : " + elemName);
		}

		catch (Throwable Exception) {
			try {
				APPLICATION_LOGS.debug("Webdriver click failed now trying through JS executor click");
				WebElement element= driver.findElement(locator);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
			}
			catch(Throwable clickLinkException) {
				// Log error
				APPLICATION_LOGS.debug("Error while clicking on - " + elemName + " : " + clickLinkException.getMessage());
				takeScreenShot(screenshotPath+elemName+"_Clickerror"+ ".jpg");
			}			
		}
	}

	public static void waitForElementToLoad(final By locator) {
		APPLICATION_LOGS.debug("Waiting for web element to load on the page");
		try {
			// Waits for 60 seconds
			Wait<WebDriver> wait = new WebDriverWait(driver, 30);
			// Wait until the element is located on the page
			@SuppressWarnings("unused")
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			//WebElement element = wait.until(visibilityOfElementLocated(locator));
			// Log result
			APPLICATION_LOGS.debug("Waiting ends ... Web element loaded on the page");
		}
		catch (Throwable waitForElementException) {
			// Log error
			APPLICATION_LOGS.debug("Error came while waiting for element to appear : " + waitForElementException.getMessage());
		}
	}

	public static void input(By locator, String elemName, String Value) {
		APPLICATION_LOGS.debug("Sending Values in : " + elemName);
		try {
			// Wait for the input box to appear on the page
			waitForElementToLoad(locator);
			// Highlight the input box
			FunctionLibrary.highlightElement(driver, locator);
			// Send values to the input box
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(Value);
			// Log result
			APPLICATION_LOGS.debug("Inputted '" + Value + "' text into : '" + elemName + "'");
		}
		catch (Throwable inputException) {
			// Log error
			APPLICATION_LOGS.debug("Error while inputting into - '" + elemName + "' : " + inputException.getMessage());
			takeScreenShot(screenshotPath+elemName+"_inputError"+ ".jpg");
		}
	}

	public static void scrollIntoView(By locator, String Element) {
		try {
			APPLICATION_LOGS.debug("Scrolling into View for : " + Element);
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
		catch(Exception e) {
			APPLICATION_LOGS.debug("Error while scrolling into view for - " + Element + " : " + e.getMessage());
		}
	}
	// Capture screenshot and store
	public static void takeScreenShot(String filePath) {

		File scrFile = null;
		try {
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Store screenshot to the path provided
			FileUtils.copyFile(scrFile, new File(filePath));

		}

		catch (Exception e) {

			// Log error
			APPLICATION_LOGS.debug("Error while taking screenshot : " + e.getMessage());
			System.err.println("Error while taking screenshot : " + e.getMessage());

		}

	}
}
