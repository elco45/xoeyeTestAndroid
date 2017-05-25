package test;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = "pretty",
        features = {"src/test/java/test/features/"}
)
public class testRunner {

    public static AndroidDriver driver;


    @BeforeClass
    public static void startApp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "5.0.1"); //Replace this with your Android version
        caps.setCapability("deviceName", "Android Samsung Galaxy 8"); //Replace this with your simulator/device 
        caps.setCapability("app", "/Users/dennischeong/Downloads/XOEYEAndroid.apk"); //Replace this with app path in your system
        caps.setCapability("--session-override", false);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }
    
    @AfterClass
    public static void endApp(){
        driver.quit();
    }
}
