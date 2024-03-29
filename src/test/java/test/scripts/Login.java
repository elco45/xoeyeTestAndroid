package test.scripts;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import test.testRunner;

public class Login {

    private AndroidDriver driver;
    private Wait<WebDriver> wait;

    @Before
    public void startApp() throws MalformedURLException {
        driver = testRunner.driver;
        wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
    }

    @Given("^A ([^\"]*) username$")
    public void A_something_username(String arg2) {
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'Log In']")).click();
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        if (arg2.equals("valid")) {
            emailField.sendKeys("ricardo@acklenavenue.com");
        } else if (arg2.equals("invalid")) {
            emailField.sendKeys("a@a.a");
        }
    }

    @And("^A ([^\"]*) password$")
    public void A_something_password(String arg3) {
        WebElement passField = driver.findElement(By.id("password"));
        passField.clear();
        if (arg3.equals("valid")) {
            passField.sendKeys("password123");
        } else if (arg3.equals("invalid")) {
            passField.sendKeys("meow");
        }
    }

    @When("^I submit the credentials$")
    public void I_submit_the_credentials() {
        driver.pressKeyCode(66);
    }

    @Then("^I ([^\"]*) login")
    public void I_something_login(String arg4) {
        if (arg4.equals("cannot")) {
            Assert.assertEquals(true, driver.findElementByAccessibilityId("Sorry, we were not able to find a user with that username and password.").isDisplayed());
        } else {
            Assert.assertEquals(true, driver.findElement(By.xpath("//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[2]//*[1]")).isDisplayed());
        }
    }
}
