package com.tc_awc.runnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

public class newRunnable {

	public static void main(String[] args) {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "pom.xml" ));
        request.setGoals( Collections.singletonList( "install" ));
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
        try {
            invoker.execute( request );
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        } 
    } 
}
