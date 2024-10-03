package com.tc_awc.runnable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Listeners;

import com.tc_awc.constants.PropertiesOperations;
import com.tc_awc.functionaltestcases.AWC_Login;
import com.tc_awc.jira.WithTestExecutionKey_XrayResultImporter;
import com.tc_awc.jira.createJiraIssue_TestExecution;
import com.tc_awc.listeners.ListenersImplementation;
import com.tc_awc.utilities.TestBase;

public class Executable {

	static TestNG testng;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, InterruptedException {
		//System.out.println(args.length);
		String automaticJiraCteation=PropertiesOperations.getPropertyValueByKey("automatic_Issue_Creation_In_JIRA");
		System.out.println("automaticJiraCteation :"+automaticJiraCteation);
		if(automaticJiraCteation.equalsIgnoreCase("ON")) {
		// To get Issue ID*******************
				createJiraIssue_TestExecution jiraIssue = new createJiraIssue_TestExecution();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
				Date date = new Date();
				String actualDate = format.format(date);
				System.out.println("Date :" + actualDate);
				String issueS = "Automation Test Execution - " + actualDate;
				String issueD = "Automated Test Execution.";
				String issueNumber = null;
				try {
					issueNumber = jiraIssue.createJiraIssue("AB", issueS, issueD);
					System.out.println(" issueNumber " + issueNumber);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		
		
		// TODO Auto-generated method stub
		ListenersImplementation ext =new ListenersImplementation();
		
		  TestListenerAdapter tla = new TestListenerAdapter(); 
		  testng = new TestNG();
		 
		  
		 List<String> xmlList=new ArrayList<String>();
		 xmlList.add("./testng.xml");
		// xmlList.add("./testng1.xml");
		 xmlList.add("./Runnables/"+args[0]+".xml");
		 //xmlList.add("./Runnables/"+args[1]+".xml");
		 //xmlList.add("./Runnables/testng.xml");
		// xmlList.add("./Runnables/testng1.xml");
		  testng.addListener(ext);
		  testng.setTestSuites(xmlList);
		  testng.run();
		 
		//**********************************************************************
			//need to add testNG Run command to get parameterization  use main arg 
		
			// ************************************************************************
			Thread.sleep(2000L);
			System.out.println(System.getProperty("user.dir"));
			
			// credentials used for Xray cloud requests
			String clientId = System.getenv().getOrDefault("CLIENT_ID", "7FCD1B3BBB054C129DCC8135049B4567");
			String clientSecret = System.getenv().getOrDefault("CLIENT_SECRET",
					"f9aabafe556c2db17cfdbeb4c1fd20747fa224af3536f69b92ab57cf363e714d");

			// auxiliary variables
			// String xrayJsonDCReport = "./src/main/resources/xray_dc.json";
			// String xrayJsonCloudReport = "./src/main/resources/xray_cloud.json";
			// String junitReport = "./src/main/resources/junit.xml";
			String testngReport = "./target/surefire-reports/testng-results.xml";
			//String testngReport ="./test-output/testng-results.xml";
			String response = null;
			WithTestExecutionKey_XrayResultImporter xrayImporter;
			
			try {

				//(Xray cloud): Importing a testng XML report
				xrayImporter = new WithTestExecutionKey_XrayResultImporter.CloudBuilder(clientId, clientSecret)
						.withProjectKey("AB").withTestExecKey(issueNumber).build();
				response = xrayImporter.submitStandardCloud(WithTestExecutionKey_XrayResultImporter.TESTNG_FORMAT,
						testngReport);
				System.out.println("response: " + response);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			System.exit(0);
		}
	else {
		ListenersImplementation ext =new ListenersImplementation();
		
		  TestListenerAdapter tla = new TestListenerAdapter(); 
		  testng = new TestNG();
		 
		  
		 List<String> xmlList=new ArrayList<String>();
		 xmlList.add("./testng.xml");
		// xmlList.add("./testng1.xml");
		// xmlList.add("./Runnables/"+args[0]+".xml");
		 //xmlList.add("./Runnables/"+args[1]+".xml");
		 //xmlList.add("./Runnables/testng.xml");
		// xmlList.add("./Runnables/testng1.xml");
		  testng.addListener(ext);
		  testng.setTestSuites(xmlList);
		  testng.run();
		 
	}

	}
}
