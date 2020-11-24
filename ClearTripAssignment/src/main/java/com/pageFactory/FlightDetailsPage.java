package com.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.generic.EnvSetUp;
import com.generic.Utilities;

public class FlightDetailsPage {

	Logger logger = Logger.getLogger(FlightDetailsPage.class);

	private EnvSetUp objEnvSetUp;

	public FlightDetailsPage(EnvSetUp envSetUp) {
		this.objEnvSetUp = envSetUp;

	}

	By clickOnContinue = By.xpath("//button[text()='Continue']");
    By clickOnTermsAndCondition = By.xpath("//input[@name='insuranceConfirm']");
	
	
	
	

	public void verifyClearTripTitle() {
		String strTitle = objEnvSetUp.getDriver().getTitle();
		String expTitle = "	Cleartrip | Book your flight securely in simple steps";
		Assert.assertEquals(strTitle, expTitle);
		logger.info("Facebook loginpage>>>click on signup button");

	}

	/*public void clickcontinue() {
		objEnvSetUp.getDriver().findElement(clickOnContinue).click();
	}*/
	

	public void clickontermsAndCondition() {
		
		Utilities.handle_Window(objEnvSetUp.getDriver());
		if (objEnvSetUp.getDriver().findElement(clickOnTermsAndCondition).isDisplayed()) {
			WebElement selectCheckboxTermsAndCondition = objEnvSetUp.getDriver().findElement(clickOnTermsAndCondition);
			WebDriverWait wait = new WebDriverWait(objEnvSetUp.getDriver(), 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnTermsAndCondition));
			selectCheckboxTermsAndCondition.click();
			
		}
		else {
			System.out.println("Terms and condition checkbox is not present");
		}
	}

	public void clickonContinueBooking() {
		objEnvSetUp.getDriver().findElement(clickOnContinue).click();

	}

}
