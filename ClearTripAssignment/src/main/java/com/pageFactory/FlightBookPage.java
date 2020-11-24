package com.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.generic.EnvSetUp;
import com.generic.Utilities;

public class FlightBookPage {
	Logger logger = Logger.getLogger(FlightBookPage.class);

	private EnvSetUp objEnvSetUp;

	public FlightBookPage(EnvSetUp envSetUp) {
		this.objEnvSetUp = envSetUp;
	}

	By email_Address = By.xpath("//input[@title='Your email address' or  @name='username']");
	By clickoncontinue = By.xpath("//input[@class='booking hotelButton']");
	By adultOneTitle = By.xpath("//select[@name='AdultTitle1']");
	By adultoneFirstName = By.xpath("//input[@name='AdultFname1']");
	By adultoneLastName = By.xpath("//input[@name=' AdultLname1']");
	By adultTwoTitle = By.xpath("//select[@name='AdultTitle2']");
	By adultTwoFirstName = By.xpath("//input[@name='AdultFname2']");
	By adultTwoLastName = By.xpath("//input[@name='AdultLname2']");
	By entermobileNumber = By.xpath("//input[@title='Mobile Number']");
	By clickOnTravelBtn = By.xpath("//input[@value='Continue'][@class='booking']");
	By clickNetBanking = By.xpath("//a[text()='Net Banking']");
	By clickRadioBtn = By.xpath("//span[text()='Kotak Bank']");
	By clickPayment = By.xpath("//input[@value='Make payment']");
	By kotakBankText = By.xpath("// img[@alt='Kotak']");

	public void enterEmailAddress() {
		WebElement emailAddress = objEnvSetUp.getDriver().findElement(email_Address);
		emailAddress.sendKeys(objEnvSetUp.objconfig.getProperty("Email_Address"));
		// emailAddress.sendKeys(emailid);
	}

	public void clickOnContinue() {
		objEnvSetUp.getDriver().findElement(clickoncontinue).click();

	}

	public void enterTitleAdultOne(String strtext) {
		WebElement titleOfAdultOne = objEnvSetUp.getDriver().findElement(adultOneTitle);
		titleOfAdultOne.click();
		Utilities.selectAdultsDropDown(titleOfAdultOne, strtext);
	}

	public void adultOneFirstName() {
		WebElement adultsOneFirstName = objEnvSetUp.getDriver().findElement(adultoneFirstName);
		adultsOneFirstName.sendKeys(objEnvSetUp.objconfig.getProperty("AdultFirstName1"));
	}

	public void adultOneLastName() {
		WebElement adultsOneLastName = objEnvSetUp.getDriver().findElement(adultoneLastName);
		adultsOneLastName.sendKeys(objEnvSetUp.objconfig.getProperty("AdultFirstName1"));
	}

	public void enterTitleAdultTwo(String strtext) {
		WebElement titleOfAdultTwo = objEnvSetUp.getDriver().findElement(adultTwoTitle);
		titleOfAdultTwo.click();
		Utilities.selectAdultsDropDown(titleOfAdultTwo, strtext);
	}

	public void adultTwoFirstName() {
		WebElement adultsTwoFirstName = objEnvSetUp.getDriver().findElement(adultTwoFirstName);
		adultsTwoFirstName.sendKeys(objEnvSetUp.objconfig.getProperty("AdultFirstName2"));
	}

	public void adultTwoLastName() {
		WebElement adultsTwoLastName = objEnvSetUp.getDriver().findElement(adultTwoLastName);
		adultsTwoLastName.sendKeys(objEnvSetUp.objconfig.getProperty("AdultLastName2"));
	}

	public void enterMobileNumber() {
		WebElement mobNumber = objEnvSetUp.getDriver().findElement(entermobileNumber);
		mobNumber.sendKeys(objEnvSetUp.objconfig.getProperty("MobileNumber"));
	}

	public void clickContinue() {
		objEnvSetUp.getDriver().findElement(clickOnTravelBtn).click();
	}

	public void clickOnNetBanking() {

		objEnvSetUp.getDriver().findElement(clickNetBanking).click();
	}

	public void selectRadiobuttonOfKotak() {

		objEnvSetUp.getDriver().findElement(clickRadioBtn).click();
	}

	public void clickOnMakePayment() {
		objEnvSetUp.getDriver().findElement(clickPayment).click();
	}

	public void verifyKotakTitle() {
		String strTitle = objEnvSetUp.getDriver().getTitle();
		String expTitle = "https://www.kotak.com/pmtgt/ksecLogin.jsp";
		Assert.assertEquals(strTitle, expTitle);
		logger.info("Kotak Bank>>>Make payment trough kotak bank");

	}

	public void verfyKotakText() {
		String strKotakText = objEnvSetUp.getDriver().findElement(kotakBankText).getText();
		Assert.assertEquals(strKotakText, "Kotak");
	}

}


















/*
 * //Action On Adduser public void addNewUser(String tcid1, String
 * adultsOneFirstName1, String adultsOneLastName1, String adultsTwoFirstName1,
 * String adultsTwoLastName1, String mobNumber1, String tcdescription1) { //,
 * String ExpMessage
 * 
 * adultOneFirstName(adultsOneFirstName1); adultOneLastName(adultsOneLastName1);
 * adultTwoFirstName(adultsTwoFirstName1); adultTwoLastName(adultsTwoLastName1);
 * enterMobileNumber(mobNumber1);
 * 
 * adultsOneFirstName.sendKeys(adultsOneFirstName1);
 * adultsOneLastName.sendKeys(adultsOneLastName1);
 * adultsTwoFirstName.sendKeys(adultsTwoFirstName2);
 * adultsTwoLastName.sendKeys(adultsTwoLastName1);
 * mobNumber.sendKeys(mobNumber1); System.out.println("test case id" + tcid1);
 * // String emailid, System.out.println("test case description" +
 * tcdescription1);
 * 
 * if (tcdescription.equals("register_valid")) {
 * Assert.assertEquals(objEnvSetup.getDriver().getTitle(), ExpMessage); } }
 */
