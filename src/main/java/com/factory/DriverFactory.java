package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;

    public WebDriver initDriver(String browserName, Properties properties) {
        System.out.println("Browser Name => " + browserName.toLowerCase());

        if (Objects.isNull(driver)) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "msedge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("<<======== ENTER CORRECT BROWSER NAME =========>>");
                    break;
            }

            driver.get(properties.getProperty("url"));
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }

}
