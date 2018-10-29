package com.epam.lab.uitls.init.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverInit {
    private static final Logger LOG = LogManager.getLogger(DriverInit.class);

    private static final String DEVICE_NAME_CAPABILITY_VALUE = "MTP32443204437";
    private static final String PLATFORM_NAME_CAPABILITY_VALUE = "Android";
    private static final String PLATFORM_VERSION_CAPABILITY_VALUE = "4.4.2";
    private static final String APP_PACKAGE_CAPABILITY = "appPackage";
    private static final String APP_PACKAGE_CAPABILITY_VALUE = "com.google.android.gm";
    private static final String APP_ACTIVITY_CAPABILITY = "appActivity";
    private static final String APP_ACTIVITY_CAPABILITY_VALUE = "ConversationListActivityGmail";

    private static final String URL = "http://127.0.0.1:4723/wd/hub";
    private static final int IMPLICITY_WAIT_TIMEOUT = 10;

    public static AppiumDriver<MobileElement> getDriver() {
        AppiumDriver<MobileElement> driver = null;
        DesiredCapabilities capabilities = getDesiredCapabilities();
        try {
            LOG.info("Init driver");
            driver = new AndroidDriver<>(new URL(URL), capabilities);
            driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT_TIMEOUT, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        LOG.info("Set desired capabilities");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME_CAPABILITY_VALUE);
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, PLATFORM_NAME_CAPABILITY_VALUE);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION_CAPABILITY_VALUE);
        capabilities.setCapability(APP_PACKAGE_CAPABILITY, APP_PACKAGE_CAPABILITY_VALUE);
        capabilities.setCapability(APP_ACTIVITY_CAPABILITY, APP_ACTIVITY_CAPABILITY_VALUE);
        return capabilities;
    }
}