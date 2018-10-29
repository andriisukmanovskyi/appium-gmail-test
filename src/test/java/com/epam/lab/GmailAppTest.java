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
        gmailBO.fillSendFieldsAndSendEmail("andriy27111995@gmail.com", "test subject", "test message");
        Assert.assertTrue(gmailBO.isEmailReceived("test"));
//        MobileElement element = driver.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/thread_list_view']/android.view.View[1]"));
//        element.click();
//        element = driver.findElement(By.id("com.google.android.gm:id/subject_and_folder_view"));
//        Assert.assertTrue(element.getText().contains("test"));
    }
}
