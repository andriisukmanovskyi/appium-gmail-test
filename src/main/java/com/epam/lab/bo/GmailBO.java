package com.epam.lab.bo;

import com.epam.lab.po.GmailHomePO;
import com.epam.lab.po.GmailSendPO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailBO {
    private static final Logger LOG = LogManager.getLogger(GmailBO.class);

    private AppiumDriver<MobileElement> driver;

    private GmailHomePO gmailHomePO;
    private GmailSendPO gmailSendPO;

    public GmailBO(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        gmailHomePO = new GmailHomePO(driver);
    }

    public void navigateToConversationListActivity() {
        LOG.info("Navigate to conversation list activity");
        gmailHomePO.clickWelcomeGotItBtn();
        gmailHomePO.clickActionDoneBtn();
    }

    public void navigateToSendEmailActivity() {
        LOG.info("Navigate to send email activity");
        gmailHomePO.clickComposeBtn();
        gmailSendPO = new GmailSendPO(driver);
    }

    public void fillSendFieldsAndSendEmail(String to, String subject, String message) {
        LOG.info("Fill fields for sending email");
        gmailSendPO.fillSubjectInputElement(subject);
        gmailSendPO.fillMessageInputElement(message);
        gmailSendPO.fillToInputElement(to);
        gmailSendPO.clickSendBtnElement();
    }

    public boolean isEmailReceived(String subject) {
        LOG.info("Checking for receiving email");
        gmailHomePO.clickReceivedEmail();
        String receivedEmailSubject = gmailHomePO.getReceivedEmailSubject();
        return receivedEmailSubject.contains(subject);
    }
}