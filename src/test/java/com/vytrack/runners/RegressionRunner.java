package com.vytrack.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       features ={
               "src\\test\\resources\\features\\activities",
               "src\\test\\resources\\features\\fleet"
       },
        glue = "com\\vytrack\\step_definitions",
        dryRun = false,
//this time run by feature  option by activities folder
//     tags = "@calender_events",
        plugin={"html:target/default-cucumber-reports",
        "json:target/cucumber.json",
                "rerun:target/rerun.txt"
       }
        // in the plugin we generate report which later on show us in the targer.default-cucumber-reports under the resource file
        //inside the target because that was the path html:target/default-cucumber-reports
)


public class RegressionRunner {
}
