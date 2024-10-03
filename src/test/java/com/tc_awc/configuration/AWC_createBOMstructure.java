package com.tc_awc.configuration;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.functionaltestcases.AWC_Login;
import com.tc_awc.pageobjects.addItem_Page;
import com.tc_awc.pageobjects.content_Page;
import com.tc_awc.pageobjects.folder_Page;
import com.tc_awc.pageobjects.home_Page;
import com.tc_awc.pageobjects.item_Page;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class AWC_createBOMstructure extends TestBase{
	public WebDriverWait wt;
	home_Page hp = new home_Page();
	folder_Page fp = new folder_Page();
	item_Page  ip = new item_Page();
	addItem_Page ap = new addItem_Page();
	content_Page ct= new content_Page();
	String itemID;

	@Test(priority = 1, dataProvider = "getData")
	public void createBOMStructure(String itemID) throws Throwable {
		List<String> list=new ArrayList<String>(); 
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		fp.clickNew_Add();
		hp.search_item(itemID);		
		ip.clickContentOption();
		ct.add_child();
		int r=1;
		String childID1 =ap.addform(r);
		System.out.println("Print Child ID:" + childID1);
		list.add(childID1);
		Thread.sleep(1000L);
		ct.add_child();
		int r1=2;
		String childID2 =ap.addform(r1);
		Thread.sleep(1000L);
		list.add(childID2);
		ct.verify_BOM_Structure(list);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][1];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_createBOMstructure.First_WIP_Status");

		return data;
	}
}
