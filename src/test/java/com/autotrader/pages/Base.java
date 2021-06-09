package com.autotrader.pages;

import com.autotrader.utilities.MyDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Base {
    public Base(){
        PageFactory.initElements(MyDriver.get(), this);
    }
    public void deleteCookies() {
        MyDriver.get().manage().deleteAllCookies();
    }

    public void scrollDown(WebElement str) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) MyDriver.get();

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", str);
        //js.executeScript("window.scrollBy(0,50)");
    }

    public void waitSomeTime(Long miliSeconds) {

        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void waitForElement(Long miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
