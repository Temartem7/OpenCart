package testcases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;

public class LoginTest extends Base {
    private AccountPage accountPage;
    private LoginPage loginPage;
    private IndexPage indexPage;
    @Test
    public void testLoginWithValidCredentials(){
        indexPage = new IndexPage();
        indexPage.clickMyAccount();
        loginPage = indexPage.clickLogin();
        loginPage.enterEmail();
        loginPage.enterPassword();
        accountPage=loginPage.clickLogin();
        Assert.assertTrue(accountPage.verifyAccountPage());
    }
}
