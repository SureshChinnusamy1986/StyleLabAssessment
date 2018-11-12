package com.stylelabs.assessment.stylelabsAssesment.StepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;


public class GoogleSearch {
    WebDriver driver = null;


    @Given("^user navigated to google$")
    public void user_navigated_to_google() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    @When("^the page is loaded$")
    public void the_page_is_loaded() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");

    }


    @Then("^search for \"([^\"]*)\"$")
    public void search_for_Bahamas(String searchText) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(searchText);
        element.submit();

    }


    @Then("^take screenshot of the result page$")
    public void take_screenshot_of_the_result_page() throws InterruptedException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("src/test/resources/Screenshot/Google.png"));
            System.out.print("ScreenShot Taken");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(2000);
        driver.close();

    }


}