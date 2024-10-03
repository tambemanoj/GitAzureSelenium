package com.tc_awc.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.utilities.DriverFactory;
import com.tc_awc.utilities.TestBase;

public class login_Page extends TestBase {
	public WebDriverWait wt;
	// Page Factory
	By username = By.xpath("//div[@class='aw-session-signIn']/ul/li/input[@name='userName']");
	By password = By.xpath("//div[@class='aw-session-signIn']/ul/li[2]/input[@type='password']");
	By signIn = By.xpath("//div[@class='aw-session-signIn']/ul/li[3]/div/div[@class='aw-session-signInButton']");
	By errormsg = By.xpath("//div[@class='aw-session-errorMessage ng-binding']");

	// Actions:

	public String validateloginPageTiltle() {
		return DriverFactory.getInstance().getDriver().getTitle();

	}

	public void login() throws Throwable {
	//To get the User credentials from System file**********
		boolean flag1= PropertiesOperations.getPropertyValueByKey("SET.1.UserName").isBlank();
		System.out.println(flag1);
		boolean flag2= PropertiesOperations.getPropertyValueByKey("SET.1.Password").isBlank();
		System.out.println(flag2);
		if (flag1==true && flag2==true) {
			DriverFactory.getInstance().getDriver().findElement(username)
					.sendKeys(PropertiesOperations.getPropertyValueByKey("username"));
			DriverFactory.getInstance().getDriver().findElement(password)
					.sendKeys(PropertiesOperations.getPropertyValueByKey("password"));
			DriverFactory.getInstance().getDriver().findElement(signIn).click();
			// click_custom(DriverFactory.getInstance().getDriver().findElement(signIn),
			// "SignIn Button");
			Thread.sleep(2000L);
			System.out.println("Window Title Name:" + DriverFactory.getInstance().getDriver().getTitle());
		} else {
			DriverFactory.getInstance().getDriver().findElement(username)
					.sendKeys(PropertiesOperations.getPropertyValueByKey("SET.1.UserName"));
			DriverFactory.getInstance().getDriver().findElement(password)
					.sendKeys(PropertiesOperations.getPropertyValueByKey("SET.1.Password"));
			DriverFactory.getInstance().getDriver().findElement(signIn).click();
			// click_custom(DriverFactory.getInstance().getDriver().findElement(signIn),
			// "SignIn Button");
			Thread.sleep(2000L);
			System.out.println("Window Title Name:" + DriverFactory.getInstance().getDriver().getTitle());
		}
		// -------Check the window title for successful login.
		// ------ Window title should be "Teamcenter - Home" after login
		Thread.sleep(3000L);
		wt = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
		wt.until(ExpectedConditions.titleContains("Teamcenter - Home"));
		assertEqualsString_custom("Teamcenter - Home", DriverFactory.getInstance().getDriver().getTitle(),
				"Window Title Name:");
		// Assert.assertEquals(DriverFactory.getInstance().getDriver().getTitle(),
		// "Teamcenter - Home");
		getprint_custom("SignIn Done Successfully", "Message");
	}

	public void login_Negative() throws Throwable {
		DriverFactory.getInstance().getDriver().findElement(username)
				.sendKeys(PropertiesOperations.getPropertyValueByKey("username"));
		DriverFactory.getInstance().getDriver().findElement(password)
				.sendKeys(PropertiesOperations.getPropertyValueByKey("password_N"));
		DriverFactory.getInstance().getDriver().findElement(signIn).click();
//			click_custom(DriverFactory.getInstance().getDriver().findElement(signIn), "SignIn Button");
		Thread.sleep(2000L);
		if (DriverFactory.getInstance().getDriver().findElement(errormsg).isDisplayed()) {
			assertEqualsString_custom("The login attempt failed: either the user ID or the password is invalid.",
					DriverFactory.getInstance().getDriver().findElement(errormsg).getText(), "ErrorMessage");
		}
		Thread.sleep(2000L);
		System.out.println("Window Title Name:" + DriverFactory.getInstance().getDriver().getTitle());
		// Check the window title for successful login.
		// Window title should be "Teamcenter" for login page
		assertEqualsString_custom("Teamcenter", DriverFactory.getInstance().getDriver().getTitle(),
				"Window Title Name:");
		// Assert.assertEquals(DriverFactory.getInstance().getDriver().getTitle(),
		// "Teamcenter");
	}

}
