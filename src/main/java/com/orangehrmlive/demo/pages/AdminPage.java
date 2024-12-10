package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsers;

    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement addButton;



    /**
     *This method this verify System Users Tex
     */

    public String verifySystemUsersText(){
        String text = getTextFromElement(systemUsers);
        CustomListeners.test.log(Status.PASS, "verifySystemUsersText ");
        return text;
    }
    /**
     * This method will click on Add button
     */
    public void clickOnAddButton(){
        clickOnElement(addButton);
        CustomListeners.test.log(Status.PASS, "clickOnAddButton ");
    }

}
