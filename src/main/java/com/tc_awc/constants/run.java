package com.tc_awc.constants;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;







public class run {
	static TestNG testng;
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		  TestListenerAdapter tla = new TestListenerAdapter(); 
		  testng = new TestNG();
		 
		  
		 List<String> xmlList=new ArrayList<String>();
		 xmlList.add("./testng.xml");
		// xmlList.add("./testng1.xml");
		// xmlList.add("./Runnables/"+args[0]+".xml");
		 //xmlList.add("./Runnables/"+args[1]+".xml");
		 //xmlList.add("./Runnables/testng.xml");
		// xmlList.add("./Runnables/testng1.xml");
		  //testng.addListener(ext);
		  testng.setTestSuites(xmlList);
		  testng.run();
		 
	}

	

}
