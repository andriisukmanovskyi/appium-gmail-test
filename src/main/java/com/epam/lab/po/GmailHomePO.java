package com.epam.lab.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePO {

    @FindBy(id = "com.google.android.gm:id/welcome_tour_got_it")
    private MobileElement welcomeTourGotItBtnElement;
    @FindBy(id = "com.google.android.gm:id/action_done")
    private MobileElement actionDoneBtnElement;
    @FindBy(id = "com.google.android.gm:id/compose_button")
    private MobileElement composeBtnElement;
    private MobileElement receivedEmail;

    private AppiumDriver<MobileElement> driver;

    public GmailHomePO(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWelcomeGotItBtn() {
        welcomeTourGotItBtnElement.click();
    }

    public void clickActionDoneBtn() {
        actionDoneBtnElement.click();
    }

    public void clickComposeBtn() {
        composeBtnElement.click();
    }

    public boolean isReceivedEmailDisplayed(String partialSubject) {
        try {
            return driver.findElement(By.xpath("(//android.view.View[contains(@content-desc, " + partialSubject + ")])[1]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}