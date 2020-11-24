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

public class HomePage {
	Logger logger = Logger.getLogger(HomePage.class);

	private EnvSetUp objEnvSetUp;

	public HomePage(EnvSetUp envSetUp) {
		this.objEnvSetUp = envSetUp;
	}

	By webelementclickOnFlight = By.xpath("//a[text()='Flights']");
	By webelementclickOnRoundTrip = By.xpath("//strong[text()='Round trip']");
	By webelementFromCity = By.xpath("//input[@id='FromTag']");
	By webelementToCity = By.xpath("//input[@id='ToTag']");
	By webelementClickOnDepartDate = By.id("DepartDate");
	By webelementDepartDateCount = By.xpath("//div[contains(@class,'monthBlock first')]//td/a");
    By webelementClickOnReturnDate = By.xpath("//input[@title='Depart date']");
	By webElementReturnDateCount = By.xpath("//div[contains(@class,'monthBlock first')]//td/a");
	By webElemenSelecttadultDropdown = By.xpath("//select[@name='adults']");
	By webElementClickOnSerchBtn = By.xpath("//input[@value='Search flights']");

	public void verifyClearTripTitle() {
		String strTitle = objEnvSetUp.getDriver().getTitle();
		String expTitle = "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.";
		Assert.assertEquals(strTitle, expTitle);

		logger.info("Facebook loginpage>>>click on signup button");

	}

	public void clickOnFlight() {
		objEnvSetUp.getDriver().findElement(webelementclickOnFlight).click();

	}

	public void selectRadioBtnRoundTrip() {
		objEnvSetUp.getDriver().findElement(webelementclickOnRoundTrip).click();

		logger.info("click on redio button");
	}

	public void enterFromCity(String strFromCity) {
		objEnvSetUp.getDriver().findElement(webelementFromCity).sendKeys(strFromCity);
	}

	public void enterToCity(String strToCity) {
		objEnvSetUp.getDriver().findElement(webelementToCity).sendKeys(strToCity);

	}

	public void selectDepartOnDate() {

		objEnvSetUp.getDriver().findElement(webelementClickOnDepartDate).click();

		List<WebElement> departdatecount = objEnvSetUp.getDriver().findElements(webelementDepartDateCount);
		Utilities.pickDepartOnDate(departdatecount);
	}

	public void selectReturnOnDate() {
		objEnvSetUp.getDriver().findElement(webelementClickOnReturnDate).click();

		List<WebElement> returndatecount = objEnvSetUp.getDriver().findElements(webElementReturnDateCount);

		Utilities.pickReturnOnDate(returndatecount);

	}

	public void selectAdultDropdown(String strindex) {
		WebElement adult_element = objEnvSetUp.getDriver().findElement(webElemenSelecttadultDropdown);
		Utilities.selectAdultsDropDown(adult_element, strindex);
	}

	public void clickOnSearchFlight() {
		objEnvSetUp.getDriver().findElement(webElementClickOnSerchBtn).click();
		   Utilities.handle_Window(objEnvSetUp.getDriver());
	}

}
