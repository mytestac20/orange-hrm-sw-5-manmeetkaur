package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUsersPage  extends Utility {

    @CacheLookup
    @FindBy(css = "//div[class='oxd-table-card-cell-checkbox'] i[class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement checkbox;

    @CacheLookup
    @FindBy(css = "//div[@class='orangehrm-container']//button[1]")
    WebElement deleteButton;

    @CacheLookup
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    WebElement okAlert;


    //Methods

    /**
     * This method will click on checkbox
     */
    public void clickOnCheckbox(){
        clickOnElement(checkbox);
        CustomListeners.test.log(Status.PASS, "clickOnCheckbox ");
    }
    /**
     * This method will click delete button
     */
    public void clickOnDeleteButton(){
        clickOnElement(deleteButton);
        CustomListeners.test.log(Status.PASS, "clickOnDeleteButton ");
    }
    /**
     * This method will click ok on pop up
     */
    public void clickOkOnPopUP(){
        CustomListeners.test.log(Status.PASS, "clickOkOnPopUP ");
        acceptAlert();
    }
}
