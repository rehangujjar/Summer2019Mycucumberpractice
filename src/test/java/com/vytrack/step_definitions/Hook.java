package com.vytrack.step_definitions;



import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {
    //make sure @before and after annotation coming from io.cucumber.java.before and io.cucumber.java.After;
    // cucumber not ganna work on  junit  imports
   @Before
    public void setup(){

       System.out.println("###############################");
        System.out.println("Test setup!");
      BrowserUtils.wait(4);
        Driver.get().manage().window().maximize();
    }

    @After
                       // Scenario from Cucumber imports api imports not other when we create parameter
    public void teardown(Scenario scenario){
        //if test failed (isFailed) do this other wise cleanuo and test
        if(scenario.isFailed()){
            System.out.println("tests failed");
            byte[] screenshot= ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png","name of screen shot");

        }
        else{
            System.out.println("Cleanup");
            System.out.println("Test completed");
        }

        System.out.println("###############################");
        //After every test Scenario Browser ganna close
        Driver.close();
    }
}
