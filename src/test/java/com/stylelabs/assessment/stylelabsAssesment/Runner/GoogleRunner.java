
package com.stylelabs.assessment.stylelabsAssesment.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" },
        features="src/test/resources/Feature",
        glue="com.stylelabs.assessment.stylelabsAssesment",
tags="@GoogleSearch")

public class GoogleRunner {

}
