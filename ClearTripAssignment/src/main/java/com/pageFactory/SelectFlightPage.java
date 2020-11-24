package com.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.generic.EnvSetUp;
import com.generic.Utilities;

public class SelectFlightPage {
 Logger logger = Logger.getLogger(SelectFlightPage.class);

	private EnvSetUp objEnvSetUp;

	public SelectFlightPage(EnvSetUp envSetUp) {
		this.objEnvSetUp = envSetUp;
    }
	
	
	
	//By nonStopFlight = By.xpath("//p[text()='Stops']//following::div[3]");
    By nonStopFlight=By.xpath("//p[text()='Non-stop']/parent::div[@class='flex flex-start pl-2']/preceding::div[@class='flex flex-start p-relative flex-middle']");
	

	By goAirFlight=By.xpath("(//div[@data-test-attrib='onward-view'])//div[19]");
   // By goAirFlight=By.xpath("(//img[@alt ='SpiceJet'])[2]");
    By returnAirFlight=By.xpath("(//div[@data-test-attrib='return-view'])//div[16]");
	//By returnAirFlight=By.xpath("(//img[@alt ='GoAir'])[8]");
	By BookBtn=By.xpath("//button[text()='Book' or @class='flex flex-bottom flex-right']");

	
	
	public void selectNonStopFlight() {
	  //  Utilities.handle_Window(objEnvSetUp.getDriver());
		WebElement nonStopflight = objEnvSetUp.getDriver().findElement(nonStopFlight);
		WebDriverWait wait = new WebDriverWait(objEnvSetUp.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nonStopFlight));
		nonStopflight.click();
		System.out.println(">>>>"+1);
	}

	public void departureIndigoFlight() throws Exception {
		//   Utilities.handle_Window(objEnvSetUp.getDriver());
		objEnvSetUp.getDriver().findElement(goAirFlight).click();

		Thread.sleep(10000);

	}

	public void ReturnGoAirFlight() throws InterruptedException {
		objEnvSetUp.getDriver().findElement(returnAirFlight).click();
		Thread.sleep(10000);

	}

	public void clickOnBook() {

		objEnvSetUp.getDriver().findElement(BookBtn).click();

	}
}
