package com.autotrader.stepDefinitions;

import com.autotrader.utilities.ConfigurationReader;
import com.autotrader.utilities.MyDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hook {
    Logger logger = LoggerFactory.getLogger(Hook.class);

    @Before
    public void setup() {
        logger.info("##### SETUP STARTED (HOOK) ######");
        MyDriver.get().manage().window().maximize();

        MyDriver.get().get(ConfigurationReader.getProperty("url"));
        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()){
            logger.info("!!!!Test Failed! check the screenshot!!!!");
            logger.error("!!!!Test Failed! check the screenshot!!!!");
            byte[] screenshot= ((TakesScreenshot)MyDriver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"images/png","Screenshot");
           // scenario.embed(screenshot,"images/png"); version 4.7.4
            scenario.attach(screenshot, "image/png", "attached screenshot");

        }else {
            logger.info("Test Completed");
            System.out.println("Cleanup");
        }
         logger.info("###### END OF TESTS #####");

        MyDriver.close();
    }
}
