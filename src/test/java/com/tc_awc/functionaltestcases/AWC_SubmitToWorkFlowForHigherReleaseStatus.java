package com.tc_awc.functionaltestcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.pageobjects.folder_Page;
import com.tc_awc.pageobjects.home_Page;
import com.tc_awc.pageobjects.wokflow_Page;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;
//#2.5 Test creation and test automation to test the ability to Submit the Workflow
//(Should be able to release the Lower Release status for Higher WIP Status
//ex: P0 WIP Status should be release in P0 Status
//    P0 WIP Status should be release in P1 Status ......)

public class AWC_SubmitToWorkFlowForHigherReleaseStatus extends TestBase {
	public WebDriverWait wt;
	home_Page hp = new home_Page();
	folder_Page fp = new folder_Page();
	wokflow_Page wp = new wokflow_Page();

	
	@Test(priority = 1, dataProvider = "getDataSet1")
	public void submitToWorkFlowForHigherReleaseStatus_P0WIP(String itemStatus_P0WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		
		int k=1;
		do {
		Thread.sleep(3000L);
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_P0WIP);
		wp.clickOn_submitToWorkflow();
		String a = wp.getNextP0(k);
		System.out.println("A :"+ a);
		wp.submitToWorkflowP0(a);
		Thread.sleep(3000L);
		k++;
		}while(k<=4);
	}
	
	@Test(priority = 2, dataProvider = "getDataSet2")
	public void submitToWorkFlowForHigherReleaseStatus_EVT1WIP(String itemStatus_EVT1WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		
		int k=1;
		do {
		Thread.sleep(3000L);
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_EVT1WIP);
		wp.clickOn_submitToWorkflow();
		String a = wp.getNextEVT1(k);
		System.out.println("A :"+ a);
		wp.submitToWorkflowEVT1(a);
		Thread.sleep(3000L);
		k++;
		}while(k<=3);
	}
	
	@Test(priority = 3, dataProvider = "getDataSet3")
	public void submitToWorkFlowForHigherReleaseStatus_DVT1WIP(String itemStatus_DVT1WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		
		int k=1;
		do {
		Thread.sleep(3000L);
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_DVT1WIP);
		wp.clickOn_submitToWorkflow();
		String a = wp.getNextDVT1(k);
		System.out.println("A :"+ a);
		wp.submitToWorkflowDVT1(a);
		Thread.sleep(3000L);
		k++;
		}while(k<=3);
	}
	
	@Test(priority = 4, dataProvider = "getDataSet4")
	public void submitToWorkFlowForHigherReleaseStatus_PVT1WIP(String itemStatus_PVT1WIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		
		int k=1;
		do {
		Thread.sleep(3000L);
		hp.clickFolder();
		fp.clickNew_Add();
		hp.search_item(itemStatus_PVT1WIP);
		wp.clickOn_submitToWorkflow();
		String a = wp.getNextPVT1(k);
		System.out.println("A :"+ a);
		wp.submitToWorkflowPVT1(a);
		Thread.sleep(3000L);
		k++;
		}while(k<=2);
	}
	
	@DataProvider
	public Object[][] getDataSet1() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_SubmitToWorkFlowForHigherReleaseStatus.SET1.DATA_FIRST_WIP_STATUS");
		return data;
	}
	@DataProvider
	public Object[][] getDataSet2() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_SubmitToWorkFlowForHigherReleaseStatus.SET2.DATA_FIRST_WIP_STATUS");
		return data;
	}@DataProvider
	public Object[][] getDataSet3() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_SubmitToWorkFlowForHigherReleaseStatus.SET3.DATA_FIRST_WIP_STATUS");
		return data;
	}@DataProvider
	public Object[][] getDataSet4() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_SubmitToWorkFlowForHigherReleaseStatus.SET4.DATA_FIRST_WIP_STATUS");
		return data;
	}
}
