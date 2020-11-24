package com.scripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.generic.EnvSetUp;
import com.generic.ReadDataFromExcel;
import com.pageFactory.FlightBookPage;
import com.pageFactory.FlightDetailsPage;
import com.pageFactory.HomePage;

import com.pageFactory.SelectFlightPage;

public class ClearTripSearchFlightTest extends EnvSetUp {
	private HomePage objHomePage;
	private SelectFlightPage objSelectFlightPage;
	private FlightDetailsPage objFlightDetailsPage;
	private FlightBookPage objFlightBookPage;

	// private By drpLocator=By.id("month");

	@BeforeClass
	public void initialiseWebEnvironment() {
		objHomePage = new HomePage(this);
		objSelectFlightPage = new SelectFlightPage(this);
		objFlightDetailsPage = new FlightDetailsPage(this);
		objFlightBookPage = new FlightBookPage(this);
		initialiseWebEnv();
	}

	@Test
	public void TC_ID_01_SearchClearTripFlight() throws Exception {
		objHomePage.verifyClearTripTitle();
		objHomePage.clickOnFlight();
		objHomePage.selectRadioBtnRoundTrip();
		objHomePage.enterFromCity("Mumbai");
		objHomePage.enterToCity("Delhi");
		objHomePage.selectDepartOnDate();
		objHomePage.selectReturnOnDate();
		objHomePage.selectAdultDropdown("2");
		objHomePage.clickOnSearchFlight();
		objSelectFlightPage.selectNonStopFlight();
		objSelectFlightPage.departureIndigoFlight();
		objSelectFlightPage.ReturnGoAirFlight();
		objSelectFlightPage.clickOnBook();
		objFlightDetailsPage.clickontermsAndCondition();
		objFlightDetailsPage.clickonContinueBooking();
		objFlightBookPage.enterEmailAddress();
		objFlightBookPage.clickOnContinue();
		objFlightBookPage.enterTitleAdultOne("Mrs");
		objFlightBookPage.adultOneFirstName();
		objFlightBookPage.adultOneLastName();
		objFlightBookPage.enterTitleAdultTwo("Mrs");
		objFlightBookPage.adultTwoFirstName();
		objFlightBookPage.adultTwoLastName();
		objFlightBookPage.enterMobileNumber();
		objFlightBookPage.clickContinue();
		objFlightBookPage.clickOnNetBanking();
		objFlightBookPage.selectRadiobuttonOfKotak();
		objFlightBookPage.clickOnMakePayment();
		objFlightBookPage.verifyKotakTitle();

	}

	/*
	 * @DataProvider public Object[][] getDetailsOfTravelarTestData() throws
	 * Exception { Object data[][] = ReadDataFromExcel.getTestData(); // written in
	 * test util return data; }
	 * 
	 * @Test(priority = 4, dataProvider = "getDetailsOfTravelarTestData") //
	 * getFacebookWebsiteTestData method is provide // data public void
	 * AddNewUser(String tcid1, String adultsOneFirstName1, String
	 * adultsOneLastName1, String adultsTwoFirstName1, String adultsTwoLastName1,
	 * String mobNumber1, String tcdescription1) { // , String ExpMessage
	 * System.out.println("first " + tcid1); objFlightBookPage.addNewUser(tcid1,
	 * adultsOneFirstName1, adultsOneLastName1, adultsTwoFirstName1,
	 * adultsTwoLastName1, mobNumber1, tcdescription1);
	 * 
	 * }
	 */
}
