package RunnerClass;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features={"src/test/resources/Features/homepage.feature"},glue={"StepDefinitions"},
plugin= {"pretty","html:target/htmlreport.html"})

public class TestRunner extends AbstractTestNGCucumberTests{
	
	

}