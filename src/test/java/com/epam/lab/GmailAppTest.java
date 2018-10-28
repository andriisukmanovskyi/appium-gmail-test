package com.epam.lab;


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
    private static final String DEVICE_NAME_CAPABILITY = "deviceName";
    private static final String DEVICE_NAME_CAPABILITY_VALUE = "MTP32443204437";
    private static final String PLATFORM_NAME_CAPABILITY = "platformName";
    private static final String PLATFORM_NAME_CAPABILITY_VALUE = "Android";
    private static final String PLATFORM_VERSION_CAPABILITY = "platformVersion";
    private static final String PLATFORM_VERSION_CAPABILITY_VALUE = "4.4.2";
    private static final String APP_PACKAGE_CAPABILITY = "appPackage";
    private static final String APP_PACKAGE_CAPABILITY_VALUE = "com.google.android.gm";
    private static final String APP_ACTIVITY_CAPABILITY = "appActivity";
    private static final String APP_ACTIVITY_CAPABILITY_VALUE = "ConversationListActivityGmail";

    private static final String URL = "http://127.0.0.1:4723/wd/hub";

    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void initDriver() {
        DesiredCapabilities capabilities = getDesiredCapabilities();
        try {
            driver = new AndroidDriver<>(new URL(URL), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(DEVICE_NAME_CAPABILITY, DEVICE_NAME_CAPABILITY_VALUE);
        capabilities.setCapability(PLATFORM_NAME_CAPABILITY, PLATFORM_NAME_CAPABILITY_VALUE);
        capabilities.setCapability(PLATFORM_VERSION_CAPABILITY, PLATFORM_VERSION_CAPABILITY_VALUE);
        capabilities.setCapability(APP_PACKAGE_CAPABILITY, APP_PACKAGE_CAPABILITY_VALUE);
        capabilities.setCapability(APP_ACTIVITY_CAPABILITY, APP_ACTIVITY_CAPABILITY_VALUE);
        return capabilities;
    }

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        MobileElement element = driver.findElement(By.id("com.google.android.gm:id/welcome_tour_got_it"));
        element.click();
        Thread.sleep(10000);
        element = driver.findElement(By.id("com.google.android.gm:id/action_done"));
        element.click();
//        element = driver.findElement(By.id("com.google.android.gm:id/compose_button"));
//        element.click();
//        element = driver.findElement(By.id("com.google.android.gm:id/subject"));
//        element.click();
//        element.sendKeys("test subject");
//        element = driver.findElement(By.id("com.google.android.gm:id/body_wrapper"));
//        element.click();
//        element.sendKeys("test message");
//        element = driver.findElement(By.id("com.google.android.gm:id/to"));
//        element.sendKeys("andriy27111995@gmail.com");
//        element = driver.findElement(By.id("com.google.android.gm:id/send"));
//        element.click();
        element = driver.findElement(By.xpath("//*[@resource-id='com.google.android.gm:id/thread_list_view']/android.view.View[1]"));
        element.click();
        element = driver.findElement(By.id("com.google.android.gm:id/subject_and_folder_view"));
        Assert.assertTrue(element.getText().contains("test"));
    }
}
