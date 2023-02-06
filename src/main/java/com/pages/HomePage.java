package com.pages;

import com.utilities.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // Create WebElement
    private WebElement getHeaderElement(String headerValue) {
        String headerXpath = "//a[contains(@title, '" + headerValue + "')]";
        return elementUtil.getElement("xpath", headerXpath);
    }

    private WebElement getContactElement(String contactText) {
        String contactXpath = "//a[contains(text(), '" + contactText + "')]";
        return elementUtil.getElement("xpath", contactXpath);
    }

    // Page methods
    public String getHeader(String headerValue) {
        return getHeaderElement(headerValue).getText();
    }

    public boolean isContactPresent(String contactText) {
        return getContactElement(contactText).isDisplayed();
    }


}
