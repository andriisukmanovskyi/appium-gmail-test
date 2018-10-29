package com.epam.lab.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSendPO {

    @FindBy(id = "com.google.android.gm:id/subject")
    private MobileElement subjectInputElement;
    @FindBy(id = "com.google.android.gm:id/body_wrapper")
    private MobileElement messageInputElement;
    @FindBy(id = "com.google.android.gm:id/to")
    private MobileElement toInputElement;
    @FindBy(id = "com.google.android.gm:id/send")
    private MobileElement sendBtnElement;

    private AppiumDriver<MobileElement> driver;

    public GmailSendPO(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillSubjectInputElement(String subject) {
        subjectInputElement.sendKeys(subject);
    }

    public void fillMessageInputElement(String message) {
        messageInputElement.sendKeys(message);
    }

    public void fillToInputElement(String to) {
        toInputElement.sendKeys(to);
    }

    public void clickSendBtnElement() {
        sendBtnElement.click();
    }
}