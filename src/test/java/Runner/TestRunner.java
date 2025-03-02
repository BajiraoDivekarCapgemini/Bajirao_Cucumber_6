package Runner;



import org.junit.runner.RunWith;

import io.cucumber.core.cli.Main;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = "/src/test/resources/Featurefile",
//               glue = { "StepDefination" })

public class TestRunner {
	public static void main(String[] args) {
		Main.main(new String[]{"-g", "StepDefination", "C:\\Users\\S TECH\\eclipse-workspace\\Bajirao_Selenium_PR\\src\\test\\resources\\Featurefile\\login.feature"});
	}

}
