package com.stylelabs.assessment.stylelabsAssesment.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearch {
    WebDriver driver = null;

    @Given("^I navigate to the Expedia website$")
    public void i_navigate_to_the_Expedia_website() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.expedia.com");

    }

    @When("^I look for a flight with accommodation from Brussels to New York$")
    public void i_look_for_a_flight_accommodation_from_Brussels_to_New_York() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement elementOrigin = driver.findElement(By.xpath("//*[@id=\"package-origin-hp-package\"]"));
        elementOrigin.click();
        elementOrigin.sendKeys(" Brussels, Belgium (BRU-All Airports)");
        WebElement elementDesgination = driver.findElement(By.xpath("//*[@id=\"package-destination-hp-package\"]"));
        elementDesgination.click();
        elementDesgination.sendKeys(" New York, New York");
        WebElement elementDepDate = driver.findElement(By.xpath("//*[@id=\"package-departing-hp-package\"]"));
        elementDepDate.click();
        elementDepDate.sendKeys("11/26/2018");
        WebElement elementArrDate = driver.findElement(By.xpath("//*[@id=\"package-returning-hp-package\"]"));
        elementArrDate.click();
        elementArrDate.sendKeys("12/29/2018");
        WebElement elementTravelers = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-package\"]/div/ul/li/button"));
        elementTravelers.click();
        WebElement remAdults = driver.findElement(By.xpath(("//*[@id=\"traveler-selector-hp-package\"]/div/ul/li/div/div/div[1]/div[2]/div[2]/button")));
        remAdults.click();
       //increase the child count to 1
        WebElement addChild = driver.findElement(By.xpath(("//*[@id=\"traveler-selector-hp-package\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[4]/button")));
        addChild.click();
        //Select the age as 2
        Select Select = new Select(driver.findElement(By.xpath(("//*[@id=\"traveler-selector-hp-package\"]/div/ul/li/div/div/div[1]/div[3]/div[2]/label[1]/select"))));
        Select.selectByVisibleText("2");
        WebElement search = driver.findElement(By.xpath((" //*[@id=\"search-button-hp-package\"]")));
        search.click();
    }

    @Then("^the result page contains travel option for the chosen destination$")
    public void the_result_page_contains_travel_option_for_the_chosen_destination() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelResultTitle")));
        String actualTitle = driver.getTitle();
        System.out.println("Acutaltitle" +actualTitle);
        String expectedTitle = "New York (and vicinity) Hotel Search Results | Expedia";
        if (actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");
        Thread.sleep(6000);
        driver.close();
    }


}
