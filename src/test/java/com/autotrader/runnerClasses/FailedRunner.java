package com.autotrader.runnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber_failure.json",
                "html:target/rerun-default-html-reports"
        },
        glue = "com/autotrader/stepDefinitions/AutoTraderSteps",
        features = {"@target/rerun.txt"}
)
public class FailedRunner {
}
