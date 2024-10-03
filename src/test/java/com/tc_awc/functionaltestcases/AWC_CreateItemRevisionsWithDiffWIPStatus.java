package com.tc_awc.functionaltestcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.pageobjects.addItem_Page;
import com.tc_awc.pageobjects.folder_Page;
import com.tc_awc.pageobjects.home_Page;
import com.tc_awc.pageobjects.item_Page;
import com.tc_awc.pageobjects.saveAs_Form;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;
/*#2.2 Test creation and test automation to test the ability to work on multiple WIP revisions simultaneously
 * Set1
1. P0 WIP-->First WIP Status (By default 1st revision will be added)
2. P1 WIP-->Second WIP Status (Second revision should be added)
3. P2 WIP-->Third WIP Status (Error should be display for 3rd revision)
 */

public class AWC_CreateItemRevisionsWithDiffWIPStatus extends TestBase {
	public WebDriverWait wt;
	home_Page hp = new home_Page();
	folder_Page fp = new folder_Page();
	item_Page  ip = new item_Page();
	addItem_Page ap = new addItem_Page();
	saveAs_Form saf = new saveAs_Form();
	String itemID;

	@Test(priority = 1, dataProvider = "getDataSet1")
	public void createItemRevisionsWithDiffWIPStatus_P0WIP(String itemStatus_P0WIP, String itemStatus__P1WIP, String itemStatus_P2WIP)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		String newReleaseStatus = hp.return_search_item(itemStatus_P0WIP);
		System.out.println("newReleaseStatus: " + newReleaseStatus);
		ip.clicknewItem_saveAs();
		saf.save_as(newReleaseStatus);
		Thread.sleep(2000L);
		ip.clicknewItem_saveAs();
		newReleaseStatus = saf.getNextReleaseStatus(newReleaseStatus);
		saf.save_as(newReleaseStatus);
		Thread.sleep(2000L);
		saf.AssertMessage();
	}

	@Test(priority = 2, dataProvider = "getDataSet2")
	public void createItemRevisionsWithDiffWIPStatus_EVTWIP(String itemStatus_P0WIP, String itemStatus__P1WIP, String itemStatus_P2WIP)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		String newReleaseStatus = hp.return_search_item(itemStatus_P0WIP);
		System.out.println("newReleaseStatus: " + newReleaseStatus);
		ip.clicknewItem_saveAs();
		saf.save_as(newReleaseStatus);
		Thread.sleep(2000L);
		ip.clicknewItem_saveAs();
		newReleaseStatus = saf.getNextReleaseStatus(newReleaseStatus);
		saf.save_as(newReleaseStatus);
		Thread.sleep(2000L);
		saf.AssertMessage();
	}

	@Test(priority = 3, dataProvider = "getDataSet3")
	public void createItemRevisionsWithDiffWIPStatus_DVTWIP(String itemStatus_P0WIP, String itemStatus__P1WIP, String itemStatus_P2WIP)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		String newReleaseStatus = hp.return_search_item(itemStatus_P0WIP);
		System.out.println("newReleaseStatus: " + newReleaseStatus);
		ip.clicknewItem_saveAs();
		saf.save_as(newReleaseStatus);
		Thread.sleep(2000L);
		ip.clicknewItem_saveAs();
		newReleaseStatus = saf.getNextReleaseStatus(newReleaseStatus);
		saf.save_as(newReleaseStatus);
		Thread.sleep(2000L);
		saf.AssertMessage();
	}

	@Test(priority = 4, dataProvider = "getDataSet4")
	public void createItemRevisionsWithDiffWIPStatus_PVTWIP(String itemStatus_P0WIP, String itemStatus__P1WIP, String itemStatus_P2WIP)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		String newReleaseStatus = hp.return_search_item(itemStatus_P0WIP);
		System.out.println("newReleaseStatus: " + newReleaseStatus);
		ip.clicknewItem_saveAs();
		saf.save_as(newReleaseStatus);
		Thread.sleep(2000L);
		ip.clicknewItem_saveAs();
		newReleaseStatus = saf.getNextReleaseStatus(newReleaseStatus);
		saf.save_as(newReleaseStatus);
		Thread.sleep(2000L);
		saf.AssertMessage();
	}

	@DataProvider
	public Object[][] getDataSet1() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET1.DATA_FIRST_WIP_STATUS");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET1.DATA_SECOND_WIP_STATUS");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET1.DATA_THIRD_WIP_STATUS");
		return data;
	}

	@DataProvider
	public Object[][] getDataSet2() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET2.DATA_FIRST_WIP_STATUS");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET2.DATA_SECOND_WIP_STATUS");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET2.DATA_THIRD_WIP_STATUS");
		return data;
	}

	@DataProvider
	public Object[][] getDataSet3() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET3.DATA_FIRST_WIP_STATUS");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET3.DATA_SECOND_WIP_STATUS");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET3.DATA_THIRD_WIP_STATUS");

		return data;
	}

	@DataProvider
	public Object[][] getDataSet4() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET4.DATA_FIRST_WIP_STATUS");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET4.DATA_SECOND_WIP_STATUS");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_CreateItemRevisionsWithDiffWIPStatus.SET4.DATA_THIRD_WIP_STATUS");

		return data;
	}

}
