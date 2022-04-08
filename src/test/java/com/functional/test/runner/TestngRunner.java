package com.functional.test.runner;
 
import com.funtional.test.SeleniumAbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(tags = "", features = "src/test/resources/features/Purchasedevicelabplanonbrowserstackapplication.feature", glue = "com.functional.test.stepdefs")
 
public class TestngRunner extends SeleniumAbstractTestNGCucumberTests {
 
}