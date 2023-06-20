package pageobjects;

import base.Base;
import executor.Exec;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NikonPage extends Base {

    Exec exec = new Exec();
    @FindBy(xpath="//h1[.='Nikon D300']")
    private WebElement nikonD300;
    @FindBy(xpath="//button[@id='button-cart']")
    private WebElement addToCart;
    @FindBy(xpath="//td[contains(.,'Nikon D300')]")
    private WebElement nikonConfirm;
    @FindBy(xpath = "//button[@type='button'][@data-bs-toggle='dropdown']")
    private WebElement items;
    public NikonPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyNikonD300Page(){
        boolean status = nikonD300.isDisplayed();
        return status;
    }
    public void clickAddToCart(){
        exec.getWait2().until(ExpectedConditions.elementToBeClickable(addToCart));
        exec.actionClick(driver,addToCart);
    }
    public void clickItems(){
        exec.getWait2().until(ExpectedConditions.elementToBeClickable(items)).click();
    }
    public boolean verifyNikonWasAddedToCart(){
       return nikonConfirm.isDisplayed();
    }

}
