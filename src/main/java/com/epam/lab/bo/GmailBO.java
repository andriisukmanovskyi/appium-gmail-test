package com.epam.lab.bo;

import com.epam.lab.po.GmailHomePO;
import com.epam.lab.po.GmailSendPO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class GmailBO {

    private AppiumDriver<MobileElement> driver;

    private GmailHomePO gmailHomePO;
    private GmailSendPO gmailSendPO;

    public GmailBO(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        gmailHomePO = new GmailHomePO(driver);
    }

    public void navigateToConversationListActivity() {
        gmailHomePO.clickWelcomeGotItBtn();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gmailHomePO.clickActionDoneBtn();
    }

    public void navigateToSendEmailActivity() {
        gmailHomePO.clickComposeBtn();
        gmailSendPO = new GmailSendPO(driver);
    }

    public void fillSendFieldsAndSendEmail(String to, String subject, String message) {
        gmailSendPO.fillSubjectInputElement(subject);
        gmailSendPO.fillMessageInputElement(message);
        gmailSendPO.fillToInputElement(to);
        gmailSendPO.clickSendBtnElement();
    }

    public boolean isEmailReceived(String partialSubject) {
        return gmailHomePO.isReceivedEmailDisplayed(partialSubject);
    }
}