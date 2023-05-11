package com.hudl;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/cucumber/report.html",
        "json:target/cucumber/report.json"}
        , features = {"src/test/resources/Features"}
        , monochrome = true
        , glue = {"com.hudl.steps"}
        , tags = "@regression"
        , dryRun = false
)


public class TestRunner {
}
