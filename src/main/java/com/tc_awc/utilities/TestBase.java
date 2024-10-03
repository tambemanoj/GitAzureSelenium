
package com.tc_awc.utilities;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.listeners.ActionEngine;



public class TestBase extends ActionEngine {
	BrowserFactory bf = new BrowserFactory();

	@BeforeMethod
	public void LaunchApplication() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));

		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		DriverFactory.getInstance().getDriver().navigate().to(url);

	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}
}
