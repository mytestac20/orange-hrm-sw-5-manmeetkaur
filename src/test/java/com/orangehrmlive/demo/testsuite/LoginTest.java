package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
    public class LoginTest extends TestBase {


        /**
         * Assert method
         */
        public void verifyText(String actualText, String expectedText, String message) {
            Assert.assertEquals(actualText, expectedText, message);
        }

        //create objects of relatives pages
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        //1.adminShouldAddUserSuccessFully().
        @Test(groups = {"sanity"})
        public void verifyUserShouldLoginSuccessFully() {
            // Enter username
            loginPage.enterUserName("Admin");

            //   Enter password
            loginPage.enterPassword("admin123");

            //   Click on Login Button
            loginPage.clickOnLoginButton();

            //   Verify "Dashboard" Message
            String actualText = dashboardPage.getDashboardMessage();
            String expectedText = "Dashboard";
            verifyText(actualText, expectedText, "Dashboard message not displayed");

        }

        //2. VerifyThatTheLogoDisplayOnLoginPage()
        @Test(groups = {"sanity", "smoke"})
        public void VerifyThatTheLogoDisplayOnLoginPage() {
            //Launch the application
            // Enter username
            loginPage.enterUserName("Admin");

            //   Enter password
            loginPage.enterPassword("admin123");

            //   Click on Login Button
            loginPage.clickOnLoginButton();

            // Check if the logo is displayed
            Assert.assertTrue(dashboardPage.isDisplayed(), "Logo is not displayed on the page.");

        }

        //3. VerifyUserShouldLogOutSuccessFully()
        @Test(groups = {"smoke","regression"})
        public void VerifyUserShouldLogOutSuccessFully() {

            //Login To The application
            // Enter username
            loginPage.enterUserName("Admin");
            // loginPage.enterUserName("Admin");

            //   Enter password
            loginPage.enterPassword("admin123");

            //   Click on Login Button
            loginPage.clickOnLoginButton();

            //   Click on User Profile logo
            dashboardPage.userProfileLogo();

            //   Mouse hover on "Logout" and click
            dashboardPage.clickOnLogout();

            //   Verify the text "Login Panel" is displayed
            String expectedLoginPanelText = "Login Panel";
            String actualLoginPanelText = loginPage.getLoginText();
            verifyText(actualLoginPanelText, expectedLoginPanelText, "Login Panel not displayed");
        }
    }
