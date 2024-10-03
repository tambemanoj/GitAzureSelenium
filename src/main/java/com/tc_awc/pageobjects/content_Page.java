package com.tc_awc.pageobjects;

import static org.testng.Assert.assertEquals;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.pageobjects.home_Page;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class content_Page extends TestBase {
	public WebDriverWait wt;
	public String itemID;
	addItem_Page ap;
	// Page Factory to create item
	By content = By.xpath("//a[normalize-space()='Content']");
	By newbtn = By.xpath("//button[@id='Awp0NewGroup']");
	By child = By.xpath("//li[@id='Awb0AddChildElementDeclarative']");
	By level = By.xpath("//div[@title='0']");
	By tabel_rows = By.xpath(
			"//aw-splm-table[@class='ng-isolate-scope']/div/div[@class='aw-splm-tableContainer']/div[@class='aw-splm-tableScrollContainer']/div[2]/div/div");
	By tabel_columns = By.xpath(
			"//aw-splm-table[@class='ng-isolate-scope']/div/div[@class='aw-splm-tableContainer']/div[@class='aw-splm-tableScrollContainer']/div[2]/div/div/div[@class='ui-grid-cell']");
	By filter = By.xpath("//input[@placeholder='Filter']");
	By revision_Rule = By
			.xpath("//aw-link-with-popup[@prop='data.currentRevisionRule']//aw-link[@class='ng-isolate-scope']");
	By DDrevision_Rule = By.xpath(
			"//aw-link-with-popup[@prop='data.currentRevisionRule']//aw-property-image[@name='miscDownArrow_uxRefresh']");
	By list_revision_Rule = By.xpath("//ul[@class='aw-widgets-cellListWidget aw-layout-flexColumnContainer']/li[2]");
	By release_status = By.xpath(
			"//div[@class='aw-splm-tableScrollContainer']//div[@class='aw-splm-tableScrollContents']//div[1]//div[4]//div[1]");
	By expand = By.xpath("//button[@id='Awb0Expand']");
	By expandBelow = By.xpath("//button[@id='Awb0ExpandBelow']");
	By overviewitemID = By.xpath(
			"//div[@class='aw-layout-panelSection ng-scope ng-isolate-scope']//div[1]//div[1]//aw-walker-property[1]//aw-widget[1]//div[1]//div[1]//div[1]//aw-property-val[1]//div[1]//div[1]//aw-property-non-edit-val[1]//div[1]//div[1]");
	By overviewReleaseStatus = By.xpath(
			"//aw-widget[@class='ng-isolate-scope']//aw-property-non-edit-array-val[@class='ng-isolate-scope']//div[@class='ng-scope']");
	By elementNameTable = By.xpath(
			"//div[@class='aw-splm-tableContainer']/div[contains(@class,\"aw-splm-tablePinnedContainerLeft\")]/div[2]/div[@class='aw-splm-tableScrollContents']/div/div/div");
//	By tree_with_summary = By.xpath("//button[@id='Awp0ModelObjListDisplayToggles']");
//	By tree = By.xpath("//li[@id='Awp0ShowTreeView']");
	By reset = By.xpath("//button[@id='Awb0ResetStructure']");
	By resetOk = By.xpath("//button[@id='button-1']");
	By downarrow = By.xpath("//aw-icon[@id='miscCollapsedTree']//*[name()='svg']");

//Actions:
	public WebElement getexpandButton() {
		return DriverFactory.getInstance().getDriver().findElement(expand);

	}

	public void add_child() {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(newbtn));
		DriverFactory.getInstance().getDriver().findElement(newbtn).click();
		DriverFactory.getInstance().getDriver().findElement(child).click();
	}

	public void BOM_Structure() throws InterruptedException {
//		DriverFactory.getInstance().getDriver().findElement(expand).click();
//		DriverFactory.getInstance().getDriver().findElement(expandBelow).click();
		Thread.sleep(1000L);
		int rowcount = DriverFactory.getInstance().getDriver().findElements(tabel_rows).size();
		System.out.println("Number of rows count :" + rowcount);
		for (int i = 1; i <= rowcount; i++) {
			// WebElement
			// rowText=DriverFactory.getInstance().getDriver().findElement(By.xpath("//aw-splm-table[@class='ng-isolate-scope']/div/div[@class='aw-splm-tableContainer']/div[@class='aw-splm-tableScrollContainer']/div[2]/div/div"));
			WebElement rowText = DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//div[@class='aw-splm-tableViewport aw-splm-tableCanvas']/div/div[" + i + "]"));
			System.out.println("RowText : " + i + "=" + rowText.getText());
			int column = DriverFactory.getInstance().getDriver().findElements(By.xpath(
					"//aw-splm-table[@class='ng-isolate-scope']/div/div[@class='aw-splm-tableContainer']/div[@class='aw-splm-tableScrollContainer']/div[2]/div/div["
							+ i + "]/div[@class='ui-grid-cell']"))
					.size();
			System.out.println("Number of columns : " + column);
			for (int k = 1; k <= column; k++) {

				if (k == 4) {
					String columValue = DriverFactory.getInstance().getDriver().findElement(By.xpath(
							"//aw-splm-table[@class='ng-isolate-scope']/div/div[@class='aw-splm-tableContainer']/div[@class='aw-splm-tableScrollContainer']/div[2]/div/div["
									+ i + "]/div[@class='ui-grid-cell'][" + k
									+ "]/div/img[@class='aw-visual-indicator']"))
							.getAttribute("title");
					System.out.println("Release Status columValue :" + k + " " + columValue);
					if (columValue.contains("P0 WIP") || columValue.contains("PROTO 0 RELEASED")
							|| columValue.contains("P1 WIP") || columValue.contains("PROTO 1 RELEASED")
							|| columValue.contains("EQR RELEASED")) {

						getprint_custom("Expected revision release status is present", columValue);
					} else {
						getprint_custom("Expected revision release status is not present", columValue);
						// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
						// is present");
					}
					break;
				}

			}
		}
	}

	public void getItemReleasStatus(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5)
			throws InterruptedException {
		Thread.sleep(1000);

		// if condition for extend button enable
		if (getexpandButton().isEnabled()) {
			DriverFactory.getInstance().getDriver().findElement(expand).click();
			Thread.sleep(1000L);
			DriverFactory.getInstance().getDriver().findElement(expandBelow).click();
			Thread.sleep(1000L);

			int rowcount = DriverFactory.getInstance().getDriver().findElements(elementNameTable).size();
			System.out.println("Number of rows count :" + rowcount);
			for (int i = 1; i <= rowcount; i++) {
				Thread.sleep(1000);
				WebElement rowText = DriverFactory.getInstance().getDriver().findElement(By.xpath(
						"//aw-sublocation-body/aw-data-navigator[1]/div[1]/div[1]/aw-primary-workarea[1]/div[1]/aw-include[1]/div[1]/div[1]/aw-splm-table[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div["
								+ i + "]/div[1]/div[1]/div[1]/div[4]/div[@class='aw-splm-tableCellText']"));
				System.out.println("RowText : " + i + "=" + rowText.getText());
				rowText.click();
				Thread.sleep(1000L);
				String a = DriverFactory.getInstance().getDriver().findElement(overviewitemID).getText();
				System.out.println("overviewitemID  : " + a);
				String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus)
						.getText();
				System.out.println("overviewReleaseStatus  : " + itemReleaseStatus);
				Thread.sleep(1000);
				if (itemReleaseStatus.contains(ReleaseStatusExpected1)
						|| itemReleaseStatus.contains(ReleaseStatusExpected2)
						|| itemReleaseStatus.contains(ReleaseStatusExpected3)
						|| itemReleaseStatus.contains(ReleaseStatusExpected4)
						|| itemReleaseStatus.contains(ReleaseStatusExpected5)) {
					getprint_custom("Expected revision release status is present", itemReleaseStatus);
				} else {
					getprint_custom("Expected revision release status is not present", itemReleaseStatus);
					// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
					// is present");
				}
			}
		} else {
			System.out.println("button is not enable");
			Thread.sleep(1000L);
			int rowcount = DriverFactory.getInstance().getDriver()
					.findElements(
							By.xpath("//aw-include[1]/div/div/aw-splm-table[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div"))
					.size();
			System.out.println("Number of rows count :" + rowcount);
			for (int i = 1; i <= rowcount; i++) {
				Thread.sleep(1000);
				// for checking base icon
				WebElement rowText = DriverFactory.getInstance().getDriver().findElement(By.xpath(
						"//aw-sublocation-body/aw-data-navigator[1]/div[1]/div[1]/aw-primary-workarea[1]/div[1]/aw-include[1]/div[1]/div[1]/aw-splm-table[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div["
								+ i + "]/div/div/div/div[3]/img"));
				System.out.println("RowText : " + i + "=" + rowText.getAttribute("class"));
				rowText.click();
				Thread.sleep(1000L);
				String a = DriverFactory.getInstance().getDriver().findElement(overviewitemID).getText();
				System.out.println("overviewitemID  : " + a);
				String b = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();
				System.out.println("overviewReleaseStatus  : " + b);
				Thread.sleep(1000);
			}

		}
	}

//	------------------------------------------------------------------------------------------------------
	public void getItemRel() throws InterruptedException {
		
		Thread.sleep(1000);
		// if condition for extend button enable
		if (getexpandButton().isEnabled()) {
			DriverFactory.getInstance().getDriver().findElement(expand).click();
			Thread.sleep(1000L);
			DriverFactory.getInstance().getDriver().findElement(expandBelow).click();
			Thread.sleep(1000L);
		}
		System.out.println("Expand button is not enable");
		Thread.sleep(1000L);
		int rowcount = DriverFactory.getInstance().getDriver().findElements(elementNameTable).size();
		System.out.println("Number of rows count :" + rowcount);
		for (int i = 1; i <= rowcount; i++) {
			Thread.sleep(1000);
			WebElement rowText = DriverFactory.getInstance().getDriver().findElement(By.xpath(
					"//aw-sublocation-body/aw-data-navigator[1]/div[1]/div[1]/aw-primary-workarea[1]/div[1]/aw-include[1]/div[1]/div[1]/aw-splm-table[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div["
							+ i + "]"));
			System.out.println("RowText : " + i + "=" + rowText.getText());
			rowText.click();
			Thread.sleep(1000L);
			String overView_ItemID = DriverFactory.getInstance().getDriver().findElement(overviewitemID).getText();
			System.out.println("overviewitemID  : " + overView_ItemID);
			boolean value= DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).isDisplayed();
			if(value==false ){
				System.out.println("Not as per RevRule" +value);
				getprint_custom("Expected revision release status is not present","");
				Assert.fail("Not as per RevRule" +value);
			} 
			String overView_ItemReleaseStatus = DriverFactory.getInstance().getDriver()
					.findElement(overviewReleaseStatus).getText();
			System.out.println("Status :" + overView_ItemReleaseStatus);
//			
			Thread.sleep(1000);
		}
	}

//#create function for RevRule P0WIP------------------------------------------------------------	
	public void verify_P0WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();
		 if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3))
			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		}

//#create function for RevRule P0RELEASED------------------------------------------------------------	
	public void verify_P0RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

//#create function for RevRule P1WIP------------------------------------------------------------	
	public void verify_P1WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5))
			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

//#create function for RevRule P1RELEASED------------------------------------------------------------
	public void verify_P1RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// P2WIP------------------------------------------------------------
	public void verify_P2WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7))
			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// P2RELEASED------------------------------------------------------------
	public void verify_P2RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// P3WIP------------------------------------------------------------
	public void verify_P3WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9))
			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// P3RELEASED------------------------------------------------------------
	public void verify_P3RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	public void verify_MPRELEASED(String ReleaseStatusExpected1) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1))
			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// PVT1WIP------------------------------------------------------------
	public void verify_PVT1WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17,
			String ReleaseStatusExpected18, String ReleaseStatusExpected19, String ReleaseStatusExpected20,
			String ReleaseStatusExpected21, String ReleaseStatusExpected22, String ReleaseStatusExpected23) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9)
				|| itemReleaseStatus.contains(ReleaseStatusExpected10)
				|| itemReleaseStatus.contains(ReleaseStatusExpected11)
				|| itemReleaseStatus.contains(ReleaseStatusExpected12)
				|| itemReleaseStatus.contains(ReleaseStatusExpected13)
				|| itemReleaseStatus.contains(ReleaseStatusExpected14)
				|| itemReleaseStatus.contains(ReleaseStatusExpected15)
				|| itemReleaseStatus.contains(ReleaseStatusExpected16)
				|| itemReleaseStatus.contains(ReleaseStatusExpected17)
				|| itemReleaseStatus.contains(ReleaseStatusExpected18)
				|| itemReleaseStatus.contains(ReleaseStatusExpected19)
				|| itemReleaseStatus.contains(ReleaseStatusExpected20)
				|| itemReleaseStatus.contains(ReleaseStatusExpected21)
				|| itemReleaseStatus.contains(ReleaseStatusExpected22)
				|| itemReleaseStatus.contains(ReleaseStatusExpected23))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
			// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
			// is present");
		}
	}

	// #create function for RevRule
	// PVT1RELEASED------------------------------------------------------------
	public void verify_PVT1RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	public void verify_PVT2WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17,
			String ReleaseStatusExpected18, String ReleaseStatusExpected19, String ReleaseStatusExpected20,
			String ReleaseStatusExpected21, String ReleaseStatusExpected22, String ReleaseStatusExpected23,
			String ReleaseStatusExpected24, String ReleaseStatusExpected25) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9)
				|| itemReleaseStatus.contains(ReleaseStatusExpected10)
				|| itemReleaseStatus.contains(ReleaseStatusExpected11)
				|| itemReleaseStatus.contains(ReleaseStatusExpected12)
				|| itemReleaseStatus.contains(ReleaseStatusExpected13)
				|| itemReleaseStatus.contains(ReleaseStatusExpected14)
				|| itemReleaseStatus.contains(ReleaseStatusExpected15)
				|| itemReleaseStatus.contains(ReleaseStatusExpected16)
				|| itemReleaseStatus.contains(ReleaseStatusExpected17)
				|| itemReleaseStatus.contains(ReleaseStatusExpected18)
				|| itemReleaseStatus.contains(ReleaseStatusExpected19)
				|| itemReleaseStatus.contains(ReleaseStatusExpected20)
				|| itemReleaseStatus.contains(ReleaseStatusExpected21)
				|| itemReleaseStatus.contains(ReleaseStatusExpected22)
				|| itemReleaseStatus.contains(ReleaseStatusExpected23)
				|| itemReleaseStatus.contains(ReleaseStatusExpected24)
				|| itemReleaseStatus.contains(ReleaseStatusExpected25))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
			// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
			// is present");
		}
	}
//				else
//				{
//					System.out.println("Item Release Status is Null");
//				}
//			}

	// #create function for RevRule
	// PVT2RELEASED------------------------------------------------------------
	public void verify_PVT2RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// DVT1WIP------------------------------------------------------------
	public void verify_DVT1WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9)
				|| itemReleaseStatus.contains(ReleaseStatusExpected10)
				|| itemReleaseStatus.contains(ReleaseStatusExpected11)
				|| itemReleaseStatus.contains(ReleaseStatusExpected12)
				|| itemReleaseStatus.contains(ReleaseStatusExpected13)
				|| itemReleaseStatus.contains(ReleaseStatusExpected14)
				|| itemReleaseStatus.contains(ReleaseStatusExpected15)
				|| itemReleaseStatus.contains(ReleaseStatusExpected16)
				|| itemReleaseStatus.contains(ReleaseStatusExpected17))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
			// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
			// is present");
		}
	}
//						else
//						{
//							System.out.println("Item Release Status is Null");
//						}
//					}	

	// #create function for RevRule
	// DVT1RELEASED------------------------------------------------------------
	public void verify_DVT1RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// DVT2WIP------------------------------------------------------------
	public void verify_DVT2WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17,
			String ReleaseStatusExpected18, String ReleaseStatusExpected19) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9)
				|| itemReleaseStatus.contains(ReleaseStatusExpected10)
				|| itemReleaseStatus.contains(ReleaseStatusExpected11)
				|| itemReleaseStatus.contains(ReleaseStatusExpected12)
				|| itemReleaseStatus.contains(ReleaseStatusExpected13)
				|| itemReleaseStatus.contains(ReleaseStatusExpected14)
				|| itemReleaseStatus.contains(ReleaseStatusExpected15)
				|| itemReleaseStatus.contains(ReleaseStatusExpected16)
				|| itemReleaseStatus.contains(ReleaseStatusExpected17)
				|| itemReleaseStatus.contains(ReleaseStatusExpected18)
				|| itemReleaseStatus.contains(ReleaseStatusExpected19))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
			// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
			// is present");
		}
	}

	// #create function for RevRule
	// DVT2RELEASED------------------------------------------------------------
	public void verify_DVT2RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// DVT3WIP------------------------------------------------------------
	public void verify_DVT3WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15, String ReleaseStatusExpected16, String ReleaseStatusExpected17,
			String ReleaseStatusExpected18, String ReleaseStatusExpected19, String ReleaseStatusExpected20,
			String ReleaseStatusExpected21) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9)
				|| itemReleaseStatus.contains(ReleaseStatusExpected10)
				|| itemReleaseStatus.contains(ReleaseStatusExpected11)
				|| itemReleaseStatus.contains(ReleaseStatusExpected12)
				|| itemReleaseStatus.contains(ReleaseStatusExpected13)
				|| itemReleaseStatus.contains(ReleaseStatusExpected14)
				|| itemReleaseStatus.contains(ReleaseStatusExpected15)
				|| itemReleaseStatus.contains(ReleaseStatusExpected16)
				|| itemReleaseStatus.contains(ReleaseStatusExpected17)
				|| itemReleaseStatus.contains(ReleaseStatusExpected18)
				|| itemReleaseStatus.contains(ReleaseStatusExpected19)
				|| itemReleaseStatus.contains(ReleaseStatusExpected20)
				|| itemReleaseStatus.contains(ReleaseStatusExpected21))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
			// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
			// is present");
		}
	}

	// #create function for RevRule
	// DVT3RELEASED------------------------------------------------------------
	public void verify_DVT3RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
		}
	}

	// #create function for RevRule
	// EVT1WIP------------------------------------------------------------
	public void verify_EVT1WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9)
				|| itemReleaseStatus.contains(ReleaseStatusExpected10)
				|| itemReleaseStatus.contains(ReleaseStatusExpected11))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
			// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
			// is present");
		}
	}

	// #create function for RevRule
	// EVT1RELEASED------------------------------------------------------------
	public void verify_EVT1RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
					String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

					if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

						getprint_custom("Expected revision release status is present", itemReleaseStatus);
					else {
						getprint_custom("Expected revision release status is not present", itemReleaseStatus);
					}
	}
	// #create function for RevRule
	// EVT2WIP------------------------------------------------------------
	public void verify_EVT2WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9)
				|| itemReleaseStatus.contains(ReleaseStatusExpected10)
				|| itemReleaseStatus.contains(ReleaseStatusExpected11)
				|| itemReleaseStatus.contains(ReleaseStatusExpected12)
				|| itemReleaseStatus.contains(ReleaseStatusExpected13))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
			// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
			// is present");
		}
	}

	// #create function for RevRule
	// DVT3RELEASED------------------------------------------------------------
	public void verify_EVT2RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
					String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

					if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

						getprint_custom("Expected revision release status is present", itemReleaseStatus);
					else {
						getprint_custom("Expected revision release status is not present", itemReleaseStatus);
					}
	}
	// #create function for RevRule
	// EVT3WIP------------------------------------------------------------
	public void verify_EVT3WIP(String ReleaseStatusExpected1, String ReleaseStatusExpected2,
			String ReleaseStatusExpected3, String ReleaseStatusExpected4, String ReleaseStatusExpected5,
			String ReleaseStatusExpected6, String ReleaseStatusExpected7, String ReleaseStatusExpected8,
			String ReleaseStatusExpected9, String ReleaseStatusExpected10, String ReleaseStatusExpected11,
			String ReleaseStatusExpected12, String ReleaseStatusExpected13, String ReleaseStatusExpected14,
			String ReleaseStatusExpected15) {
		String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

		if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2)
				|| itemReleaseStatus.contains(ReleaseStatusExpected3)
				|| itemReleaseStatus.contains(ReleaseStatusExpected4)
				|| itemReleaseStatus.contains(ReleaseStatusExpected5)
				|| itemReleaseStatus.contains(ReleaseStatusExpected6)
				|| itemReleaseStatus.contains(ReleaseStatusExpected7)
				|| itemReleaseStatus.contains(ReleaseStatusExpected8)
				|| itemReleaseStatus.contains(ReleaseStatusExpected9)
				|| itemReleaseStatus.contains(ReleaseStatusExpected10)
				|| itemReleaseStatus.contains(ReleaseStatusExpected11)
				|| itemReleaseStatus.contains(ReleaseStatusExpected12)
				|| itemReleaseStatus.contains(ReleaseStatusExpected13)
				|| itemReleaseStatus.contains(ReleaseStatusExpected14)
				|| itemReleaseStatus.contains(ReleaseStatusExpected15))

			getprint_custom("Expected revision release status is present", itemReleaseStatus);
		else {
			getprint_custom("Expected revision release status is not present", itemReleaseStatus);
			// Assert.assertEquals(columValue, "P0 WIP", "Expected revision release status
			// is present");
		}
	}

	// #create function for RevRule
	// EVT3RELEASED------------------------------------------------------------
	public void verify_EVT3RELEASED(String ReleaseStatusExpected1, String ReleaseStatusExpected2) {
					String itemReleaseStatus = DriverFactory.getInstance().getDriver().findElement(overviewReleaseStatus).getText();

					if (itemReleaseStatus.contains(ReleaseStatusExpected1) || itemReleaseStatus.contains(ReleaseStatusExpected2))

						getprint_custom("Expected revision release status is present", itemReleaseStatus);
					else {
						getprint_custom("Expected revision release status is not present", itemReleaseStatus);
					}
	}

	public void checking_icon() throws InterruptedException {
		int rowcount = DriverFactory.getInstance().getDriver().findElements(elementNameTable).size();
		System.out.println("Number of rows count :" + rowcount);
		for (int i = 1; i <= rowcount; i++) {
			Thread.sleep(1000);
			// for checking base icon
			WebElement RowText = DriverFactory.getInstance().getDriver().findElement(By.xpath(
					"//aw-sublocation-body/aw-data-navigator[1]/div[1]/div[1]/aw-primary-workarea[1]/div[1]/aw-include[1]/div[1]/div[1]/aw-splm-table[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div["
							+ i + "]/div/div/div/div[3]/img"));
			System.out.println("Row number is: " + i + "  symbol is: " + RowText.getAttribute("class"));
			if (RowText.getAttribute("class").equals("aw-base-icon")) {
				getprint_custom("base icon is prsent: ", RowText.getAttribute("class"));
				System.out.println("base icon is prsent ");
			}
		}
	}

//	----------------------------------------------------------------------------------------------------
//	----------------------------------------------------------------------------------------------------
	public void verify_BOM_Structure(List<String> list) throws InterruptedException {
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(reset).click();
		DriverFactory.getInstance().getDriver().findElement(resetOk).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(expand).click();
		DriverFactory.getInstance().getDriver().findElement(expandBelow).click();
		Thread.sleep(3000L);

		int rowcount = DriverFactory.getInstance().getDriver().findElements(tabel_rows).size();
		System.out.println("Number of rows count :" + rowcount);
		int z = 0;
		for (int i = 1; i <= rowcount; i++) {
			WebElement rowText = DriverFactory.getInstance().getDriver().findElement(
					By.xpath("//div[@class='aw-splm-tableViewport aw-splm-tableCanvas']/div/div[" + i + "]"));
			System.out.println("RowText_ItemName: " + i + "=" + rowText.getText());
			Thread.sleep(3000);
			int column = DriverFactory.getInstance().getDriver().findElements(By.xpath(
					"//aw-splm-table[@class='ng-isolate-scope']/div/div[@class='aw-splm-tableContainer']/div[@class='aw-splm-tableScrollContainer']/div[2]/div/div["
							+ i + "]/div[@class='ui-grid-cell']"))
					.size();

			System.out.println("Number of columns : " + column);

			String columValue_itemID = DriverFactory.getInstance().getDriver().findElement(By.xpath(
					"//aw-splm-table[@class='ng-isolate-scope']/div/div[@class='aw-splm-tableContainer']/div[@class='aw-splm-tableScrollContainer']/div[2]/div/div["
							+ i + "]//div[@class='ui-grid-cell'][" + 1 + "]/div"))
					.getAttribute("title");
			String columValue_level = DriverFactory.getInstance().getDriver().findElement(By.xpath(
					"//aw-splm-table[@class='ng-isolate-scope']/div/div[@class='aw-splm-tableContainer']/div[@class='aw-splm-tableScrollContainer']/div[2]/div/div["
							+ i + "]//div[@class='ui-grid-cell'][" + 5 + "]/div"))
					.getAttribute("title");
			int levelInt = Integer.parseInt(columValue_level);
			int printLevel = z + 1;
			System.out.println("Item ID: " + columValue_itemID + " level: " + columValue_level);
			// ------Condition to check Item Levels in BOM Structure

			if (home_Page.itemID.contains(columValue_itemID))// && levelInt == 0)
			{
				Assert.assertEquals(levelInt, 0, "Level is MAching");
				System.out.println("Parent Level Matching: " + columValue_level + " " + columValue_itemID);
				getprint_custom("Item Level Matching: " + columValue_itemID, columValue_level);
			} else if (list.get(z).equals(columValue_itemID))// && printLevel == levelInt)
			{

				Assert.assertEquals(levelInt, printLevel, "Level is Maching");
				System.out.println("Child Level Matching: " + printLevel + " " + columValue_itemID);
				z++;
			} else {
				System.out.println("Level is Not Matching: " + columValue_itemID);
			}

		}
	}

	public void BOM_ContentRevisionRuleSearch(String revRule) throws InterruptedException {
		WebElement m = DriverFactory.getInstance().getDriver().findElement(revision_Rule);
		System.out.println("This is previous Revision Rule: " + m.getText());
		DriverFactory.getInstance().getDriver().findElement(DDrevision_Rule).click();
		DriverFactory.getInstance().getDriver().findElement(filter).sendKeys(revRule);
		Thread.sleep(3000L);
		boolean flag=DriverFactory.getInstance().getDriver().findElement(list_revision_Rule).isDisplayed();
		System.out.println("Drop Down value" + flag);
		if(flag==true) {
			DriverFactory.getInstance().getDriver().findElement(list_revision_Rule).click();	
		}else {
		DriverFactory.getInstance().getDriver().findElement(filter).sendKeys(Keys.ENTER);	
		}
		Thread.sleep(3000L);
		System.out.println("This is new Revision Rule: " + m.getText());
	}
}
