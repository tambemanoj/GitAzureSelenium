package com.tc_awc.pageobjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class item_Page extends TestBase {
	private static String downloadPath = "C:\\Users\\fbtcuser\\Downloads";
	public WebDriverWait wt;
	By newItem = By.xpath("//button[@id='Awp0NewGroup']");
	By saveAs = By.xpath("//li[@id='Awp0ShowSaveAs']");
	By convertToBuild = By.xpath("//button[@id='ConvertToBuildWIP']");
	By itemLabel = By.xpath("//div[@class='aw-layout-locationTitle aw-layout-flexRow ng-binding ng-scope']");
	By release_status = By
			.xpath("//ul[@class='aw-jswidgets-arrayNonEditValueCellList']/li/aw-property-non-edit-val/div/div/a");
	By content = By.xpath("//a[normalize-space()='Content']");
	By whereUsed = By.xpath("//a[normalize-space()='Where Used']");
	By attachments = By.xpath("//a[normalize-space()='Attachments']");
	By history = By.xpath("//a[normalize-space()='History']");
	By particicpants = By.xpath("//a[normalize-space()='Participants']");
	By attachment_addto = By.xpath("//aw-walker-objectset[@titlekey='tc_xrt_Files']//button[@id='Awp0ShowAddObject']");
	By attachment_addto_frameLabel = By.xpath("//div[@class='gwt-Label ng-binding']");
	By attachment_addto_chooseFileBtn = By.xpath("//input[@ng-model='file.fmsFile']");
	By attachment_addto_Name = By
			.xpath("//div[contains(@class,'aw-widgets-innerWidget')]//input[@placeholder='Required']");
	By attachment_addto_Relation = By.xpath("//aw-listbox[@prop='data.creationRelation']//input[@type='text']");
	By attachment_addto_Rel_dropdownList = By.xpath(
			"//div[contains(@class,'aw-jswidgets-listboxDrop aw-jswidgets-drop aw-base-scrollPanel aw-jswidgets-page ng-scope')]//ul[contains(@class,'aw-widgets-cellListWidget')]/li");
	By attachment_addto_addBtn = By
			.xpath("//button[contains(@visible-when,'commandPanelForm.$valid&&conditions.isNewTabAddButtonVisible')]");
	By popup = By.xpath("//span[contains(@class,'noty_text')]");
	By attachment_datasetList = By.xpath("//ul[@class='aw-widgets-cellListWidget aw-layout-flexColumnContainer']/li");
	By attachment_downloadBtn = By.xpath("(//*[name()='svg'])[32]");

	// Actions:
	public void clickContentOption() throws InterruptedException {
		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(content).click();

	}

	public void getconvertToBuild() {
		DriverFactory.getInstance().getDriver().findElement(convertToBuild).click();
	}

	public void clicknewItem_saveAs() throws InterruptedException {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(newItem));
		// Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(newItem).click();
		wt.until(ExpectedConditions.elementToBeClickable(saveAs));
		DriverFactory.getInstance().getDriver().findElement(saveAs).click();

	}

	public void uploadDataset() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(2000L);
		Assert.assertEquals(DriverFactory.getInstance().getDriver().findElement(itemLabel).getText(),
				"P0000654-01-tt2");
		DriverFactory.getInstance().getDriver().findElement(attachments).click();
		Thread.sleep(2000L);
		DriverFactory.getInstance().getDriver().findElement(attachment_addto).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(attachment_addto_frameLabel));
		WebElement m = DriverFactory.getInstance().getDriver().findElement(attachment_addto_chooseFileBtn);
		// Action class to move and click element
		Actions a = new Actions(DriverFactory.getInstance().getDriver());
		a.moveToElement(m).click().build().perform();
		Thread.sleep(2000L);
		Runtime.getRuntime().exec("\\src\\main\\java\\testData\\testFile.exe");
		Thread.sleep(2000L);
		String fileName = DriverFactory.getInstance().getDriver().findElement(attachment_addto_Name)
				.getAttribute("value");
		System.out.println("fileName: " + fileName);
		DriverFactory.getInstance().getDriver().findElement(attachment_addto_Relation).click();
		List<WebElement> list = DriverFactory.getInstance().getDriver().findElements(attachment_addto_Rel_dropdownList);
		System.out.println("List Size: " + list.size());

		for (WebElement we : list) {
			try {
				Thread.sleep(2000L);
				if (we.getText().contains("Specifications")) {

					we.click();
					break;
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Please handle the element if it get change: reinitialize");
			}

		}
		DriverFactory.getInstance().getDriver().findElement(attachment_addto_addBtn).click();
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(popup));
		Thread.sleep(1000L);
		String mesg = DriverFactory.getInstance().getDriver().findElement(popup).getText();
		System.out.println("PopUp Message: " + mesg);
		// Assert.assertEquals(mesg, '"' + fileName + '"' + " was added.");
		assertEqualsString_custom(mesg, '"' + fileName + '"' + " was added.", "Popup Message");
		String[] msgSplit = mesg.split(" ", 2);
		for (String msg : msgSplit) {
			System.out.println(msg);

		}

	}

	public void downloadDataset() throws InterruptedException {
		String fileName = null;
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(2000L);
		Assert.assertEquals(DriverFactory.getInstance().getDriver().findElement(itemLabel).getText(),
				"P0000654-01-tt2");
		DriverFactory.getInstance().getDriver().findElement(attachments).click();
		Thread.sleep(2000L);
		List<WebElement> list = DriverFactory.getInstance().getDriver().findElements(attachment_datasetList);
		System.out.println("List Size: " + list.size());
		for (WebElement we : list) {

			Thread.sleep(2000L);
			if (we.getText().contains("test")) {
				fileName = we.getText();
				we.click();
				break;
			}
		}

		String[] labelSplit = fileName.split("T");
		System.out.println(labelSplit[0]);
		for (int i = 0; i < labelSplit.length; i++) {
			System.out.println("FileName : " + i + "=" + labelSplit[i]);
			fileName = labelSplit[0];
			System.out.println("FileName : " + fileName.trim() + ".txt");
		}
		// System.out.println("FileName : "+fileName+".txt");
		DriverFactory.getInstance().getDriver().findElement(attachment_downloadBtn).click();
		Thread.sleep(2000L);
		Assert.assertTrue(isFileDownloaded(downloadPath, fileName.trim() + ".txt"),
				"Failed to download Expected document");
	}

	// to check the download file
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			// System.out.println("File Name"+dir_contents[i].getName());
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

}
