package com.epam.lab.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePO {
    private static final Logger LOG = LogManager.getLogger(GmailHomePO.class);

    private static final String SETUP_ADDRESS_LIST_ID = "com.google.android.gm:id/setup_addresses_list";
    private static final int EXPLICITY_WAIT_TIMEOUT = 20;

    @FindBy(id = "com.google.android.gm:id/welcome_tour_got_it")
    private WebElement welcomeTourGotItBtnElement;
    @FindBy(id = "com.google.android.gm:id/action_done")
    private WebElement actionDoneBtnElement;
    @FindBy(id = "com.google.android.gm:id/setup_addresses_list")
    private WebElement availableAddressesElement;
    @FindBy(id = "com.google.android.gm:id/compose_button")
    private WebElement composeBtnElement;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/thread_list_view']/android.view.View[1]")
    private WebElement receivedEmail;
    @FindBy(id = "com.google.android.gm:id/subject_and_folder_view")
    private WebElement receivedEmailSubject;

    private AppiumDriver<MobileElement> driver;

    public GmailHomePO(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWelcomeGotItBtn() {
        LOG.info("Click 'welcome_got_it' button");
        welcomeTourGotItBtnElement.click();
    }

    public void clickActionDoneBtn() {
        LOG.info("Click 'action_done' button");
        Wait wait = new WebDriverWait(driver, EXPLICITY_WAIT_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(SETUP_ADDRESS_LIST_ID)));
        actionDoneBtnElement.click();
    }

    public void clickComposeBtn() {
        LOG.info("Click 'compose' button");
        composeBtnElement.click();
    }

    public void clickReceivedEmail() {
        LOG.info("Click on last received email item");
        receivedEmail.click();
    }

    public String getReceivedEmailSubject() {
        LOG.info("Get received email subject");
        return receivedEmailSubject.getText();
    }
}