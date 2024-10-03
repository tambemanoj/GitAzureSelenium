package com.tc_awc.functionaltestcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.pageobjects.addItem_Page;
import com.tc_awc.pageobjects.convertToBuildWIP_Page;
import com.tc_awc.pageobjects.folder_Page;
import com.tc_awc.pageobjects.home_Page;
import com.tc_awc.pageobjects.item_Page;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;
/*2.4 Test creation and test automation to test the ability to convert any WIP to any WIP revision 
 * 
 */
public class AWC_ConvertAnyWIPTOAnyBuildWIP extends TestBase {
	WebDriverWait wt;
	AWC_Login login = new AWC_Login();
	home_Page hp = new home_Page();
	folder_Page fp = new folder_Page();
	item_Page  ip = new item_Page();
	addItem_Page ap = new addItem_Page();
	convertToBuildWIP_Page cbp = new convertToBuildWIP_Page();
	String itemID;

	@Test(priority = 1, dataProvider = "getData")
	public void convertToBuildWIP_General(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void convertToBuildWIP_P0(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_P0WIP);

	}

	@Test(priority = 3, dataProvider = "getData")
	public void convertToBuildWIP_P1(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus__P1WIP);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void convertToBuildWIP_P2(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_P2WIP);

	}

	@Test(priority = 5, dataProvider = "getData")
	public void convertToBuildWIP_P3(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus__P3WIP);

	}

	@Test(priority = 6, dataProvider = "getData")
	public void convertToBuildWIP_EVT1(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_EVT1WIP);

	}

	@Test(priority = 7, dataProvider = "getData")
	public void convertToBuildWIP_EVT2(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_EVT2WIP);

	}

	@Test(priority = 8, dataProvider = "getData")
	public void convertToBuildWIP_EVT3(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_EVT3WIP);

	}

	@Test(priority = 9, dataProvider = "getData")
	public void convertToBuildWIP_DVT1(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_DVT1WIP);

	}

	@Test(priority = 10, dataProvider = "getData")
	public void convertToBuildWIP_DVT2(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_DVT2WIP);

	}

	@Test(priority = 11, dataProvider = "getData")
	public void convertToBuildWIP_DVT3(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_DVT3WIP);

	}

	@Test(priority = 12, dataProvider = "getData")
	public void convertToBuildWIP_PVT1(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_PVT1WIP);

	}

	@Test(priority = 13, dataProvider = "getData")
	public void convertToBuildWIP_PVT2(String itemStatus, String itemStatus_P0WIP, String itemStatus__P1WIP,
			String itemStatus_P2WIP, String itemStatus__P3WIP, String itemStatus_EVT1WIP, String itemStatus_EVT2WIP,
			String itemStatus_EVT3WIP, String itemStatus_DVT1WIP, String itemStatus_DVT2WIP, String itemStatus_DVT3WIP,
			String itemStatus_PVT1WIP, String itemStatus_PVT2WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		login.login();
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		ip.getconvertToBuild();
		cbp.converToAnyWIP(itemStatus_PVT2WIP);

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][13];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS1");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS2");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS3");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS4");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS5");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS6");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS7");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS8");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS9");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS10");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS11");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS12");
		data[0][12] = PropertiesOperations.getPropertyValueByKey("DATA_WIP_STATUS13");

		return data;
	}
}
