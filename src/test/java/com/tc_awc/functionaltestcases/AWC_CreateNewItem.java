package com.tc_awc.functionaltestcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tc_awc.pageobjects.addItem_Page;
import com.tc_awc.pageobjects.folder_Page;
import com.tc_awc.pageobjects.home_Page;
import com.tc_awc.pageobjects.item_Page;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

//1.4

public class AWC_CreateNewItem extends TestBase{
	
	public WebDriverWait wt;
	home_Page hp=new home_Page();
	folder_Page fp=new folder_Page();
	addItem_Page ap=new addItem_Page();
	item_Page  ip = new item_Page();
	
	@Test
	public void createNewItem() throws Throwable {
		wt=new WebDriverWait(DriverFactory.getInstance().getDriver(),Duration.ofSeconds(30));
		AWC_Login login=new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickFolder();
		fp.clickNew_Add();
		ap.addItem();
		
	}
}
