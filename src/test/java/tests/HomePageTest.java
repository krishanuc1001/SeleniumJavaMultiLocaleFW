package tests;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.utilities.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {

    ReadProperties readProperties;
    Properties properties;
    DriverFactory driverFactory;
    WebDriver driver;
    HomePage homePage;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        readProperties = new ReadProperties();
        properties = readProperties.initProp();
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver("chrome", properties);
        homePage = new HomePage(driver);
    }

    @Test
    public void validateHomePageHeader() {
        Assert.assertTrue(homePage.getHeader(properties.getProperty("header"))
                .contains(properties.getProperty("expectedHeader")));
    }

    @Test
    public void validateContactFooter() {
        Assert.assertTrue(homePage.isContactPresent(properties.getProperty("contact")));
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
