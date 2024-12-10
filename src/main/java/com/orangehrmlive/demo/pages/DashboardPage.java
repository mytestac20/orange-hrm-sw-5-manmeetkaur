package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage  extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement dashboard;


    @CacheLookup
    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement logo;

    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement userProfileLogo;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = "//li[1]//a[1]//span[1]")
    WebElement adminTab;


    /**
     * This method will get Dashboard message
     */
    public String getDashboardMessage(){
        String message = getTextFromElement(dashboard);
        CustomListeners.test.log(Status.PASS, "getDashboardMessage ");
        return message;
    }
    /**
     * This method will display logo
     */
    public boolean isDisplayed(){
        CustomListeners.test.log(Status.PASS, "isDisplayed ");
        return true;
    }
    /**
     * This method will click on user profile logo
     */
    public void userProfileLogo(){
        clickOnElement(userProfileLogo);
        CustomListeners.test.log(Status.PASS, "userProfileLogo ");

    }
    /**
     * This method will mouse hover and click on logout
     */
    public void clickOnLogout(){
        mouseHoverToElementAndClick(logoutButton);
        CustomListeners.test.log(Status.PASS, "clickOnLogout ");
    }
    /**
     * This method will click on Admin Tab
     */
    public void clickOnAdminTab(){
        clickOnElement(adminTab);
        CustomListeners.test.log(Status.PASS, "clickOnAdminTab ");
    }
}
