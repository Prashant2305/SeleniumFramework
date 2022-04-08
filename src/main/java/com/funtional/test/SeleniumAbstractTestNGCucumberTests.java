package com.funtional.test;

import java.io.FileReader;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.context.AutomationContext;
import com.automation.driver.ImplementWebDriver;
import com.automation.utility.ExtentReport;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.funtional.test.pages.PageObjectManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

public class SeleniumAbstractTestNGCucumberTests extends AbstractTestNGCucumberTests {

	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		ExtentReport extent=new ExtentReport();
		AutomationContext.setExtentreport(extent.startExtenReport());
		AutomationContext.setProp(Utility.readPropertyFile(new FileReader("C:\\Users\\Prashant\\eclipse-workspace\\seleniumfuntionalframework\\src\\test\\resources\\properties\\env.properties")));
	}
	
	@BeforeTest
	public void beforeTest(ITestContext context) {
		AutomationContext.setExtenttest(context);		
		ImplementWebDriver implementwebdriver=new ImplementWebDriver();
		AutomationContext.setDriver(implementwebdriver.createWebDriver("chrome"));	
		PageObjectManager pageobjectmanager=new PageObjectManager();
		AppAutomationContextManager.setPageobjectmanager(pageobjectmanager);
	}

	@BeforeClass
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		AutomationContext.setExtenttestnode(pickleWrapper.getPickle().getName());
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());		
	}


	@DataProvider
	public Object[][] scenarios() {
		if (testNGCucumberRunner == null) {
			return new Object[0][0];
		}
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			AutomationContext.getExtenttestnode().log(Status.FAIL,MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			AutomationContext.getExtenttestnode().log(Status.PASS,MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
		}else {
			AutomationContext.getExtenttestnode().log(Status.SKIP,MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
			AutomationContext.getExtenttestnode().skip(result.getThrowable());
		}
		AutomationContext.getExtentreport().flush();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		if (testNGCucumberRunner == null) {
			return;
		}
		testNGCucumberRunner.finish();
		AutomationContext.getExtentreport().flush();
	}

}
