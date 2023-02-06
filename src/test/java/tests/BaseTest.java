package tests;

import com.factory.DriverFactory;
import com.utilities.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    ReadProperties readProperties;
    Properties properties;
    DriverFactory driverFactory;
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        readProperties = new ReadProperties();
        properties = readProperties.initProp();
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver("chrome", properties);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driverFactory.quitDriver();
    }
}
