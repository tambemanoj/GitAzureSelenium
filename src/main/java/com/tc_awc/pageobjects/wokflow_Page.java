package com.tc_awc.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tc_awc.constants.PropertiesOperations;
//import com.tc_awc.functionaltestcases.string;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

//------ for creating the Workflow Page and 
public class wokflow_Page extends TestBase {
	public WebDriverWait wt;
	public home_Page hp = new home_Page();
	public folder_Page fp = new folder_Page();
	
//	Page Factory
	By more = By.xpath(
			"//*[@id='main-view']/aw-include/div/div/div/div/div/ui-view/aw-showobject-page/div/div/div/div[3]/div/ng-transclude/aw-xrt-sublocation/aw-sublocation/div/div[3]/aw-command-bar/div[3]/button");
	By manage = By.xpath("//*[@id='Awp0ManageGroup']");
	By submitToWorkflow = By.xpath("//*[@id='Awp0NewWorkflowProcess']");
	By template = By.xpath(
			"//*[@id='aw_toolsAndInfo']/div/aw-include/div/div/div[2]/div/form/form/div[1]/form/aw-listbox/aw-widget/div/div/div/aw-property-val/div/div/aw-property-string-val/div/aw-property-lov-val/div/aw-property-error/div/div/input");
	By templateList = By.xpath(
			"//div[contains(@class,'aw-jswidgets-listboxDrop aw-jswidgets-drop aw-base-scrollPanel aw-jswidgets-page ng-scope')]/ul[@class='aw-widgets-cellListWidget']/li");

	By submit = By.xpath("//*[@id='aw_toolsAndInfo']/div/aw-include/div/div/div[2]/div/form/div");
	By popup = By.xpath("//div[@class='noty_message']/span[contains(@class,'noty_text')]");
	By close = By.xpath("//div[@class='noty_message']/div[@class='noty_close']");
//	By MPRelese = By.xpath(
//			"//div[contains(@class='aw-jswidgets-listboxDrop aw-jswidgets-drop aw-base-scrollPanel aw-jswidgets-page ng-scope')]/ul[@class='aw-widgets-cellListWidget']/li[@class='aw-jswidgets-nestingListItem ng-scope']/div[@class='aw-jswidgets-nestingListItemDisplay aw-state-selected aw-state-attention']");

	// Actions

	public void clickOn_submitToWorkflow() {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		boolean flag = DriverFactory.getInstance().getDriver().findElement(more).isDisplayed();
		if (flag == true) {
			click_custom(DriverFactory.getInstance().getDriver().findElement(more), "Clicked on More button");
		} else {
			wt.until(ExpectedConditions.visibilityOfElementLocated(manage));
			DriverFactory.getInstance().getDriver().findElement(manage).click();
		}
		wt.until(ExpectedConditions.visibilityOfElementLocated(manage));
		click_custom(DriverFactory.getInstance().getDriver().findElement(manage), "Clicked on Manage");
		wt.until(ExpectedConditions.visibilityOfElementLocated(submitToWorkflow));
		click_custom(DriverFactory.getInstance().getDriver().findElement(submitToWorkflow),
				"Clicked on submit To Work flow");

	}

	public void selectTemplate(String newReleaseStatus) throws InterruptedException {
		wt.until(ExpectedConditions.visibilityOfElementLocated(template));
		click_custom(DriverFactory.getInstance().getDriver().findElement(template), "Clicked on Template");

		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(templateList);
		Thread.sleep(3000L);
		System.out.println(li.size());
		WebElement q;
//		iterate the list 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			if (newReleaseStatus.equals(q.getText())) {
				q.click();
				getprint_custom(q.getText(), "Selected WIP: ");
				System.out.println(q.getText());
				break;
			}
		}
		click_custom(DriverFactory.getInstance().getDriver().findElement(submit), "Clicked on submit");
		Thread.sleep(2000L);
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
		System.out.println(pop.getText());
//		Assert.assertSame
//		("The following ARVR WIP Part Revisions cannot be released in this workflow: "+hp.itemID+"/01"+"\r\n"
//
//		+"The creation of workflow process has failed.",pop.getText());
		Thread.sleep(2000L);
	//	wt.until(ExpectedConditions.visibilityOfElementLocated(close));
		click_custom(DriverFactory.getInstance().getDriver().findElement(close), "Clicked on close");

	}

	public String getNextReleaseStatus(String WIPStatus) {
		switch (WIPStatus) {
		case "PROTO 0 RELEASE":
			return "PROTO 1 RELEASE";
		case "PROTO 1 RELEASE":
			return "PROTO 2 RELEASE";
		case "EVT 1 RELEASE":
			return "EVT 2 RELEASE";
		case "EVT 2 RELEASE":
			return "EVT 3 RELEASE";
		case "DVT 1 RELEASE":
			return "DVT 2 RELEASE";
		case "DVT 2 RELEASE":
			return "DVT 3 RELEASE";
		default:
			return "";
		}
	}

	public void submitToWorkflowMPRelease() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(template));
		DriverFactory.getInstance().getDriver().findElement(template).click();
		Thread.sleep(1000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(templateList);
		WebElement q;
//				iterate the list 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			if (PropertiesOperations.getPropertyValueByKey("DATA_WORKFLOW_TEMPLATE").equals(q.getText())) {
				q.click();
				getprint_custom(q.getText(), "Workflow Template: ");
				Thread.sleep(2000L);
				break;
			}
		}
		click_custom(DriverFactory.getInstance().getDriver().findElement(submit), "Clicked on submit");
		Thread.sleep(3000L);
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
		System.out.println(pop.getText());
		assertEqualsString_custom("\"" + hp.itemID + "-01-NEW_Item\"" + " was submitted to workflow.", pop.getText(),
				"Message Assertion");
		// Assert.assertEquals("\"" + hp.itemID + "-01-NEW_Item\"" + " was submitted to
		// workflow.", pop.getText());
	}

	public void submitToWorkflowEQRRelease() throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(template));
		DriverFactory.getInstance().getDriver().findElement(template).click();
		Thread.sleep(1000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(templateList);
		WebElement q;
//				iterate the list 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			if (PropertiesOperations.getPropertyValueByKey("DATA_WORKFLOW_TEMPLATE_EQR").equals(q.getText())) {
				q.click();
				getprint_custom(q.getText(), "Workflow Template: ");
				System.out.println(q.getText());
				break;
			}

		}
		click_custom(DriverFactory.getInstance().getDriver().findElement(submit), "Clicked on submit");
		Thread.sleep(3000L);
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
		System.out.println(pop.getText());
		assertEqualsString_custom("\"" + hp.itemID + "-01-NEW_Item\"" + " was submitted to workflow.", pop.getText(),
				"Message Assertion");
		// Assert.assertEquals("\"" + hp.itemID + "-01-NEW_Item\"" + " was submitted to
		// workflow.", pop.getText());
	}

	
//  Higher Release Status ------------------------------------------------------------------------
	public void submitToWorkflowP0(String itemStatusWIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(template));
		DriverFactory.getInstance().getDriver().findElement(template).click();
		Thread.sleep(1000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(templateList);
		WebElement q;

//			iterate the list 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			System.out.println(q.getText());
				if (itemStatusWIP.equals(q.getText())) {
				q.click();
				getprint_custom(q.getText(), "Workflow Template: ");
				Thread.sleep(1000L);
				break;
			}
		}
		DriverFactory.getInstance().getDriver().findElement(submit).click();
		Thread.sleep(3000L);
	WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
	System.out.println(pop.getText());
		//assertEqualsString_custom("\"" + hp.itemID + "-01-NEW_Item\"" + " was submitted to workflow.", pop.getText(),
		//		"Message Assertion");
	}
	public String getNextP0(int k) {
	System.out.println("k :"+ k);
	switch (k) {
	case 1:
		return "PROTO 0 RELEASE";
	case 2:
		return "PROTO 1 RELEASE";
	case 3:
		return "PROTO 2 RELEASE";
	case 4:
		return "PROTO 3 RELEASE";
	default:
		return "";
	}
}
	
	public void submitToWorkflowEVT1(String itemStatusWIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(template));
		DriverFactory.getInstance().getDriver().findElement(template).click();
		Thread.sleep(1000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(templateList);
		WebElement q;

//			iterate the list 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			System.out.println(q.getText());
				if (itemStatusWIP.equals(q.getText())) {
				q.click();
				getprint_custom(q.getText(), "Workflow Template: ");
				Thread.sleep(1000L);
				break;
			}
		}
		DriverFactory.getInstance().getDriver().findElement(submit).click();
		Thread.sleep(3000L);
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
		System.out.println(pop.getText());
		assertEqualsString_custom("\"" + hp.itemID + "-01-NEW_Item\"" + " was submitted to workflow.", pop.getText(),
				"Message Assertion");
	}
	public String getNextEVT1(int k) {
	System.out.println("k :"+ k);
	switch (k) {
	case 1:
		return "EVT 1 RELEASE";
	case 2:
		return "EVT 2 RELEASE";
	case 3:
		return "EVT 3 RELEASE";
	default:
		return "";
	}
}
	
	public void submitToWorkflowDVT1(String itemStatusWIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(template));
		DriverFactory.getInstance().getDriver().findElement(template).click();
		Thread.sleep(1000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(templateList);
		WebElement q;

//			iterate the list 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			System.out.println(q.getText());
				if (itemStatusWIP.equals(q.getText())) {
				q.click();
				getprint_custom(q.getText(), "Workflow Template: ");
				Thread.sleep(1000L);
				break;
			}
		}
		DriverFactory.getInstance().getDriver().findElement(submit).click();
		Thread.sleep(3000L);
		WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
		System.out.println(pop.getText());
		assertEqualsString_custom("\"" + hp.itemID + "-01-NEW_Item\"" + " was submitted to workflow.", pop.getText(),
				"Message Assertion");
	}
	public String getNextDVT1(int k) {
	System.out.println("k :"+ k);
	switch (k) {
	case 1:
		return "DVT 1 RELEASE";
	case 2:
		return "DVT 2 RELEASE";
	case 3:
		return "DVT 3 RELEASE";
	default:
		return "";
	}
}
	
	public void submitToWorkflowPVT1(String itemStatusWIP) throws Throwable {
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(template));
		DriverFactory.getInstance().getDriver().findElement(template).click();
		Thread.sleep(1000L);
		List<WebElement> li = DriverFactory.getInstance().getDriver().findElements(templateList);
		WebElement q;

//	iterate the list 
		for (int i = 0; i < li.size(); i++) {
			q = li.get(i);
			System.out.println(q.getText());
				if (itemStatusWIP.equals(q.getText())) {
				q.click();
				getprint_custom(q.getText(), "Workflow Template: ");
				Thread.sleep(1000L);
				break;
			}
		}
		DriverFactory.getInstance().getDriver().findElement(submit).click();
		Thread.sleep(3000L);
	WebElement pop = DriverFactory.getInstance().getDriver().findElement(popup);
		System.out.println(pop.getText());
		assertEqualsString_custom("\"" + hp.itemID + "-01-NEW_Item\"" + " was submitted to workflow.", pop.getText(),
				"Message Assertion");
	}
	public String getNextPVT1(int k) {
	System.out.println("k :"+ k);
	switch (k) {
	case 1:
		return "PVT 1 RELEASE";
	case 2:
		return "PVT 2 RELEASE";
	default:
		return "";
	}
}
//	-------------------------------------------------------------------------------------
}