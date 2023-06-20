package testcases;

import base.Base;
import org.testng.annotations.Test;
import pageobjects.*;

public class NikonTest extends Base {

    IndexPage indexPage;
    LoginPage loginPage;
    private AccountPage accountPage;
    private CameraPage cameraPage;
    private NikonPage nikonPage;

    @Test
    public void testAddToCartNikon(){
        indexPage = new IndexPage();
        indexPage.clickMyAccount();
        loginPage= indexPage.clickLogin();
        loginPage.enterEmail();
        loginPage.enterPassword();
        accountPage=loginPage.clickLogin();
        cameraPage=accountPage.navigateToCameraPage();
        nikonPage=cameraPage.clickNikonD300();
        nikonPage.clickAddToCart();
        nikonPage.clickItems();
//        Assert.assertTrue(nikonPage.verifyNikonWasAddedToCart());
    }
}
