package com.tc_awc.negativetestcases;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.functionaltestcases.AWC_Login;
import com.tc_awc.pageobjects.addItem_Page;
import com.tc_awc.pageobjects.convertToBuildWIP_Page;
import com.tc_awc.pageobjects.folder_Page;
import com.tc_awc.pageobjects.home_Page;
import com.tc_awc.pageobjects.item_Page;
import com.tc_awc.pageobjects.saveAs_Form;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

/*
*3.2.Test creation and test automation to test the ability to convert WIP to WIP
*Ex:P0 WIP-->First WIP Status(Bydefault 1st revision will be added)
2. P1 WIP-->Second WIP Status (Second revision should be added)
3. P1 WIP-->Convert WIP Status (Error should be display for Convert WIP )
*/
public class AWC_ConvertToBuildWIP extends TestBase{
	public WebDriverWait wt;
	home_Page hp = new home_Page();
	folder_Page fp=new folder_Page();
	item_Page  ip = new item_Page();
	addItem_Page ap=new addItem_Page();
	saveAs_Form saf =new saveAs_Form();
	convertToBuildWIP_Page cbw = new convertToBuildWIP_Page();
	String itemID;

	@Test(priority =1,dataProvider = "getDataSet1")
	public void convertToBuildWIP_P0WIP(String itemStatus_PWIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		String newReleaseStatus = hp.return_search_item(itemStatus_PWIP);
		System.out.println("newReleaseStatus: " + newReleaseStatus);
		ip.clicknewItem_saveAs();
		saf.save_as(newReleaseStatus);
		cbw.ConvertToWIP(newReleaseStatus);		
	}
	
	@Test(priority =2, dataProvider = "getDataSet2")
	public void convertToBuildWIP_EVTWIP(String itemStatus_EVTWIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		String newReleaseStatus = hp.return_search_item(itemStatus_EVTWIP);
		System.out.println("newReleaseStatus: " + newReleaseStatus);
		ip.clicknewItem_saveAs();
		saf.save_as(newReleaseStatus);
		cbw.ConvertToWIP(newReleaseStatus);		
	}
	
	@Test(priority =3, dataProvider = "getDataSet3")
	public void convertToBuildWIP_DVTWIP(String itemStatus_DVTWIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		String newReleaseStatus = hp.return_search_item(itemStatus_DVTWIP);
		System.out.println("newReleaseStatus: " + newReleaseStatus);
		ip.clicknewItem_saveAs();
		saf.save_as(newReleaseStatus);
		cbw.ConvertToWIP(newReleaseStatus);		
	}
	
	@Test(priority =4, dataProvider = "getDataSet4")
	public void convertToBuildWIP_PVTWIP(String itemStatus_PVTWIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		String newReleaseStatus = hp.return_search_item(itemStatus_PVTWIP);
		System.out.println("newReleaseStatus: " + newReleaseStatus);
		ip.clicknewItem_saveAs();
		saf.save_as(newReleaseStatus);
		cbw.ConvertToWIP(newReleaseStatus);
	}
	
	@DataProvider
	public Object[][] getDataSet1() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_ConvertToBuildWIP.SET1.DATA_FIRST_WIP_STATUS");  
		return data;
	}
	
	@DataProvider
	public Object[][] getDataSet2() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_ConvertToBuildWIP.SET2.DATA_FIRST_WIP_STATUS");  
		return data;
	}
	
	@DataProvider
	public Object[][] getDataSet3() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_ConvertToBuildWIP.SET3.DATA_FIRST_WIP_STATUS");  
		return data;
	}
	
	@DataProvider
	public Object[][] getDataSet4() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_ConvertToBuildWIP.SET4.DATA_FIRST_WIP_STATUS");  
		return data;
	}
}
