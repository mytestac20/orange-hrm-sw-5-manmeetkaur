package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']")
    WebElement hrForAllLogo;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginText;




    //create appropriate methods

    /**
     *This method will enter user name
     */
    public void enterUserName(String uName){
        sendTextToElement(userName,uName);
        CustomListeners.test.log(Status.PASS, "enterUserName");
    }
    /**
     * This method will enter password
     */
    public void enterPassword(String pass){
        sendTextToElement(password,pass);
        CustomListeners.test.log(Status.PASS, "enterPassword");
    }
    /**
     * This method will click on login button
     */
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "clickOnLoginButton");
    }
    /**
     * This method will get HR logo
     */
    public String getHRForAllLogo(){
        String logo =  getTextFromElement(hrForAllLogo);
        CustomListeners.test.log(Status.PASS, "String");
        return logo;
    }
    /**
     * This method will get login text
     */
    public String getLoginText(){
        String text1 = getTextFromElement(loginText);
        CustomListeners.test.log(Status.PASS, "getLoginText");
        return text1;
    }
}
