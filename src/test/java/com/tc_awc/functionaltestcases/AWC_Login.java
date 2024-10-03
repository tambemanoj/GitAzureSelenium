package com.tc_awc.functionaltestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tc_awc.pageobjects.login_Page;
import com.tc_awc.utilities.TestBase;

import app.getxray.xray.testng.annotations.XrayTest;
/*
*1.1.Active WorkSpace Correct Login.
 1.2 Active WorkSpace Incorrect Login.
*/

@Listeners({ app.getxray.xray.testng.listeners.XrayListener.class })
public class AWC_Login extends TestBase {
	
//	Active WorkSpace Correct Login
	@Test
	@XrayTest(key = "AB-7")
	public void login() throws Throwable {
		login_Page lp = new login_Page();
		lp.login();
		Thread.sleep(2000L);
	}

//	Active WorkSpace Incorrect Login
	@Test
	@XrayTest(key = "AB-8")
	public void Incorrect_login() throws Throwable {
		login_Page lp = new login_Page();
		lp.login_Negative();
		Thread.sleep(2000L);
	}
}
