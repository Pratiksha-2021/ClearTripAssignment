package com.generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.pageFactory.FlightBookPage;

public class Utilities {
	static Logger logger = Logger.getLogger(Utilities.class);

	private EnvSetUp objEnvSetUp;

	public Utilities(EnvSetUp envSetUp) {
		this.objEnvSetUp = envSetUp;

	}

	public static void pickDepartOnDate(List<WebElement> departDateCount) {

		int dateCountSize = departDateCount.size();

		LocalDate currentdate = LocalDate.now();
		int currentDay = currentdate.getDayOfMonth();

		System.out.println("Current day: " + currentDay + 5);
		logger.info("Current day: " + currentDay + 5);
		for (int i = 0; i <= dateCountSize; i++) {
			String dateValue = departDateCount.get(i).getText();

			if (dateValue.equals(String.valueOf((currentDay + 5)))) {
				departDateCount.get(i).click();
				break;
			}

		}
	}

	public static void pickReturnOnDate(List<WebElement> returnDateCount) {

		int DepartDateSize = returnDateCount.size();

		LocalDate currentdate = LocalDate.now();
		int currentDay = currentdate.getDayOfMonth();

		System.out.println("Current day: " + currentDay + 6);
		logger.info("Current day: " + currentDay + 6);

		for (int i = 0; i <= DepartDateSize; i++) {
			String datevalue = returnDateCount.get(i).getText();

			if (datevalue.equals(String.valueOf((currentDay + 6)))) {

				returnDateCount.get(i).click();

				break;
			}

		}

	}

	public static void selectAdultsDropDown(WebElement adult_Webelement, String strText) {
		Select select = new Select(adult_Webelement);
		select.selectByVisibleText(strText);

	}

	public static void chooseDepartureIndigoFlight(List<WebElement> indigoFlightcount) {
		int flightCountSize = indigoFlightcount.size();
		for (int i = 0; i < flightCountSize; i++) {
			String datevalue = indigoFlightcount.get(i).getText();
			indigoFlightcount.get(2).click();
		}
	}

	public static void chooseReturnGoAirFlight(List<WebElement> goAirFlightcount) {
		int flightCountSize = goAirFlightcount.size();
		for (int i = 0; i < flightCountSize; i++) {
			String datevalue = goAirFlightcount.get(i).getText();
			goAirFlightcount.get(2).click();

		}
	}

	public static String failed(WebDriver driver, String screenshotName) throws Exception {
		// below line is just to append the date format with the screenshot name
		// to avoid duplicate names
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		// Returns the captured file pathSS
		return destination;
	}

	public static void scrollDownPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}

	public static void handle_Window(WebDriver driver) {

		String parent = driver.getWindowHandle();
		System.out.println("Parent Window Id>>"+parent);

		Set<String> s = driver.getWindowHandles();
		System.out.println(" Window Id>>"+s);

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();
			System.out.println("child window>>>"+child_window);

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}

		}
	}
}
