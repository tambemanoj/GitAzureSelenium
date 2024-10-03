package com.tc_awc.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class convertToBuildWIP_Page extends TestBase {
	public WebDriverWait wt;

	home_Page hp = new home_Page();

	// Page Factory
	By backbtn = By.xpath("//*[@id='Awp0GoBack']");
	By Item = By.xpath(
			"//*[@id='main-view']/aw-include/div/div/div/div/div/ui-view/aw-showobject-page/div/div/div/div[3]/div/ng-transclude/aw-xrt-sublocation/aw-sublocation/div/div[2]/div/aw-sublocation-body/div/aw-xrt-2/aw-walker-view/div[1]/aw-walker-element/div[1]/form/aw-walker-element/div/div/aw-walker-objectset/div[2]/aw-list/div/div/div/ul/li[2]/div/div[2]/aw-default-cell/div");
	By redirect = By.xpath(
			"//aw-list[@class='ng-scope ng-isolate-scope']//li[@class='aw-widgets-cellListItem aw-widgets-cellTop ng-scope aw-widgets-cellListItemSelected']//aw-command[@id='0']");
	//By convertToWIP = By.id("ConvertToBuildWIP");
//	By convertToWIP = //div[@class='aw-commands-showIconLabel aw-commands-commandIconButtonText ng-binding'][normalize-space()='Convert To Build WIP']
	By convertToWIP = By.xpath("//button[@id='ConvertToBuildWIP']");
	//By convertToWIP = By.id("//div[@class='aw-commands-showIconLabel aw-commands-commandIconButtonText ng-binding'][normalize-space()='Convert To Build WIP']");
	By newWIPStatus = By.xpath(
			"//div[contains(@class,'aw-layout-flexRowContainer aw-widget-iconParent ng-scope')]//input[@placeholder='Required']");
	By newWIPStatusList = By
			.xpath("//div[contains(@class,'aw-jswidgets-listboxDrop')]/ul[@class='aw-widgets-cellListWidget']/li");
	By convertBtn = By.xpath("//div[@class='aw-layout-panelFooter ng-scope']");
	By popup = By.xpath("//div[@class='noty_message']/span[@class='noty_text']");

//	Actions

	public void ConvertToWIP(String newReleaseStatus) throws InterruptedException {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		click_custom(DriverFactory.getInstance().getDriver().findElement(backbtn), "Clicked on back button");
		Thread.sleep(2000L);
		wt.until(ExpectedConditions.visibilityOfElementLocated(Item));
		click_custom(DriverFactory.getInstance().getDriver().findElement(Item), "Clicked on old Item ");
		wt.until(ExpectedConditions.visibilityOfElementLocated(redirect));
		Thread.sleep(2000L);
		click_custom(DriverFactory.getInstance().getDriver().findElement(redirect), "Clicked on redirect ");
		Thread.sleep(2000L);
		wt.until(ExpectedConditions.elementToBeClickable(convertToWIP));
		try {
		DriverFactory.getInstance().getDriver().findElement(convertToWIP).click();
		}catch (StaleElementReferenceException e) {
			System.out.println("Please handle the element if it get change: reinitialize");
		}
		Thread.sleep(4000L);
		wt.until(ExpectedConditions.visibilityOfElementLocated(newWIPStatus));
		click_custom(DriverFactory.getInstance().getDriver().findElement(newWIPStatus), "Clicked on new WIP Status");
//		click on WIPs Drop down
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(newWIPStatusList);
		Thread.sleep(3000L);
		System.out.println(li.size());
		WebElement q;
//		iterate the list 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			if (newReleaseStatus.equals(q.getText())) {
				q.click();
				getprint_custom(q.getAttribute("value"), "WIP Status : ");
				System.out.println(q.getText());
				break;
			}
		}
		DriverFactory.getInstance().getDriver().findElement(convertBtn).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(popup));
		Thread.sleep(2000L);
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
		System.out.println(pop.getText());
		getprint_custom(pop.getAttribute("value"), "Message");
		Assert.assertEquals("Conversion failed!", pop.getText());

	}

	public void converToAnyWIP(String wipStatus) throws InterruptedException {

		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(convertToWIP));
		DriverFactory.getInstance().getDriver().findElement(newWIPStatus).click();
		Thread.sleep(2000L);
		List<WebElement> list = DriverFactory.getInstance().getDriver().findElements(newWIPStatusList);
		Thread.sleep(3000L);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("dropdown option: " + list.get(i).getText());
			System.out.println("ItemStatus: " + wipStatus);
			Thread.sleep(1000L);
			if (list.get(i).getText().equals(wipStatus)) {
				// click_custom(list.get(i), "Selected_WIP_Status");
				list.get(i).click();
				getprint_custom(list.get(i).getText(), "Convert_WIP_Status");
				break;
			}
		}
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(convertBtn));
		DriverFactory.getInstance().getDriver().findElement(convertBtn).click();
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
		System.out.println(pop.getText());
		getprint_custom(pop.getText(), "Message :");
	}

}
