package com.tc_awc.pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class saveAs_Form extends TestBase {
	public WebDriverWait wt;
	home_Page hp = new home_Page();

	// Page Factory
	By SaveAs_New = By.xpath("//a[contains(text(),'New')]");
	By SaveAs_ItemName = By.xpath(
			"//aw-widget[@ng-if=\"data['object_name']\"]//textarea[@class='aw-widgets-propertyEditValue ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope ng-empty ng-valid-required ng-valid-maxlength ng-valid-aw-required']");
	By WIPflag = By.xpath(
			"//aw-widget[contains(@class,'ng-scope ng-isolate-scope')]//div[contains(@class,'aw-layout-flexRowContainer aw-widget-iconParent ng-scope')]");
	By WIPList = By.xpath(
			"//div[contains(@class,'aw-jswidgets-listboxDrop aw-jswidgets-drop aw-base-scrollPanel aw-jswidgets-page ng-scope')]/ul/li");
	By item_progressFlag = By.xpath(
			"//div[contains(@class,'aw-layout-flexRowContainer aw-widget-iconParent ng-scope')]//input[@placeholder='Required']");
	By item_ProgressFlagList = By
			.xpath("//div[contains(@class,'aw-jswidgets-listboxDrop')]/ul[@class='aw-widgets-cellListWidget']/li");
	By item_name = By.xpath(
			"//textarea[@class='aw-widgets-propertyEditValue ng-pristine ng-untouched ng-scope ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength ng-invalid-aw-required']");
	By SaveBtn = By.xpath("//div[@class='aw-layout-panelFooter ng-scope']");
	By New_saveButton = By.xpath("//div[contains(@class,'aw-layout-panelFooter ng-scope')]/button[2]");
	By Revision_saveButton = By.xpath("//div[contains(@class,'aw-layout-panelFooter ng-scope')]/button[1]");
	By Popup = By.xpath("//span[@class='noty_text']");

	// Actions

	public void save_as() throws InterruptedException {

		// click on WIPs Drop down
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		click_custom(DriverFactory.getInstance().getDriver().findElement(item_progressFlag), "Clicked on Work process");
		Thread.sleep(3000L);

	}

	public void save_as(String ReleaseStatus_2, String ReleaseStatus_3) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		js.executeScript(
				"document.querySelector(\"#aw_toolsAndInfo > div > aw-include > div > div > div.aw-layout-panelMain > div > form > form\").scrollBy(0,350)");
		Thread.sleep(3000L);
//		click on WIPs Drop down
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		click_custom(DriverFactory.getInstance().getDriver().findElement(item_progressFlag), "Clicked on Work process");
		Thread.sleep(3000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(item_ProgressFlagList);
		Thread.sleep(3000L);
		System.out.println(li.size());
		WebElement q;
//		iterate the list and click if match the result (P1 WIP)
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			if (ReleaseStatus_2.equals(q.getText())) {
				q.click();
				break;
			}
		}

		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(Revision_saveButton).click();

	}

//	---newReleaseStatus
	public void save_as(String newReleaseStatus) throws InterruptedException {
//		click on WIPs Drop down
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		click_custom(DriverFactory.getInstance().getDriver().findElement(item_progressFlag), "Clicked on Work process");
		Thread.sleep(3000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(item_ProgressFlagList);
		Thread.sleep(3000L);
		System.out.println(li.size());
		WebElement q;
//		iterate the list and click if match the result (P1 WIP)
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			if (newReleaseStatus.equals(q.getText())) {
				q.click();
				getprint_custom(newReleaseStatus, "Item Revision WIP Status :" );
				break;
			}
		}

		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(Revision_saveButton).click();

	}

//	---- iterate WIP Status List for same WIP.
	public void iterate_WIPStatusList() throws InterruptedException {
		Thread.sleep(3000L);
		String RS = DriverFactory.getInstance().getDriver().findElement(hp.Release_status).getText();
		// list of WIPs
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(3));
		wt.until(ExpectedConditions.visibilityOfElementLocated(item_ProgressFlagList));
		java.util.List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(item_ProgressFlagList);
		System.out.println(li.size());
		WebElement q;
//		iterate the list and click if match the result 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			boolean flag = RS.isEmpty();
			if (flag == false) {
				if (q.getText().equals(RS)) {
					System.out.println("both are matching");
					q.click();
					break;
				}
			} else {
				if (flag == true) {
					if (q.getText().equals("General WIP")) {
						q.click();
						break;
					}
				}
				System.out.println("this Status is selected" + q.getText());
			}
		}
	}

//------ save and Assert the Message
	public void AssertWorngMessage(String prop) throws InterruptedException {
		String RS = DriverFactory.getInstance().getDriver().findElement(hp.Release_status).getText();
		// Click on Save button
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		click_custom(DriverFactory.getInstance().getDriver().findElement(SaveBtn), "Clicked on Save button");
		// Get popup msg
		wt.until(ExpectedConditions.visibilityOfElementLocated(Popup));
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(Popup);
		// checking the popup message
		Thread.sleep(2000L);
		boolean flag=RS.isEmpty();
		if (flag==true) {
			Assert.assertEquals(
					"General WIP Revisions limit exceeded for Item " + PropertiesOperations.getPropertyValueByKey(prop)
							+ ". The Maximum number of General WIP revisions allowed is: 1",
					pop.getText());
			Thread.sleep(1000L);
		} else {
			Assert.assertEquals("WIP Revisions per build limit exceeded for Item "
					+ PropertiesOperations.getPropertyValueByKey(prop)
					+ ". The Maximum number of WIP revisions per build allowed is: 1", pop.getText());
			Thread.sleep(1000L);
		}
	}
	
	public void AssertWorngMessage() throws InterruptedException {
		wt.until(ExpectedConditions.visibilityOfElementLocated(Popup));
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(Popup);

		// Assert the popup message
		Assert.assertEquals("WIP Revisions per build limit exceeded for Item "
				+ home_Page.itemID
				+ ". The Maximum number of WIP revisions per build allowed is: 1", pop.getText());
		System.out.println("Test case passed");
		Thread.sleep(1000L);
	}
	
	public void AssertMessage() throws InterruptedException {
		wt.until(ExpectedConditions.visibilityOfElementLocated(Popup));
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(Popup);
		// Assert the popup message
		Assert.assertEquals("Total Build WIP Revisions limit exceeded for Item "
				+ home_Page.itemID
				+ ". The total build WIP revisions allowed is: 2", pop.getText());
		System.out.println("Test case passed");
		Thread.sleep(1000L);
	}

	public String getNextReleaseStatus(String oldReleaseStatus) {
		switch (oldReleaseStatus) {
		case "P0 WIP":
			return "P1 WIP";
		case "P1 WIP":
			return "P2 WIP";
		case "DVT1 WIP":
			return "DVT2 WIP";
		case "DVT2 WIP":
			return "DVT3 WIP";
		case "EVT1 WIP":
			return "EVT2 WIP";
		case "EVT2 WIP":
			return "EVT3 WIP";
		case "PVT1 WIP":
			return "PVT2 WIP";
		case "PVT2 WIP":
			return "P0 WIP";
		default:
			return "";
		}
	}

	// SaveItem() use to save the exist item using provide WIP status.
	public void saveItem(String itemStatus) throws InterruptedException {
		addItem_Page ap = new addItem_Page();
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(3000L);
		// wt.until(ExpectedConditions.visibilityOf(getaddFrameTitle()));
		DriverFactory.getInstance().getDriver().findElement(SaveAs_New).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(SaveAs_ItemName));
		DriverFactory.getInstance().getDriver().findElement(SaveAs_ItemName).sendKeys("Save As-" + itemStatus);
		ap.SelectStatus_WIPStatus(itemStatus);
		wt.until(ExpectedConditions.elementToBeClickable(New_saveButton));
		DriverFactory.getInstance().getDriver().findElement(New_saveButton).click();
		wt.until(ExpectedConditions.visibilityOf(DriverFactory.getInstance().getDriver().findElement(Popup)));
		WebElement popupMsg = DriverFactory.getInstance().getDriver().findElement(Popup);
		String mesg = popupMsg.getText();
		System.out.println("PopUp Message: " + mesg);
		getprint_custom(mesg, "PopUp Message: ");
	}
}
