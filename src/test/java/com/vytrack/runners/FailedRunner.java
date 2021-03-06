package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="@target/rerun.txt",
        glue = "com\\vytrack\\step_definitions",
       // dryRun = false,
      // no need for failed dryrun adn tags  here
        //tags = "@smoke_test",
        plugin={"html:target/default-cucumber-reports"
                //, "json:target/cucumber.json"
             // "rerun:target/rerun.txt"
        }
)
public class FailedRunner {
}
