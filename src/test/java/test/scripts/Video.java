package test.scripts;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import test.testRunner;

public class Video {

    private AndroidDriver driver;
    private Wait<WebDriver> wait;

    @Before
    public void startApp() throws MalformedURLException {
        driver = testRunner.driver;
        wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
    }

    @Given("^A user that wants to take a video$")
    public void A_user_that_wants_to_take_a_video() {
        WebElement elFrom = driver.findElement(By.xpath("//android.widget.TextView[@text='VIDEO']"));
        WebElement elTo = driver.findElement(By.xpath("//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[2]//*[2]//*[1]//*[1]//*[1]//*[3]//*[3]//*[1]"));
        new TouchAction((MobileDriver)driver).longPress(elFrom).moveTo(elTo).release().perform();
    }

    @When("^I take the video$")
    public void I_take_the_video() {
        driver.findElement(By.xpath("//android.widget.ImageView[@bounds = '[442,1701][637,1896]']")).click();
    }

    @Then("^I can ([^\"]*) the video$")
    public void I_something_it(String arg2) {
        driver.findElement(By.xpath("//android.view.View[@bounds = '[428,1658][653,1883]']"));
        if (arg2.equals("cancel")) {
            driver.findElement(By.xpath("//android.widget.ImageView[@bounds = '[366,1698][510,1842]']")).click();
        } else {
            driver.findElement(By.xpath("//android.widget.ImageView[@bounds = '[570,1698][714,1842]']")).click();
        }
    }       
}

