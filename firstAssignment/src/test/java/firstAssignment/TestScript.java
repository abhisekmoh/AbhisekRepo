package firstAssignment;

import org.openqa.selenium.By;


public class TestScript extends Assignment1{


	public static void navigateToUrl(String url) {
		try {
			//"https://www.airbnb.co.in/"
			APPLICATION_LOGS.debug("Navigating to URL: "+ url);
			driver.navigate().to(url);
			APPLICATION_LOGS.debug("Successfully Navigated to the desired url");
		}
		catch(Exception e) {
			// Log error
			APPLICATION_LOGS.debug("Error came while navigating to the URL : " + e.getMessage());
		}
	}

	public static void getWebPageTitle() {
		try {

			String title = driver.getTitle();
			System.out.println("Title: "+title);
			APPLICATION_LOGS.debug("The Title of the Webpage is: "+title);
		}
		catch(Exception e) {
			// Log error
			APPLICATION_LOGS.debug("Error came while getting the title of the WebPage : " + e.getMessage());
		}
	}

	public static void handleCookies() {
		try {
			APPLICATION_LOGS.debug("##########  Executing test Case for handleing Cookies  ##########");
			String locatorCookiesButtonOK = "//*[text()='OK']";
			String locatorCookiesSaveSettings = "(//div[button[text()='Save Settings']])[2]";
			String nameCookiesButton = "Cookies OK Button";
			if(driver.findElement(By.xpath(locatorCookiesButtonOK)).isDisplayed()){
				FunctionLibrary.clickOnElement(By.xpath(locatorCookiesButtonOK), nameCookiesButton);
			}else {
				FunctionLibrary.clickOnElement(By.xpath(locatorCookiesSaveSettings), nameCookiesButton);
			}
			APPLICATION_LOGS.debug("------Passed : Test Case Execution for handleing Cookies------");

		}
		catch(Exception e) {
			APPLICATION_LOGS.debug("------Failed : Test Case Execution for handleing Cookies------"+ " Error Message: "+e.getMessage());
		}

	}

	public static void searchAndSelectExpressionsInSicily() {

		try {
			APPLICATION_LOGS.debug("##########  Executing test Case for Searching and Selecting Expressions In Sicily  ##########");

			String locatorSearchButton2 = "//button//*[text()='Search']";
			String nameSearchButton2 = "Search Button";
			String locatorLocationTextBox = "//input[@id='bigsearch-query-attached-query']";
			String nameLocationTextBox = "Location text Box";
			String locatorExperienceButton = "//*[text()='Experiences']";
			String nameExperienceButton = "Experiences Button";
			String locatorDateInput = "//*[text()='Add when you want to go']";
			String nameDateInput = "Date Input Box";
			String locatorRightArrowButtonInDatePicker = "//div[@class='_13tn83am']//span[@class='_e296pg']//*[local-name()='svg']";
			String nameRightArrowButtonInDatePicker = "Right Arrow button in Date Picker";
			String locator1stMonthDate = "(//td//*[text()='1'])[2]";
			String name1stMonthDate = "1st Month Date";
			String locator2ndMonthDate = "(//td//*[text()='1'])[2]";
			String name2ndMonthDate = "2nd Month Date";


			//Enter text in Location text Box
			FunctionLibrary.clickOnElement(By.xpath(locatorLocationTextBox), nameLocationTextBox);
			FunctionLibrary.input(By.xpath(locatorLocationTextBox), nameLocationTextBox, "Sicily, Italy");
			//Click on Experiences button
			FunctionLibrary.clickOnElement(By.xpath(locatorExperienceButton), nameExperienceButton);
			//click on date picker
			FunctionLibrary.clickOnElement(By.xpath(locatorDateInput), nameDateInput);
			//Click on Right Arrow button in Date Picker
			FunctionLibrary.clickOnElement(By.xpath(locatorRightArrowButtonInDatePicker), nameRightArrowButtonInDatePicker);
			//Click on the date of the 1st Month
			FunctionLibrary.clickOnElement(By.xpath(locator1stMonthDate), name1stMonthDate);
			//Click on Right Arrow button in Date Picker 2 times
			FunctionLibrary.clickOnElement(By.xpath(locatorRightArrowButtonInDatePicker), nameRightArrowButtonInDatePicker);
			FunctionLibrary.clickOnElement(By.xpath(locatorRightArrowButtonInDatePicker), nameRightArrowButtonInDatePicker);
			//Click on the date of the 2nd Month
			FunctionLibrary.clickOnElement(By.xpath(locator2ndMonthDate), name2ndMonthDate);
			//click on Search button
			FunctionLibrary.clickOnElement(By.xpath(locatorSearchButton2), nameSearchButton2);
			APPLICATION_LOGS.debug("------Passed : Test Case Execution for Searching and Selecting Expressions In Sicily------");

		}
		catch(Exception e) {
			APPLICATION_LOGS.debug("------Failed : Test Case Execution for Searching and Selecting Expressions In Sicily------"+ " Error Message: "+e.getMessage());
		}


	}

	public static void selectingGuests() {

		try {
			APPLICATION_LOGS.debug("##########  Executing test Case for Selecting Guests  ##########");

			String locatorGuestButton = "(//*[text()='Guests'])[1]";
			String nameGuestButton = "Guests Button";
			String locatorPlusbuttonforAdult = "//div[div[text()='Adults']]/following-sibling::div/button[2]";
			String namePlusButtonForAdult = "Plus button for adult";
			String locatorPlusbuttonforChild = "//div[div[text()='Children']]/following-sibling::div/button[2]";
			String namePlusButtonForChild = "Plus button for child";
			String locatorGuestSaveButton = "//button[@id='filter-panel-save-button']";
			String nameGuestSaveButton = "Guest Save Button";

			//Click on the Guests button.
			FunctionLibrary.clickOnElement(By.xpath(locatorGuestButton), nameGuestButton);
			//Click on the plus button for Adults.
			FunctionLibrary.clickOnElement(By.xpath(locatorPlusbuttonforAdult), namePlusButtonForAdult);
			//click on the plus button for Child.
			FunctionLibrary.clickOnElement(By.xpath(locatorPlusbuttonforChild), namePlusButtonForChild);
			//Click on the save button.
			FunctionLibrary.clickOnElement(By.xpath(locatorGuestSaveButton), nameGuestSaveButton);
			APPLICATION_LOGS.debug("------Passed : Test Case Execution for Selecting Guests------");

		}
		catch(Exception e) {
			APPLICATION_LOGS.debug("------Failed : Test Case Execution for Selecting Guests------"+ " Error Message: "+e.getMessage());
		}


	}

	public static void priceFilter()  {

		try {
			APPLICATION_LOGS.debug("##########  Executing test Case for setting Price Filter  ##########");

			String locatorPriceFilterButton = "//div[@id='menuItemButton-price_range']//button";
			String namePriceFilterButton = "Price Filter Button";
			String locatorMinPriceFilter = "//input[@id='price_filter_min']";
			String nameMinPriceFilter = "Min. Price Filter";
			String locatorMaxPriceFilter = "//input[@id='price_filter_max']";
			String nameMaxPriceFilter = "Max. Price Filter";
			String locatorPriceFilterSaveButton = "//button[@id='filter-panel-save-button']";
			String namePriceFilterSaveButton = "Price Filter Save Button";

			//Click on the Price Filter Button button.
			FunctionLibrary.clickOnElement(By.xpath(locatorPriceFilterButton), namePriceFilterButton);
			//Input the Max Price.
			FunctionLibrary.input(By.xpath(locatorMaxPriceFilter), nameMaxPriceFilter, "5000");
			//Input the Min Price.
			FunctionLibrary.input(By.xpath(locatorMinPriceFilter), nameMinPriceFilter, "2000");
			//Click on Save button
			FunctionLibrary.clickOnElement(By.xpath(locatorPriceFilterSaveButton), namePriceFilterSaveButton);
			APPLICATION_LOGS.debug("------Passed : Test Case Execution for setting Price Filter------");

		}
		catch(Exception e) {
			APPLICATION_LOGS.debug("------Failed : Test Case Execution for setting Price Filter------"+ " Error Message: "+e.getMessage());
		}

	}

	public static void navigateToFirstAndThirdResult() {

		try {
			APPLICATION_LOGS.debug("##########  Executing test Case for navigating to first and third search result  ##########");

			String locatorFirstResult = "(//div[@role='presentation']/a)[1]";
			String nameFirstResult = "Navigating to the First Result";
			String locatorThirdResult = "(//div[@role='presentation']/a)[3]";
			String nameThirdResult = "Navigating to the Third Result";

			//Click on First result.
			FunctionLibrary.clickOnElement(By.xpath(locatorFirstResult), nameFirstResult);
			//Switch to 1st Driver Window.
			driver.switchTo().defaultContent();
			//Click on Third result.
			FunctionLibrary.clickOnElement(By.xpath(locatorThirdResult), nameThirdResult);
			APPLICATION_LOGS.debug("------Passed : Test Case Execution for navigating to first and third search result------");

		}
		catch(Exception e) {
			APPLICATION_LOGS.debug("------Failed : Test Case Execution for navigating to first and third search result------"+ " Error Message: "+e.getMessage());
		}

	}

	public static void closeBrowser() {
		try {
			APPLICATION_LOGS.debug("##########  Closing Bowser Windows after Test Execution  ##########");
			driver.quit();
			APPLICATION_LOGS.debug("Closed Browser's Windows Successfully");
		}
		catch(Exception e) {
			APPLICATION_LOGS.debug("Failed to close Browser's Windows"+ " Error Message: "+e.getMessage());
		}
	}
}
