package com.tc_awc.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class addItem_Page extends TestBase {
	public WebDriverWait wt;
	public String itemID;
	public static int n = 0;
	String[] sa = new String[2];
	public static String parent;
	// Page Factory to create item
	By ARVR = By.xpath("//div[@class='aw-tcWidgets-modelTypeCell']/div[@title='ARVR Part']");
	By item_id = By.xpath(PropertiesOperations.getPropertyValueByKey("ITEM_CREATE.ITEM_ID_XPATH"));
	By item_revision = By.xpath(
			"//input[@class='aw-widgets-propertyEditValue ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope ng-not-empty ng-valid-required ng-valid-maxlength ng-valid-aw-required']");
	By item_progressFlag = By.xpath(
			"//div[contains(@class,'aw-layout-flexRowContainer aw-widget-iconParent ng-scope')]//input[@placeholder='Required']");
	By item_ProgressFlagList = By
			.xpath("//div[contains(@class,'aw-jswidgets-listboxDrop')]/ul[@class='aw-widgets-cellListWidget']/li");
	By item_name = By.xpath(
			"//textarea[@class='aw-widgets-propertyEditValue ng-pristine ng-untouched ng-scope ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength ng-invalid-aw-required']");
	By level1 = By.xpath("//div[@title='1']");
	By level2 = By.xpath("//div[@title='2']");

	By addButton = By.xpath("//button[@class='aw-base-blk-button ng-scope ng-isolate-scope aw-accent-highContrast']");

	By addItemFrameTitle = By.xpath("//div[contains(@class,'gwt-Label')]");
	By panelSectionTitle = By.xpath("//div[@class='aw-layout-panelSectionTitle']/a");
	By popup = By.xpath("//span[contains(@class,'noty_text')]");

	// Page Factory to create Folder
	By folders = By.xpath("//div[@class='aw-tcWidgets-modelTypeCell']/div[@title='Folder']");
	By folder_name = By.xpath("//input[@placeholder='Required']");
	By folder_description = By.xpath(
			"//textarea[@class='aw-widgets-propertyEditValue ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope ng-empty ng-valid-required ng-valid-maxlength ng-valid-aw-required']");

	// Actions:

	// Get Frame Title"Add"

	public WebElement getaddFrameTitle() {
		return DriverFactory.getInstance().getDriver().findElement(addItemFrameTitle);
	}

	public List<WebElement> getitem_ProgressFlagList() {
		return DriverFactory.getInstance().getDriver().findElements(item_ProgressFlagList);
	}

	// Add item
	public void addItem() throws InterruptedException {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(2000L);
		wt.until(ExpectedConditions.visibilityOf(getaddFrameTitle()));
		click_custom(DriverFactory.getInstance().getDriver().findElement(ARVR), "ARVR_PART");
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(panelSectionTitle).isDisplayed(),
				"Title link is not displayed");
		Assert.assertEquals(DriverFactory.getInstance().getDriver().findElement(panelSectionTitle).getText(),
				"ARVR PART");
		Thread.sleep(2000L);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(item_id).isDisplayed(),
				"Item ID is not displayed");
		WebElement itemID = DriverFactory.getInstance().getDriver().findElement(item_id);
		System.out.println("Item ID : " + itemID.getAttribute("value"));
		parent = itemID.toString(); // this is for configuration create ItemID if loop
		getprint_custom(itemID.getAttribute("value"), "Item ID : ");
		WebElement itemRevision = DriverFactory.getInstance().getDriver().findElement(item_revision);
		// ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Item Revision : " + itemRevision.getAttribute("value"));
		// --------------to get the progressflag options

		DriverFactory.getInstance().getDriver().findElement(item_progressFlag).click();
		Thread.sleep(1000L);
		List<WebElement> list = getitem_ProgressFlagList();
		System.out.println("List Size:" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("dropdown option: " + list.get(i).getText());

		}

		DriverFactory.getInstance().getDriver().findElement(item_name).sendKeys("Test-NewItem");
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		DriverFactory.getInstance().getDriver().findElement(addButton).click();
		wt.until(ExpectedConditions.visibilityOf(DriverFactory.getInstance().getDriver().findElement(popup)));
		WebElement popupMsg = DriverFactory.getInstance().getDriver().findElement(popup);
		String mesg = popupMsg.getText();
		System.out.println("PopUp Message: " + mesg);
		getprint_custom(mesg, "PopUp Message: ");
	}

	// Add Item Revision
	public String createItemStatus(String id) throws InterruptedException {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(2000L);
		wt.until(ExpectedConditions.visibilityOf(getaddFrameTitle()));
		click_custom(DriverFactory.getInstance().getDriver().findElement(ARVR), "ARVR_PART");
		// DriverFactory.getInstance().getDriver().findElement(ARVR).click();
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(panelSectionTitle).isDisplayed(),
				"Title link is not displayed");
		Thread.sleep(2000L);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(item_id).isDisplayed(),
				"Item ID is not displayed");
		itemID = DriverFactory.getInstance().getDriver().findElement(item_id).getAttribute("value");

		System.out.println("Item ID : " + itemID);
		getprint_custom(itemID, "Item ID : ");
		Thread.sleep(2000L);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(item_revision).isDisplayed(),
				"Item revision is not displayed");
		String itemRevision = DriverFactory.getInstance().getDriver().findElement(item_revision).getText();
		System.out.println("Item Revision : " + itemRevision);
		return itemID;
	}

	// --------------to get the WIP Status dropdown options
	public void SelectStatus_WIPStatus(String itemStatus) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(item_progressFlag).click();
		Thread.sleep(1000L);
		List<WebElement> list = getitem_ProgressFlagList();
		System.out.println("List Size:" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("dropdown option: " + list.get(i).getText());
			System.out.println("ItemStatus: " + itemStatus);
			// Thread.sleep(1000L);
			if (list.get(i).getText().equals(itemStatus)) {
				// click_custom(list.get(i), "Selected_WIP_Status");
				list.get(i).click();
				getprint_custom(list.get(i).getText(), "Selected_WIP_Status");
				break;
			}

		}
	}

	// ---------To Add the created a item from Add form...
	public void addForm_addProcess() throws InterruptedException {
		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(item_name)
				.sendKeys(PropertiesOperations.getPropertyValueByKey("ITEM_CREATE.STATUS_ITEM_NAME"));
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		DriverFactory.getInstance().getDriver().findElement(addButton).click();
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(@class,'noty_text')]")).getText();
		wt.until(ExpectedConditions.visibilityOf(DriverFactory.getInstance().getDriver().findElement(popup)));
		WebElement popupMsg = DriverFactory.getInstance().getDriver().findElement(popup);
		String mesg = popupMsg.getText();
		System.out.println("PopUp Message: " + mesg);
		getprint_custom(mesg, "PopUp Message: ");

	}

	// Add New Folder
	public void addFolder() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(2000L);
		wt.until(ExpectedConditions.visibilityOf(getaddFrameTitle()));
		DriverFactory.getInstance().getDriver().findElement(folders).click();
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(panelSectionTitle).isDisplayed(),
				"Title link is not displayed");
		Assert.assertEquals(DriverFactory.getInstance().getDriver().findElement(panelSectionTitle).getText(), "FOLDER");
		String foldername = "TestFolder";
		DriverFactory.getInstance().getDriver().findElement(folder_name).sendKeys(foldername);
		DriverFactory.getInstance().getDriver().findElement(addButton).click();
		wt.until(ExpectedConditions.visibilityOf(DriverFactory.getInstance().getDriver().findElement(popup)));
		WebElement popupMsg = DriverFactory.getInstance().getDriver().findElement(popup);
		String mesg = popupMsg.getText();
		System.out.println("PopUp Message: " + mesg);
		// Assert.assertEquals(mesg,"\"TestFolder\" was added.");
		assertEqualsString_custom(mesg, "\"TestFolder\" was added.", "Popup message");
		String[] msgSplit = mesg.split(" ", 2);
		for (String a : msgSplit)
			System.out.println(a);

	}

//	Add Form (configuration)
	public String addform(int r) throws InterruptedException {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(2000L);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(item_id).isDisplayed(),
				"Item ID is not displayed");
		WebElement itemID = DriverFactory.getInstance().getDriver().findElement(item_id);
		System.out.println("Item ID : " + itemID.getAttribute("value"));
		getprint_custom(itemID.getAttribute("value"), "Item ID : ");
		String aa = itemID.getAttribute("value").toString();
		sa[n] = aa;
		n++;
		// System.out.println("Item ID " + aa);
		WebElement itemRevision = DriverFactory.getInstance().getDriver().findElement(item_revision);
		// ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Item Revision : " + itemRevision.getAttribute("value"));
		DriverFactory.getInstance().getDriver().findElement(item_progressFlag).click();
		Thread.sleep(3000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(item_ProgressFlagList);
		Thread.sleep(3000L);
		System.out.println("WIP Status List " + li.size());
		WebElement q;
//			n++;
		
//			iterate the list 
		for (int i = 0; i < li.size(); i++) {
			
			Thread.sleep(1000);
			q = li.get(i);
			if (r == 1) {
				if (q.getText().equals(PropertiesOperations.getPropertyValueByKey("AWC_createBOMstructure.addChild_Second_WIP_Status"))) {
					q.click();
					//System.out.println(q.getText());
					break;
				}
			} else if (r == 2) {
				if (PropertiesOperations.getPropertyValueByKey("AWC_createBOMstructure.addChild_Third_WIP_Status")
						.equals(q.getText())) {
					q.click();
					//System.out.println(q.getText());
					break;
				}
			}
			
		}
		DriverFactory.getInstance().getDriver().findElement(item_name).sendKeys("Item_Child");
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		DriverFactory.getInstance().getDriver().findElement(addButton).click();
		wt.until(ExpectedConditions.visibilityOf(DriverFactory.getInstance().getDriver().findElement(popup)));
		WebElement popupMsg = DriverFactory.getInstance().getDriver().findElement(popup);
		String mesg = popupMsg.getText();
		System.out.println("PopUp Message: " + mesg);
		getprint_custom(mesg, "PopUp Message: ");
		return aa;
	}

}
