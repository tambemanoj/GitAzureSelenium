package com.tc_awc.negativetestcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tc_awc.functionaltestcases.AWC_Login;
import com.tc_awc.pageobjects.home_Page;
import com.tc_awc.pageobjects.item_Page;
import com.tc_awc.pageobjects.saveAs_Form;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;
/*3.1.Test creation and test automation to test the ability to restrict to one WIP status per build in an assembly
 * Ex: SearchItemID_GeneralWIP = P0000822
 * 	   Create Item Revision with same WIP Status (e.g.General WIP)
 */

public class AWC_CreateItemRevisionWithSameWIPStatus extends TestBase{
	
	public WebDriverWait wt;
	home_Page hp = new home_Page();
	item_Page  ip = new item_Page();
	saveAs_Form saf =new saveAs_Form();

	@Test(priority=1)
	public void createItemRevisionWithSameWIPStatus_GeneralWIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_GeneralWIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_GeneralWIP");
	}

	@Test(priority=2)
	public void createItemRevisionWithSameWIPStatus_P0WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_P0WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_P0WIP");
	}
	
	@Test(priority=3)
	public void createItemRevisionWithSameWIPStatus_P1WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_P1WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_P1WIP");
	}
	
	@Test(priority=4)
	public void createItemRevisionWithSameWIPStatus_P2WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_P2WIP");		
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_P2WIP");
	}
	
	@Test(priority=5)
	public void createItemRevisionWithSameWIPStatus_P3WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_P3WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_P3WIP");
	}
	
	@Test(priority=6)
	public void createItemRevisionWithSameWIPStatus_EVT1WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_EVT1WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_EVT1WIP");
	}
	
	@Test(priority=7)
	public void createItemRevisionWithSameWIPStatus_EVT2WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_EVT2WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_EVT2WIP");
	}
	
	@Test(priority=8)
	public void createItemRevisionWithSameWIPStatus_EVT3WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_EVT3WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_EVT3WIP");
	}
	
	@Test(priority=9)
	public void createItemRevisionWithSameWIPStatus_DVT1WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_DVT1WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_DVT1WIP");
	}
	
	@Test(priority=10)
	public void createItemRevisionWithSameWIPStatus_DVT2WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_DVT2WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_DVT2WIP");
	}
	
	@Test(priority=11)
	public void createItemRevisionWithSameWIPStatus_DVT3WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_DVT3WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_DVT3WIP");
	}
	
	@Test(priority=12)
	public void createItemRevisionWithSameWIPStatus_PVT1WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_PVT1WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_PVT1WIP");
	}
	
	@Test(priority=13)
	public void createItemRevisionWithSameWIPStatus_PVT2WIP() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		AWC_Login login = new AWC_Login();
		login.login();
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		hp.AdvSearch("SearchItemID_PVT2WIP");
		ip.clicknewItem_saveAs();
		saf.save_as();
		saf.iterate_WIPStatusList();
		saf.AssertWorngMessage("SearchItemID_PVT2WIP");
	}
}
