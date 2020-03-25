package com.vytrack.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       features ="src\\test\\resources\\features",
        glue = "com\\vytrack\\step_definitions",
        dryRun = false,
        //tags will run only required or speciic Scenario from feature file like we call here negative_test  and @driver from feature file
        // tags = "@negative_test "
        //if we want to call only two Scenario we can call by using "or" keyword like we call here negative_test and @driver from feature file
        // tags = "@negative_test or @driver"

        //if we want to run all Scenario except tags like @negative_test scenario we can do this
       // tags = "not @negative_test"
        //and if we want to run all included negative Scenario we have to wrote like this
     tags = "@smoke_test",
      //  tags = "@calender_events";
              //s    tags ="@create_car",
       // tags="@store_manager",
        //if Scenarios have more than 2 tags we can call that by using "And" key word  like in feature file we have negative and driver Scenario together
       // tags = "@negative_test and @driver",
        //we can create any tag name like modules ,type of test, like @smoke, @regression, user story number @Vyt-1234
        // if tags calling annotation are not availabe nothing will run
        //dd in the plugin we
        plugin={"html:target/default-cucumber-reports",
        "json:target/cucumber.json",
                "rerun:target/rerun.txt"
       }
        // in the plugin we generate report which later on show us in the targer.default-cucumber-reports under the resource file
        //inside the target because that was the path html:target/default-cucumber-reports
        //inside the target because that was the path html:target/default-cucumber-reports
)

public class CucumberRunner {
}
