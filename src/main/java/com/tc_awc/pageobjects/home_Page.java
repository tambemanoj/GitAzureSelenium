package com.tc_awc.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.tc_awc.configuration.AWC_revisionRule;
import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class home_Page extends TestBase {
	public WebDriverWait wt;
	folder_Page fp;
	addItem_Page ap;
	item_Page ip = new item_Page();
	public static String itemID;
	// Page Factory
	By home = By.xpath("//div[@class='aw-commands-wrapper']//button[@id='Awp0GoHome']");
	By folder = By.xpath("//aw-command[@class='ng-scope']/button[@id='Awp0ShowHomeFolder']");
	By BOM_RevRule=By.xpath("//div[@title='BOM_RevRule']//div[@class='aw-tile-tileContent aw-layout-flexColumn aw-theme-tileText']");

	By favorites = By.xpath("//button[@id='Awp0GoFavorites']");

	By inbox = By.xpath("//button[@id='Awp0GoInboxWithoutBubble']");

	By quickAccess = By.xpath("//button[@id='cmdQuickAccess']");
	// ------------search function parameters-----------
	By searchIcon = By.xpath(
			"//aw-showobject-header/div[1]/div[1]/div[2]/aw-global-search[1]/div[1]/aw-include[1]/div[1]/aw-search-global[1]/div[1]/div[1]/div[2]/aw-icon[1]/*[1]");
	By advancedSearch = By.xpath("//a[contains(text(),'Advanced Search')]");
	By search_itemID = By.xpath(
			"//div[@class='aw-layout-panelSection ng-scope ng-isolate-scope']//textarea[@class='aw-widgets-propertyEditValue ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope ng-empty ng-valid-required ng-valid-maxlength ng-valid-aw-required']");
	By searchBtn = By.xpath(
			"//button[@class='aw-base-blk-button ng-scope ng-isolate-scope aw-accent-highContrast']//aw-i18n[@class='ng-scope'][normalize-space()='Search']");
	By searchResultMsg = By.xpath("//span[contains(text(),'Search results found for Item ID')]");
	By searchItemLabel = By.xpath(
			"//li[@class='aw-widgets-cellListItem aw-widgets-cellTop ng-scope']//div[@class='aw-widgets-cellListItemCell']//div[@class='aw-layout-flexRow']");
	By searchitem_Item = By.xpath("//li[@class='aw-widgets-cellListItem aw-widgets-cellTop ng-scope']");
	By searchItem_OpenButton = By.xpath(
			"//aw-cell-command-bar[@anchor='com.siemens.splm.clientfx.ui.modelObjectDataGridActionCommands']//aw-command[@id='0']");

	By Release_status = By.xpath(
			"//*[@id='main-view']/aw-include/div/div/div/div/div/ui-view/aw-showobject-page/div/div/div/div[3]/div/ng-transclude/aw-xrt-sublocation/aw-sublocation/div/div[2]/div/aw-sublocation-body/div/aw-xrt-2/aw-walker-view/div[1]/aw-walker-element/div[1]/form/aw-walker-element/div[6]/div/aw-walker-property/aw-widget/div/div");
	By NewRevision = By.xpath("//button[@id='Awp0NewGroup']");
	By revise = By.xpath("//li[@id='Awp0ShowSaveAs']");

	// Actions:
	public void clickFolder() {
		click_custom(DriverFactory.getInstance().getDriver().findElement(folder), "Folder_Tile");
	}

	public void clickhome() {
		DriverFactory.getInstance().getDriver().findElement(home).sendKeys(Keys.ENTER);
	}
	
	public void clickBOMRevRule() {
		DriverFactory.getInstance().getDriver().findElement(BOM_RevRule).click();
}

	// -------------Search the particular item using advanced search
	public void search_item(String itemStatus) throws Throwable {
		// Thread.sleep(2000L);
		ap = new addItem_Page();
		itemID = ap.createItemStatus(itemID);
		Thread.sleep(2000L);
		ap.SelectStatus_WIPStatus(itemStatus);
		ap.addForm_addProcess();
		System.out.println("ItemID : " + itemID);
		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000L);
			DriverFactory.getInstance().getDriver().findElement(searchIcon).click();
			Thread.sleep(3000L);
			wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
			wt.until(ExpectedConditions.visibilityOfElementLocated(advancedSearch));
			DriverFactory.getInstance().getDriver().findElement(advancedSearch).click();
			Thread.sleep(4000L);
//			try {
//				DriverFactory.getInstance().getDriver().findElement(advancedSearch).click();
//			} catch (StaleElementReferenceException e) {
//				System.out.println("Please handle the element if it get change: reinitialize");
//			}
	
//		wt.until(ExpectedConditions.visibilityOfElementLocated(search_itemID));
		if (DriverFactory.getInstance().getDriver().findElement(search_itemID).getText().isEmpty()) {
			DriverFactory.getInstance().getDriver().findElement(search_itemID).sendKeys(itemID);
		} else {
			DriverFactory.getInstance().getDriver().findElement(search_itemID).clear();
			Thread.sleep(2000L);
			DriverFactory.getInstance().getDriver().findElement(search_itemID).sendKeys(itemID);
		}

		 Thread.sleep(2000L);
//		wt.until(ExpectedConditions.elementToBeClickable(searchBtn));
		DriverFactory.getInstance().getDriver().findElement(searchBtn).click();
		Thread.sleep(3000L);
//		wt.until(ExpectedConditions.visibilityOfElementLocated(searchResultMsg));

//		Open the Item details to get the Release Status--------------------------------------------
		WebElement ele = DriverFactory.getInstance().getDriver().findElement(searchItemLabel);
		System.out.println("CellTitle List Size:" + ele.getText());
		ele.click();
		Thread.sleep(2000L);
		// wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchItemLabel));
		WebElement m = DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//*[name()='svg']//*[local-name()='polygon' and @points='18,24 0,24 0,6 6,6 6,7 1,7 1,23 17,23 17,15 18,15 ']"));
		// Action class to move an click element
		Actions a = new Actions(DriverFactory.getInstance().getDriver());
		a.moveToElement(m).click().build().perform();

//		Select the item
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchItemLabel));
		WebElement ele1 = DriverFactory.getInstance().getDriver().findElement(searchItemLabel);// Select the item
		try {
			ele1.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		WebElement n = DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//*[name()='svg']//*[local-name()='polygon' and @points='18,24 0,24 0,6 6,6 6,7 1,7 1,23 17,23 17,15 18,15 ']"));

		Actions aa = new Actions(DriverFactory.getInstance().getDriver()); // Action class to move an click element
		aa.moveToElement(n).click().build().perform();

//		Grab the Release Status value from item details
		// wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesOperations.getPropertyValueByKey("ITEM_CREATE.STATUS_RELEASE_STATUS_XPATH"))));
		Thread.sleep(2000L);
//		Assert the expected value with actual value
		if (itemStatus.equals("General WIP")) {
			getprint_custom("Realease status :", itemStatus);
		} else {
			WebElement st = DriverFactory.getInstance().getDriver().findElement(
					By.xpath(PropertiesOperations.getPropertyValueByKey("ITEM_CREATE.STATUS_RELEASE_STATUS_XPATH")));
			System.out.println("Realease status :" + st.getText());
			assertEqualsString_custom(st.getText(), itemStatus, "Both values are equals");
		}

	}

//	-----------
	public String return_search_item(String itemStatus) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		// Thread.sleep(2000L);
		ap = new addItem_Page();
		itemID = ap.createItemStatus(itemID);
		Thread.sleep(2000L);
		ap.SelectStatus_WIPStatus(itemStatus);
		ap.addForm_addProcess();
		System.out.println("ItemID : " + itemID);
		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(searchIcon).click();
		// wt.until(ExpectedConditions.visibilityOfElementLocated(advancedSearch));
		// wt.until(ExpectedConditions.stalenessOf(DriverFactory.getInstance().getDriver().findElement(advancedSearch)));
		try {
			DriverFactory.getInstance().getDriver().findElement(advancedSearch).click();
		} catch (StaleElementReferenceException e) {
			System.out.println("Please handle the element if it get change: reinitialize");
		}
		Thread.sleep(4000L);
		wt.until(ExpectedConditions.visibilityOfElementLocated(search_itemID));
		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(search_itemID).sendKeys(itemID);
		Thread.sleep(1000L);
		wt.until(ExpectedConditions.elementToBeClickable(searchBtn));
		DriverFactory.getInstance().getDriver().findElement(searchBtn).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(searchResultMsg));

//		Open the Item details to get the Release Status--------------------------------------------
		WebElement ele = DriverFactory.getInstance().getDriver().findElement(searchItemLabel);
		System.out.println("CellTitle List Size:" + ele.getText());
		ele.click();
		Thread.sleep(2000L);
		// wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchItemLabel));
		WebElement m = DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//*[name()='svg']//*[local-name()='polygon' and @points='18,24 0,24 0,6 6,6 6,7 1,7 1,23 17,23 17,15 18,15 ']"));
		// Action class to move an click element
		Actions a = new Actions(DriverFactory.getInstance().getDriver());
		a.moveToElement(m).click().build().perform();

//		Select the item
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchItemLabel));
		WebElement ele1 = DriverFactory.getInstance().getDriver().findElement(searchItemLabel);// Select the item
		try {
			ele1.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		WebElement n = DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//*[name()='svg']//*[local-name()='polygon' and @points='18,24 0,24 0,6 6,6 6,7 1,7 1,23 17,23 17,15 18,15 ']"));

		Actions aa = new Actions(DriverFactory.getInstance().getDriver()); // Action class to move an click element
		aa.moveToElement(n).click().build().perform();

//		Grab the Release Status value from item details
		// wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesOperations.getPropertyValueByKey("ITEM_CREATE.STATUS_RELEASE_STATUS_XPATH"))));
		Thread.sleep(2000L);
//		Assert the expected value with actual value
		if (itemStatus.equals("General WIP")) {
			getprint_custom("General WIP", itemStatus);
			return "";
		} else {
			WebElement st = DriverFactory.getInstance().getDriver().findElement(
					By.xpath(PropertiesOperations.getPropertyValueByKey("ITEM_CREATE.STATUS_RELEASE_STATUS_XPATH")));
			System.out.println("Realease status :" + st.getText());
			assertEqualsString_custom(st.getText(), itemStatus, "Both values are equals");

//			data.
			switch (st.getText()) {
			case "P0 WIP":
				return "P1 WIP";
			case "P1 WIP":
				return "P2 WIP";
			case "DVT1 WIP":
				return "DVT2 WIP";
			case "EVT1 WIP":
				return "EVT2 WIP";
			case "PVT1 WIP":
				return "PVT2 WIP";

			case "P3 WIP":
				return "PROTO 0 RELEASE";
			case "EVT3 WIP":
				return "EVT 1 RELEASE";
			case "DVT3 WIP":
				return "DVT 1 RELEASE";
			case "PVT2 WIP":
				return "PVT 1 RELEASE";

			}

		}
		return "";

	}

	public void search_saveAs() throws InterruptedException {
		// DriverFactory.getInstance().getDriver().findElement(searchIcon).click();
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(advancedSearch));
		DriverFactory.getInstance().getDriver().findElement(advancedSearch).click();
		Thread.sleep(2000L);
		wt.until(ExpectedConditions.visibilityOfElementLocated(search_itemID));
		DriverFactory.getInstance().getDriver().findElement(search_itemID)
				.sendKeys(PropertiesOperations.getPropertyValueByKey("ITEM_SAVEAS.SEARCH_ITEM_ID"));
		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(searchBtn).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(searchResultMsg));
//		Open the Item details to get the Release Status--------------------------------------------
		WebElement ele = DriverFactory.getInstance().getDriver().findElement(searchItemLabel);
		System.out.println("CellTitle List Size:" + ele.getText());
		ele.click();
		Thread.sleep(2000L);
		// wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchItemLabel));
		WebElement m = DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//*[name()='svg']//*[local-name()='polygon' and @points='18,24 0,24 0,6 6,6 6,7 1,7 1,23 17,23 17,15 18,15 ']"));
		// Action class to move an click element
		Actions a = new Actions(DriverFactory.getInstance().getDriver());
		a.moveToElement(m).click().build().perform();

//		Select the item
		Thread.sleep(2000L);
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchItemLabel));
		WebElement ele1 = DriverFactory.getInstance().getDriver().findElement(searchItemLabel);
		try {
			ele1.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// To Identify the Svg element
		WebElement n = DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//*[name()='svg']//*[local-name()='polygon' and @points='18,24 0,24 0,6 6,6 6,7 1,7 1,23 17,23 17,15 18,15 ']"));

		Actions aa = new Actions(DriverFactory.getInstance().getDriver()); // Action class to move an click element
		aa.moveToElement(n).click().build().perform();
		// To click on New button
		Thread.sleep(1000L);
		fp = new folder_Page();

		ip.clicknewItem_saveAs();
		Thread.sleep(1000L);

	}

//  Search ItemID and check Release_status (Manoj)
	public void AdvSearch(String prop) throws InterruptedException {
		Thread.sleep(4000L);
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(advancedSearch));
		DriverFactory.getInstance().getDriver().findElement(advancedSearch).click();
		// click_custom(DriverFactory.getInstance().getDriver().findElement(advancedSearch),"Clicked
		// on advanced search button");

//		Enter ItemID
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(search_itemID));
		DriverFactory.getInstance().getDriver().findElement(search_itemID)
				.sendKeys(PropertiesOperations.getPropertyValueByKey(prop));

		DriverFactory.getInstance().getDriver().findElement(searchBtn).click();
		click_custom(DriverFactory.getInstance().getDriver().findElement(searchBtn), "Clicked on search button");
		wt.until(ExpectedConditions.visibilityOfElementLocated(searchitem_Item));
//		DriverFactory.getInstance().getDriver().findElement(searchitem_Item).click();
		click_custom(DriverFactory.getInstance().getDriver().findElement(searchitem_Item), "Clicked on Item");
		Thread.sleep(2000L);

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(searchItem_OpenButton));
//		DriverFactory.getInstance().getDriver().findElement(searchItem_OpenButton).click();
		click_custom(DriverFactory.getInstance().getDriver().findElement(searchItem_OpenButton),
				"Clicked on redirect arrow");
		Thread.sleep(2000L);

//		Check Release status
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(Release_status));
		String RS = DriverFactory.getInstance().getDriver().findElement(Release_status).getText();
		System.out.println("Release status: " + RS);
		Thread.sleep(3000L);
	}
	
	//Search function for AWC_revisionRule Test cases
	public void search_itemId(String prop, String itemID) throws InterruptedException {
		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(searchIcon).click();
		Thread.sleep(2000L);
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(advancedSearch));
		DriverFactory.getInstance().getDriver().findElement(advancedSearch).click();
	   click_custom(DriverFactory.getInstance().getDriver().findElement(advancedSearch),"Clicked on advanced search button");

//		Enter ItemID
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(search_itemID));
		String SearchItem = returnRule(itemID);
		DriverFactory.getInstance().getDriver().findElement(search_itemID)
				.sendKeys(SearchItem);

		
		DriverFactory.getInstance().getDriver().findElement(searchBtn).click();
		click_custom(DriverFactory.getInstance().getDriver().findElement(searchBtn), "Clicked on search button");
		wt.until(ExpectedConditions.visibilityOfElementLocated(searchitem_Item));
//		DriverFactory.getInstance().getDriver().findElement(searchitem_Item).click();
		click_custom(DriverFactory.getInstance().getDriver().findElement(searchitem_Item), "Clicked on Item");
		Thread.sleep(2000L);

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(searchItem_OpenButton));
//		DriverFactory.getInstance().getDriver().findElement(searchItem_OpenButton).click();
		click_custom(DriverFactory.getInstance().getDriver().findElement(searchItem_OpenButton),
				"Clicked on redirect arrow");
		Thread.sleep(2000L);

//		Check Release status
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(Release_status));
		String RS = DriverFactory.getInstance().getDriver().findElement(Release_status).getText();
		System.out.println("Release status: " + RS);
		Thread.sleep(3000L);
	}
	
	public String returnRule(String s)
	 {		 
		 switch (s) {
			case "PROTO 0 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0WIP_SearchItem");
			case "PROTO 0 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P0RELEASED_SearchItem");
			case "PROTO 1 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1WIP_SearchItem");
			case "PROTO 1 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P1RELEASED_SearchItem");
			case "PROTO 2 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2WIP_SearchItem");
			case "PROTO 2 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P2RELEASED_SearchItem");
			case "PROTO 3 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3WIP_SearchItem");
			case "PROTO 3 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.P3RELEASED_SearchItem");
			case "PVT 1 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1WIP_SearchItem");
			case "PVT1 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT1RELEASED_SearchItem");
			case "PVT 2 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2WIP_SearchItem");
			case "PVT2 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.PVT2RELEASED_SearchItem");
			case "DVT 1 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1WIP_SearchItem");
			case "DVT1 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT1RELEASED_SearchItem");
			case "DVT 2 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2WIP_SearchItem");
			case "DVT2 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT2RELEASED_SearchItem");
			case "DVT 3 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3WIP_SearchItem");
			case "DVT3 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.DVT3RELEASED_SearchItem");
			case "EVT 1 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1WIP_SearchItem");
			case "EVT1 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT1RELEASED_SearchItem");
			case "EVT 2 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2WIP_SearchItem");
			case "EVT2 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT2RELEASED_SearchItem");
			case "EVT 3 WIP":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3WIP_SearchItem");
			case "EVT3 RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.EVT3RELEASED_SearchItem");
			case "POC RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.POCRELEASED_SearchItem ");
			case "MP RELEASED":
				return PropertiesOperations.getPropertyValueByKey("AWC_revisionRule.MPRELEASED_SearchItem");
				default:
					return "";
			}
				
	 }
	
	

}
