package com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvSetUp {
	private WebDriver driver;
	public Properties objconfig;

	public void initialiseWebEnv() {
		loadConfigurationfile();

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver87.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		System.out.println("open url>>>>" + objconfig.getProperty("AUT_URL"));
		driver.get(objconfig.getProperty("AUT_URL"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;

	}

	public void loadConfigurationfile() {
		try {
			objconfig = new Properties();
			objconfig.load(
					new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
