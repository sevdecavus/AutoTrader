package com.autotrader.pages;

import com.autotrader.utilities.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvancedSearchPage extends Base{

    public AdvancedSearchPage(){

        PageFactory.initElements(MyDriver.get(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement clickAdvanceSearch;

    @FindBy(xpath = "//input[contains(@type, 'tel')]")
    public WebElement enterZipCode;

    @FindBy(xpath = "//div[contains(text(),'Certified')]")
    public WebElement selectCertified;

    @FindBy(xpath = "//div[contains(text(),'Convertible')]")
    public WebElement selectConvertible;

    @FindBy(xpath = "//select[contains(@name,'startYear')]")
    public WebElement selectFrom;

    @FindBy(xpath = "//select[contains(@name,'endYear')]")
    public WebElement selectTo;

    @FindBy(xpath = "//select[contains(@name,'makeFilter0')]")
    public WebElement selectBMW;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement clickSearchButton;


    @FindBy(xpath = "//h1[contains(text(),'Cars for Sale in Alpharetta, GA')]")
    public WebElement userInPage;

    public void advanceSearchClick(){
        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        clickAdvanceSearch.click();
    }
    public void zipCode(String zip){
        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        enterZipCode.clear();
        enterZipCode.sendKeys("30004");
    }
    public void verifyclickCertifiedAndCovertible(String a){
        if(a.equalsIgnoreCase(selectCertified.getText())){
            selectCertified.click();

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else{
            WebElement link = selectConvertible;
            scrollDown(link);
            selectConvertible.click();

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void startDateAndEndDate(String from, String to){
        Select select = new Select(selectFrom);
        select.selectByValue(from);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Select select1 = new Select(selectTo);
        select1.selectByValue(to);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void selectVehicle(String vehicle){
        Select select = new Select(selectBMW);
        select.selectByValue(vehicle);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void clickSearchButton(){
        WebElement link = clickSearchButton;
        scrollDown(link);
        clickSearchButton.click();

    }
    public void verifyResultPage(){
        String expected = "Cars for Sale in Alpharetta, GA";
        String actual = userInPage.getText();
        Assert.assertEquals(expected, actual);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public void verifyBMWListing(String car){
        List<WebElement> list=MyDriver.get().findElements(By.xpath("//h2[contains(@data-cmp,'subheading')]"));

        int count=0;
        int nonBMWcount=0;
        for(WebElement each : list){
            if(!each.getText().contains(car)){
                System.out.println("We found non BMW listing"+ count);
            }
            count++;
        }
        System.out.println("We found" + count + "BMW listing and There is no non BMW listing");
    }

}















