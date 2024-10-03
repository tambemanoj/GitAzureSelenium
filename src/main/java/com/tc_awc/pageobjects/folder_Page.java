package com.tc_awc.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class folder_Page extends TestBase {
	public WebDriverWait wt;
	addItem_Page ap;
	String itemID;
	// Page Factory
	By pageTitle = By.xpath("//div[@class='ng-scope']/div[@title='Home']");
	By newItem = By.xpath("//button[@id='Awp0NewGroup']");
	By addItem = By.xpath("//li[@id='Awp0ShowCreateObject']");
	By addFrameTitle = By.xpath("//div[contains(@class,'gwt-Label')]");
	By folderList = By.xpath(
			"//div[contains(@class,'aw-widgets-cellListContainer')]/div/div/ul[contains(@class,'aw-widgets-cellListWidget')]/li");
	By itemNames = By.xpath(
			"//aw-splm-table[1]/div[@id='ObjectSet_1_Provider']/div[2]/div[2]/div[2]/div[@class='aw-splm-tableScrollContents']/div[contains(@class,'aw-row-icon')]");
	By cellTitle = By.xpath("//div[@id='CellTitle']/h3");
	By itemLabel = By.xpath("//div[@class='aw-widgets-cellListCellTitleBlock']/label");
	By viewBox = By.xpath("//*[name()='svg']");

	// Actions:
	// To get the Page Title "Teamcenter - Home"
	public WebElement getPageTitle() {
		return DriverFactory.getInstance().getDriver().findElement(pageTitle);
	}

	

	public WebElement getaddFrameTitle() {
		return DriverFactory.getInstance().getDriver().findElement(addFrameTitle);
	}

	public List<WebElement> getfolderList() {
		return DriverFactory.getInstance().getDriver().findElements(folderList);
	}

	public List<WebElement> getcellTitle() {
		return DriverFactory.getInstance().getDriver().findElements(cellTitle);
	}

	public List<WebElement> getitemLabel() {
		return DriverFactory.getInstance().getDriver().findElements(itemLabel);
	}

	// To Create New Item
	public void clickNew_Add() throws InterruptedException {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(3000L);
		// System.out.println("Title:" + getPageTitle().getText());
//		try {
//	 		wt.until(ExpectedConditions.visibilityOf(getPageTitle()));
//		} catch (StaleElementReferenceException e) {
//			System.out.println("Please handle the element if it get change: reinitialize");
//		}
		// To click on New button
		DriverFactory.getInstance().getDriver().findElement(newItem).click();
		Thread.sleep(1000L);
		// To click on Add button
		DriverFactory.getInstance().getDriver().findElement(addItem).click();
		wt.until(ExpectedConditions.visibilityOf(getaddFrameTitle()));
		Thread.sleep(1000L);
		Assert.assertEquals(getaddFrameTitle().getText(), "Add");

	}

	// Select the desired folder from list
	public void selectFolder() throws InterruptedException {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		Thread.sleep(2000L);
		System.out.println("Title:" + getPageTitle().getText());
		wt.until(ExpectedConditions.visibilityOf(getPageTitle()));
		// Select the desired folder from list
		List<WebElement> List = getitemLabel();

		System.out.println("CellTitle List Size:" + List.size());
		for (int i = 0; i < List.size(); i++) {
			System.out.println("Item ID :" + List.get(i).getText());
			Thread.sleep(1000L);
			if (List.get(i).getText().equals("P0000654")) {
				Thread.sleep(2000L);
				List.get(i).click();
				Thread.sleep(1000L);
				// identify element svg
				WebElement m = DriverFactory.getInstance().getDriver().findElement(By.xpath(
						"//*[name()='svg']//*[local-name()='polygon' and @points='18,24 0,24 0,6 6,6 6,7 1,7 1,23 17,23 17,15 18,15 ']"));
				// Action class to move and click element
				Actions a = new Actions(DriverFactory.getInstance().getDriver());
				a.moveToElement(m).click().build().perform();
			}

			break;
		}
	}



}
