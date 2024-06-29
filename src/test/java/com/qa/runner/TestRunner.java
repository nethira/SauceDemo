package com.qa.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/qa/features",
           glue= {"com.qa.stepdefinitions"},
           plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-reports.html"},
           tags="@smoke or @Regression",
           monochrome=true,
           publish=true)

public class TestRunner extends AbstractTestNGCucumberTests{	

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
