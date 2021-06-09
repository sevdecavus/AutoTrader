package com.autotrader.runnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"
                 },
        glue = "com/autotrader/stepDefinitions/AutoTraderSteps",
        features = "features/AutoTrader",
        dryRun= false,
        tags = "@integration_test"
)
public class RunnerClass {

}
