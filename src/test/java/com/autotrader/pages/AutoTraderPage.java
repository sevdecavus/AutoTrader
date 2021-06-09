package com.autotrader.pages;

import com.autotrader.utilities.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoTraderPage extends Base{
    /**
     * Locators
     */

    @FindBy(xpath = "//button[contains(text(),'Browse by Budget')]")
    public WebElement browseByBudget;

    @FindBy(xpath = "//button[contains(text(),'Browse by Style')]")
    public WebElement browseByStyle;

    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement advanceSearch;

    @FindBy(xpath = "//button[@id='search']")
    public WebElement searchButton;

    @FindBy(xpath = "//select[@id='makeCode']")
    public WebElement makeElement;

    @FindBy(xpath = "//select[@id='ModelCode']")
    public WebElement modelElement;

    public AutoTraderPage(){

        PageFactory.initElements(MyDriver.get(), this);
    }

    public void verifications(String expected) {
        /**
         * Browse Budget
         * Browse Style
         * Advance Search
         */

        if (expected.equals(browseByBudget.getText())) {
            String actual = browseByBudget.getText();
            Assert.assertEquals(expected, actual);
        } else if (expected.equals(browseByStyle.getText())) {
            String actual = browseByStyle.getText();
            Assert.assertEquals(expected, actual);
        } else {
            String actual = advanceSearch.getText();
            Assert.assertEquals(expected, actual);
        }
    }

    public void searchButton(){

        Assert.assertTrue(searchButton.isEnabled());
    }

    public void verifyMakeAndModel(String make, String model){
        Assert.assertTrue(makeElement.isEnabled());
        Assert.assertFalse(modelElement.isEnabled());
    }
}

