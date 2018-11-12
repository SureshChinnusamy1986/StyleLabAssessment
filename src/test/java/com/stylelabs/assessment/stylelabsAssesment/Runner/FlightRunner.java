
package com.stylelabs.assessment.stylelabsAssesment.Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" },
        features="src/test/resources/Feature",
        glue="com.stylelabs.assessment.stylelabsAssesment",
tags="@FlightSearch")

public class FlightRunner {

}
