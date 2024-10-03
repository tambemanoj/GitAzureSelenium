package com.tc_awc.configuration;

import java.time.Duration;

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

public class AWC_revisionRule extends TestBase {
	public WebDriverWait wt;
	home_Page hp = new home_Page();
	folder_Page fp = new folder_Page();
	item_Page ip = new item_Page();
	addItem_Page ap = new addItem_Page();
	content_Page ct = new content_Page();
	String itemID;
	
//	RevRule Test For P0 WIP
   @Test(priority = 1, dataProvider = "getDataForP0WIP")
	public void applyRevRule_P0WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID, revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_P0WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3);
		ct.checking_icon();

	}
	
	 
	
	//RevRule Test For P0 RELEASED
//	 @Test(priority = 2, dataProvider = "getDataForP0RELEASED")
	public void applyRevRule_P0RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_P0RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();

	}
	//RevRule Test For P1 WIP
//	@Test(priority = 3, dataProvider = "getDataForP1WIP")
		public void applyRevRule_P1WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5)
			throws Throwable {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID ,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_P1WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5);
		ct.checking_icon();

	}

	//RevRule Test For P1 RELEASED
//	 @Test(priority = 4, dataProvider = "getDataForP1RELEASED")
	public void applyRevRule_P1RELEASED(String revRule, String ReleaseStatusExpected1, String  ReleaseStatusExpected2) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_P1RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
	}
	
	//RevRule Test For P2 WIP
//	@Test(priority = 5, dataProvider = "getDataForP2WIP")
	public void applyRevRule_P2WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,String ReleaseStatusExpected6,String ReleaseStatusExpected7)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_P2WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7);
		ct.checking_icon();
	}
	
	//RevRule Test For P2 RELEASED
//	 @Test(priority = 6, dataProvider = "getDataForP2RELEASED")
	public void applyRevRule_P2RELEASED(String revRule, String ReleaseStatusExpected1, String  ReleaseStatusExpected2) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_P2RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
	}
	 
	//RevRule Test For P3 WIP
//	@Test(priority = 7, dataProvider = "getDataForP3WIP")
	public void applyRevRule_P3WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,String ReleaseStatusExpected6, String ReleaseStatusExpected7,String ReleaseStatusExpected8,
			String ReleaseStatusExpected9)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_P3WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9);
		ct.checking_icon();
		
	}
	
	//RevRule Test For P3 RELEASED
//	@Test(priority = 8, dataProvider = "getDataForP3RELEASED")
	public void applyRevRule_P3RELEASED(String revRule, String ReleaseStatusExpected1, String  ReleaseStatusExpected2) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_P3RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
	}
	
	
	//RevRule Test For PVT1 WIP
	@Test(priority = 9, dataProvider = "getDataForPVT1WIP")
	public void applyRevisionRulePVT1WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17,
			String ReleaseStatusExpected18, String ReleaseStatusExpected19, String ReleaseStatusExpected20,
			String ReleaseStatusExpected21, String ReleaseStatusExpected22, String ReleaseStatusExpected23) throws Throwable {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID, revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_PVT1WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9, ReleaseStatusExpected10, ReleaseStatusExpected11,
				ReleaseStatusExpected12, ReleaseStatusExpected13, ReleaseStatusExpected14, ReleaseStatusExpected15,
				ReleaseStatusExpected16, ReleaseStatusExpected17, ReleaseStatusExpected18, ReleaseStatusExpected19,
				ReleaseStatusExpected20, ReleaseStatusExpected21, ReleaseStatusExpected22, ReleaseStatusExpected23);
		ct.checking_icon();
	}
	
	//RevRule Test For PVT1 RELEASED
//	@Test(priority = 10, dataProvider = "getDataForPVT1RELEASED")
	public void applyRevisionRule_PVT1RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_PVT1RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
		
	}
	
	//RevRule Test For PVT2 WIP
	@Test(priority = 11, dataProvider = "getDataForPVT2WIP")
	public void applyRevisionRulePVT2WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17,
			String ReleaseStatusExpected18, String ReleaseStatusExpected19, String ReleaseStatusExpected20,
			String ReleaseStatusExpected21, String ReleaseStatusExpected22, String ReleaseStatusExpected23,
			String ReleaseStatusExpected24, String ReleaseStatusExpected25) throws Throwable {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_PVT2WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9, ReleaseStatusExpected10, ReleaseStatusExpected11,
				ReleaseStatusExpected12, ReleaseStatusExpected13, ReleaseStatusExpected14, ReleaseStatusExpected15,
				ReleaseStatusExpected16, ReleaseStatusExpected17, ReleaseStatusExpected18, ReleaseStatusExpected19,
				ReleaseStatusExpected20, ReleaseStatusExpected21, ReleaseStatusExpected22, ReleaseStatusExpected23,
				ReleaseStatusExpected24, ReleaseStatusExpected25);
		ct.checking_icon();
	}
	
	//RevRule Test For PVT2 RELEASED
	@Test(priority = 12, dataProvider = "getDataForPVT2RELEASED")
	public void applyRevisionRule_PVT2RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_PVT2RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
		
	}
	
	//RevRule Test For DVT1 WIP
//	@Test(priority = 13, dataProvider = "getDataForDVT1WIP")
	public void applyRevisionRule_DVT1WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_DVT1WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9, ReleaseStatusExpected10, ReleaseStatusExpected11,
				ReleaseStatusExpected12, ReleaseStatusExpected13, ReleaseStatusExpected14, ReleaseStatusExpected15,
				ReleaseStatusExpected16, ReleaseStatusExpected17);
		ct.checking_icon();
	}
	
	//RevRule Test For DVT1 RELEASED
//	@Test(priority = 14, dataProvider = "getDataForDVT1RELEASED")
	public void applyRevisionRule_DVT1RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_DVT1RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
		
	}
	
	//RevRule Test For DVT2 WIP
//	@Test(priority = 15, dataProvider = "getDataForDVT2WIP")
	public void applyRevisionRuleDVT2WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17,
			String ReleaseStatusExpected18, String ReleaseStatusExpected19) throws Throwable {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_DVT2WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9, ReleaseStatusExpected10, ReleaseStatusExpected11,
				ReleaseStatusExpected12, ReleaseStatusExpected13, ReleaseStatusExpected14, ReleaseStatusExpected15,
				ReleaseStatusExpected16, ReleaseStatusExpected17, ReleaseStatusExpected18, ReleaseStatusExpected19);
		ct.checking_icon();
	}
	
	//RevRule Test For DVT2 RELEASED
//	@Test(priority = 16, dataProvider = "getDataForDVT2RELEASED")
	public void applyRevisionRule_DVT2RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_DVT2RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
		
	}
	
	//RevRule Test For DVT3 WIP
//	@Test(priority = 17, dataProvider = "getDataForDVT3WIP")
	public void applyRevisionRuleDVT3WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17,
			String ReleaseStatusExpected18, String ReleaseStatusExpected19, String ReleaseStatusExpected20,
			String ReleaseStatusExpected21) throws Throwable {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_DVT3WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9, ReleaseStatusExpected10, ReleaseStatusExpected11,
				ReleaseStatusExpected12, ReleaseStatusExpected13, ReleaseStatusExpected14, ReleaseStatusExpected15,
				ReleaseStatusExpected16, ReleaseStatusExpected17, ReleaseStatusExpected18, ReleaseStatusExpected19,
				ReleaseStatusExpected20, ReleaseStatusExpected21);
		ct.checking_icon();
	}
	
	//RevRule Test For DVT3 RELEASED
//	@Test(priority = 18, dataProvider = "getDataForDVT3RELEASED")
	public void applyRevisionRule_DVT3RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_DVT3RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
		
	}
	
	//RevRule Test For EVT1 WIP
//	@Test(priority = 19, dataProvider = "getDataForEVT1WIP")
	public void applyRevisionRuleEVT1WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11) throws Throwable {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_EVT1WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9, ReleaseStatusExpected10, ReleaseStatusExpected11);
		ct.checking_icon();
	}
	
	//RevRule Test For EVT1 RELEASED
//	@Test(priority = 20, dataProvider = "getDataForEVT1RELEASED")
	public void applyRevisionRule_EVT1RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_EVT1RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
		
	}
	//RevRule Test For EVT2 WIP
//	@Test(priority = 21, dataProvider = "getDataForEVT2WIP")
	public void applyRevisionRuleEVT2WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13) throws Throwable {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_EVT2WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9, ReleaseStatusExpected10, ReleaseStatusExpected11,
				ReleaseStatusExpected12, ReleaseStatusExpected13);
		ct.checking_icon();
	}
	
	//RevRule Test For EVT2 RELEASED
//	@Test(priority = 22, dataProvider = "getDataForEVT2RELEASED")
	public void applyRevisionRule_EVT2RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_EVT2RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
		
	}
	
	//RevRule Test For EVT3 WIP
//	@Test(priority = 23, dataProvider = "getDataForEVT3WIP")
	public void applyRevisionRuleEVT3WIP(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15) throws Throwable {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_EVT3WIP(ReleaseStatusExpected1, ReleaseStatusExpected2, ReleaseStatusExpected3,
				ReleaseStatusExpected4, ReleaseStatusExpected5, ReleaseStatusExpected6, ReleaseStatusExpected7,
				ReleaseStatusExpected8, ReleaseStatusExpected9, ReleaseStatusExpected10, ReleaseStatusExpected11,
				ReleaseStatusExpected12, ReleaseStatusExpected13, ReleaseStatusExpected14, ReleaseStatusExpected15);
		ct.checking_icon();
	}
	
	//RevRule Test For EVT3 RELEASED
//	@Test(priority = 24, dataProvider = "getDataForEVT3RELEASED")
	public void applyRevisionRule_EVT3RELEASED(String revRule, String ReleaseStatusExpected1, String ReleaseStatusExpected2)
			throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_EVT3RELEASED(ReleaseStatusExpected1, ReleaseStatusExpected2);
		ct.checking_icon();
		
	}
	
	//RevRule Test For MP RELEASED
//	@Test(priority = 25, dataProvider = "getDataForMPRELEASED")
	public void applyRevisionRuleMP_RELEASED(String revRule, String ReleaseStatusExpected1) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.clickBOMRevRule();
		hp.search_itemId(itemID,revRule);
		ip.clickContentOption();
		ct.BOM_ContentRevisionRuleSearch(revRule);
		ct.getItemRel();
		ct.verify_MPRELEASED(ReleaseStatusExpected1);
		ct.checking_icon();
	}
	
	//---DATA SETS
	@DataProvider
	public Object[][] getDataForP0WIP() {
		Object[][] data = new Object[1][4];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0WIP_Revision_ReleaseStatus_3");
		return data;
	}
	@DataProvider
	public Object[][] getDataForP0RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForP1WIP() {
		Object[][] data = new Object[1][6];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1WIP_Revision_ReleaseStatus_5");
		return data;
	}

	@DataProvider
	public Object[][] getDataForP1RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForP2WIP() {
		Object[][] data = new Object[1][8];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_Revision_ReleaseStatus_7");
		
		
		return data;
	}
	@DataProvider
	public Object[][] getDataForP2RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForP3WIP() {
		Object[][] data = new Object[1][10];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_Revision_ReleaseStatus_9");
		
		return data;
	}
	@DataProvider
	public Object[][] getDataForP3RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForPVT1WIP() {
		Object[][] data = new Object[1][24];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_9");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_10");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_11");
		data[0][12] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_12");
		data[0][13] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_13");
		data[0][14] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_14");
		data[0][15] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_15");
		data[0][16] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_16");
		data[0][17] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_17");
		data[0][18] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_18");
		data[0][19] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_19");
		data[0][20] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_20");
		data[0][21] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_21");
		data[0][22] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_22");
		data[0][23] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_Revision_ReleaseStatus_23");
		

		return data;
	}
	@DataProvider
	public Object[][] getDataForPVT1RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForPVT2WIP() {
		Object[][] data = new Object[1][26];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_9");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_10");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_11");
		data[0][12] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_12");
		data[0][13] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_13");
		data[0][14] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_14");
		data[0][15] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_15");
		data[0][16] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_16");
		data[0][17] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_17");
		data[0][18] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_18");
		data[0][19] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_19");
		data[0][20] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_20");
		data[0][21] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_21");
		data[0][22] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_22");
		data[0][23] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_23");
		data[0][24] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_24");
		data[0][25] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_Revision_ReleaseStatus_25");

		return data;
	}
	@DataProvider
	public Object[][] getDataForPVT2RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForDVT1WIP() {
		Object[][] data = new Object[1][18];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_9");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_10");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_11");
		data[0][12] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_12");
		data[0][13] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_13");
		data[0][14] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_14");
		data[0][15] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_15");
		data[0][16] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_16");
		data[0][17] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_Revision_ReleaseStatus_17");
			
		return data;
	}
	@DataProvider
	public Object[][] getDataForDVT1RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForDVT2WIP() {
		Object[][] data = new Object[1][20];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_9");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_10");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_11");
		data[0][12] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_12");
		data[0][13] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_13");
		data[0][14] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_14");
		data[0][15] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_15");
		data[0][16] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_16");
		data[0][17] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_17");
		data[0][18] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_18");
		data[0][19] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_Revision_ReleaseStatus_19");
		
		return data;
	}
	@DataProvider
	public Object[][] getDataForDVT2RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForDVT3WIP() {
		Object[][] data = new Object[1][22];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_9");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_10");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_11");
		data[0][12] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_12");
		data[0][13] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_13");
		data[0][14] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_14");
		data[0][15] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_15");
		data[0][16] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_16");
		data[0][17] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_17");
		data[0][18] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_18");
		data[0][19] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_19");
		data[0][20] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_20");
		data[0][21] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_Revision_ReleaseStatus_21");

		return data;
	}
	@DataProvider
	public Object[][] getDataForDVT3RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForEVT1WIP() {
		Object[][] data = new Object[1][12];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_9");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_10");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_Revision_ReleaseStatus_11");
		
		
		return data;
	}
	@DataProvider
	public Object[][] getDataForEVT1RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForEVT2WIP() {
		Object[][] data = new Object[1][14];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_9");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_10");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_11");
		data[0][12] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_12");
		data[0][13] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_Revision_ReleaseStatus_13");
		
		
		return data;
	}
	@DataProvider
	public Object[][] getDataForEVT2RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForEVT3WIP() {
		Object[][] data = new Object[1][16];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_2");
		data[0][3] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_3");
		data[0][4] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_4");
		data[0][5] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_5");
		data[0][6] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_6");
		data[0][7] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_7");
		data[0][8] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_8");
		data[0][9] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_9");
		data[0][10] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_10");
		data[0][11] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_11");
		data[0][12] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_12");
		data[0][13] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_13");
		data[0][14] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_14");
		data[0][15] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_Revision_ReleaseStatus_15");
		
		return data;
	}
	@DataProvider
	public Object[][] getDataForEVT3RELEASED() {
		Object[][] data = new Object[1][3];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3RELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3RELEASED_Revision_ReleaseStatus_1");
		data[0][2] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3RELEASED_Revision_ReleaseStatus_2");
		return data;
	}
	@DataProvider
	public Object[][] getDataForMPRELEASED() {
		Object[][] data = new Object[1][2];
		data[0][0] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.MPRELEASED_RevRule");
		data[0][1] = PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.MPRELEASED_Revision_ReleaseStatus_1");
		return data;
	}
}
