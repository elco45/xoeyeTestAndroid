package com.mycompany.androidcomplex;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import test.testRunner;

public class Photo {

    private AndroidDriver driver;
    private Wait<WebDriver> wait;

    @Before
    public void startApp() throws MalformedURLException {
        driver = testRunner.driver;
        wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
    }

    @Given("^A user that wants to take a photo$")
    public void A_user_that_wants_to_take_a_photo() {

    }

    @When("^I take the photo$")
    public void I_take_the_photo() {
        driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[435,1701][630,1896]']")).click();
    }

    @Then("^I ([^\"]*) it$")
    public void I_something_it(String arg2) {
        if (arg2.equals("cancel")) {
            driver.findElement(By.xpath("//android.widget.ImageView[@bounds = '[366,1698][510,1842]']")).click();
        } else {
            driver.findElement(By.xpath("//android.widget.ImageView[@bounds = '[570,1698][714,1842]']")).click();
        }
    }
}
