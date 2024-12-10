package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class UserTest extends TestBase {

    /**
     * Assert method
     */
    public void verifyText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AdminPage adminPage = new AdminPage();
    AddUserPage addUserPage = new AddUserPage();
    ViewSystemUsersPage viewSystemUsersPage=new ViewSystemUsersPage();



    @Test(groups = {"sanity"})
    public void adminShouldAddUserSuccessFully()  {

        // Login to Application
        // Enter username
        //loginPage.enterUserName("Admin");
        loginPage.enterUserName("Admin");

        //   Enter password
        loginPage.enterPassword("admin123");

        //   Click on Login Button
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();

        //	Verify "System Users" Text
        String expectedSystemUsersText = "System Users";
        String actualSystemsText = adminPage.verifySystemUsersText();
        verifyText(actualSystemsText, expectedSystemUsersText, "System Users text not displayed");

        //	click On "Add" button
        adminPage.clickOnAddButton();

        //	Verify "Add User" Text
        String expectedText = "Add User";
        String actualText = addUserPage.verifyAddUserText();
        verifyText(actualText, expectedText, "Add User not displayed");

        //	Select User Role "Admin"
        // Open the dropdown
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='dropdown']"));
        dropdown.click();

        // Select the "Admin" option
        WebElement adminOption = driver.findElement(By.xpath("//div[@class='dropdown']//li[text()='Admin']"));
        adminOption.click();
        // addUserPage.selectDropDown();
        // addUserPage.selectRoleAdmin("Admin");
        // addUserPage.selectUserRoleAsAdmin();

        //	enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeName("Ananya Dash");

        //	enter Username
        addUserPage.enterUserName("Mannat");

        //	Select status "Disable"

        //	enter password
        addUserPage.enterPassword("123456");

        //	enter Confirm Password
        addUserPage.enterConfirmPassword("123456");

        //	click On "Save" Button
        addUserPage.clickOnSaveButton();

        //	verify message "Successfully Saved"
//        String expectedSuccessText="Successfully Saved";
//        String actualSuccessText=addUserPage.verifySuccessfullySavedMessage();
//        verifyText(actualSuccessText,expectedSuccessText,"Message not displayed");

    }


    //2. searchTheUserCreatedAndVerifyIt().
    @Test(groups = {"sanity", "smoke"})
    public void searchTheUserCreatedAndVerifyIt() {
        //	Login to Application
        // Enter username
        loginPage.enterUserName("Admin");

        //   Enter password
        loginPage.enterPassword("admin123");

        //   Click on Login Button
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();

        //	Verify "System Users" Text
//        String expectedSystemUsersText="System Users";
//        String actualSystemsText= adminPage.verifySystemUsersText();
//        verifyText(actualSystemsText,expectedSystemUsersText,"System Users text not displayed");

        //	Enter Username
        addUserPage.enterUserName("Parekh");

        //	Select User Role


        //	Click on "Search" Button
        addUserPage.clickOnSearchButton();

//        //	Verify the User should be in Result list.
//        List<WebElement> resultRows = addUserPage.verifyUserInResultList();
//        boolean userFound = false;

//        for (WebElement row : resultRows) {
//            String username = row.findElement(RelativeLocator.with(By.tagName("input")).below(By.xpath("//label[normalize-space()='Username']"))).getText();
//
//            if (username.equals("payal9")) { // Replace "testuser" with the username you're verifying
//                userFound = true;
//                break;
//            }
//        }
//        if (userFound) {
//            System.out.println("User found in the result list.");
//        } else {
//            System.out.println("User NOT found in the result list.");
//        }


    }

    //3. verifyThatAdminShouldDeleteTheUserSuccessFully.
    @Test(groups = {"smoke","regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        //	Login to Application
        // Enter username
        loginPage.enterUserName("Admin");

        //   Enter password
        loginPage.enterPassword("admin123");

        //   Click on Login Button
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();

        //	Verify "System Users" Text
//        String expectedSystemUsersText="System Users";
//        String actualSystemsText= adminPage.verifySystemUsersText();
//        verifyText(actualSystemsText,expectedSystemUsersText,"System Users text not displayed");

        //	Enter Username
        addUserPage.enterUserName("Parekh");

        //	Select User Role
        //	Select Satatus
        //	Click on "Search" Button
        addUserPage.clickOnSearchButton();

        //	Verify the User should be in Result list.
        //	Click on Check box
        viewSystemUsersPage.clickOnCheckbox();

        //	Click on Delete Button
        viewSystemUsersPage.clickOnDeleteButton();

        //	Popup will display


        //	Click on Ok Button on Popup
        viewSystemUsersPage.acceptAlert();

        //	verify message "Successfully Deleted"


    }

    //4. searchTheDeletedUserAndVerifyTheMessageNoRecordFound.
    @Test(groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        //	Login to Application
        // Enter username
        loginPage.enterUserName("Admin");

        //   Enter password
        loginPage.enterPassword("admin123");

        //   Click on Login Button
        loginPage.clickOnLoginButton();

        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();

        //	Verify "System Users" Text
//        String expectedSystemUsersText="System Users";
//        String actualSystemsText= adminPage.verifySystemUsersText();
//        verifyText(actualSystemsText,expectedSystemUsersText,"System Users text not displayed");

        //	Enter Username
        addUserPage.enterUserName("Parekh");

        //	Select User Role
        //	Select status
        //	Click on "Search" Button
        addUserPage.clickOnSearchButton();

        //	verify message "No Records Found"
        addUserPage.verifyNoUserFound();

    }
}