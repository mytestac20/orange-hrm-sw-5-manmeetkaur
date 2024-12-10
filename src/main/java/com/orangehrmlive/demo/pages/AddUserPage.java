package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement addUserText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']/div[contains(text(),'Admin')]")
    WebElement selectRole;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']")
    WebElement employeeName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Confirm Password']")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    WebElement successMessage;


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--info oxd-toast-container--toast']")
    WebElement noRecordFound;

    @CacheLookup
    @FindBy(css = "span[class='oxd-text oxd-text--span']")
    WebElement resultList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active oxd-select-text--error']")
    WebElement dropDown;


    /**
     *This method will verify Add User Text
     */
    public String verifyAddUserText(){
        String text =  getTextFromElement(addUserText);
        CustomListeners.test.log(Status.PASS,"verifyAddUserText ");
        return text;
    }
    /**
     * This method will select Role
     */
    public void selectRoleAdmin(String options){
        selectByVisibleTextFromDropDown(selectRole,options);
        CustomListeners.test.log(Status.PASS,"selectRoleAdmin ");
    }
    /**
     * This method will click on dropdown
     */
    public void selectDropDown(){
        clickOnElement(dropDown);
        CustomListeners.test.log(Status.PASS,"selectDropDown ");
    }

    /**
     * This method will enter employee name
     */
    public void enterEmployeeName(String eName){
        sendTextToElement(employeeName,eName);
        CustomListeners.test.log(Status.PASS,"enterEmployeeName ");
    }
    /**
     * This method will enter username
     */
    public void enterUserName(String uName){
        sendTextToElement(userName,uName);
        CustomListeners.test.log(Status.PASS,"enterUserName ");
    }
    /**
     * This method will enter password
     */
    public void enterPassword(String pass){
        sendTextToElement(password,pass);
        CustomListeners.test.log(Status.PASS,"enterPassword ");
    }
    /**
     * This method will enter confirm password
     */
    public void enterConfirmPassword(String cPass){
        sendTextToElement(confirmPassword,cPass);
        CustomListeners.test.log(Status.PASS,"enterConfirmPassword ");
    }

    /**
     * This method will click on save button
     */
    public void clickOnSaveButton(){
        clickOnElement(saveButton);
        CustomListeners.test.log(Status.PASS,"clickOnSaveButton ");
    }

    /**
     * This method will verify successfully saved message
     */
    public String verifySuccessfullySavedMessage(){
        String message =  getTextFromElement(successMessage);
        CustomListeners.test.log(Status.PASS,"verifySuccessfullySavedMessage ");
        return message;
    }

    /**
     * This method will verify No user found
     */
    public String verifyNoUserFound(){
        String found =  getTextFromElement(noRecordFound);
        CustomListeners.test.log(Status.PASS,"verifyNoUserFound ");
        return found;
    }
    /**
     * This method will verify user in result list
     */
//    public List<WebElement> verifyUserInResultList(){
//        String list = driver.findElements(resultList);
//        CustomListeners.test.log(Status.PASS,"verifyUserInResultList ");
//        return list;
//    }


    /**
     * This method will click on search button
     */
    public void clickOnSearchButton(){
        clickOnElement(searchButton);
        CustomListeners.test.log(Status.PASS,"clickOnSearchButton ");
    }


    public void selectUserRoleAsAdmin(){
        selectByVisibleTextFromDropDown(selectRole,"Admin");
        clickOnElement(selectRole);
        clickOnElement(By.xpath("//div[contains(text(),'Admin')]"));
//        List<WebElement> roles = findElements(selectRole);
//        for (WebElement role:roles){
//            System.out.println(role.getText());
//            if(role.getText().equals("Admin")){
//                role.click();
//                break;
            }
        }


