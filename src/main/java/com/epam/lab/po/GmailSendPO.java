package com.epam.lab.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSendPO {
    private static final Logger LOG = LogManager.getLogger(GmailSendPO.class);

    @FindBy(id = "com.google.android.gm:id/subject")
    private WebElement subjectInputElement;
    @FindBy(id = "com.google.android.gm:id/body_wrapper")
    private WebElement messageInputElement;
    @FindBy(id = "com.google.android.gm:id/to")
    private WebElement toInputElement;
    @FindBy(id = "com.google.android.gm:id/send")
    private WebElement sendBtnElement;

    private AppiumDriver<MobileElement> driver;

    public GmailSendPO(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillSubjectInputElement(String subject) {
        LOG.info("Send keys to subject input element");
        subjectInputElement.sendKeys(subject);
    }

    public void fillMessageInputElement(String message) {
        LOG.info("Send keys to massage input element");
        messageInputElement.sendKeys(message);
    }

    public void fillToInputElement(String to) {
        LOG.info("Send keys to 'address to' input element");
        toInputElement.sendKeys(to);
    }

    public void clickSendBtnElement() {
        LOG.info("Click 'send_email' icon");
        sendBtnElement.click();
    }
}