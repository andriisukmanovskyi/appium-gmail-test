package com.epam.lab;


import com.epam.lab.bo.GmailBO;
import com.epam.lab.uitls.init.driver.DriverInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GmailAppTest {
    private static final String TEST_DATA_ADDRESS_TO = "andriy27111995@gmail.com";
    private static final String TEST_DATA_SUBJECT = "test subject";
    private static final String TEST_DATA_MESSAGE = "test message";

    private AppiumDriver<MobileElement> driver;
    private GmailBO gmailBO;

    @BeforeClass
    public void init() {
        driver = DriverInit.getDriver();
        gmailBO = new GmailBO(driver);
    }

    @Test
    public void shouldAnswerWithTrue() {
        gmailBO.navigateToConversationListActivity();
        gmailBO.navigateToSendEmailActivity();
        gmailBO.fillSendFieldsAndSendEmail(TEST_DATA_ADDRESS_TO, TEST_DATA_SUBJECT, TEST_DATA_MESSAGE);
        Assert.assertTrue(gmailBO.isEmailReceived(TEST_DATA_SUBJECT));
    }
}