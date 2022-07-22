package com.example.PageObjects;

import com.example.Base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class B_PersonsPage extends BaseClass{
    public static WebDriver weBdriver;

    public B_PersonsPage(WebDriver ldriver){
        this.weBdriver=ldriver;
        PageFactory.initElements(ldriver, this);
    }

    public void clickPersonsMenuOption() throws Throwable{
        WebElement element=weBdriver.findElement(By.id("personSearchMenuOption"));
        element.click();
    }

    public void typeIntoPOID() throws Throwable{
        WebElement element=weBdriver.findElement(By.id("poID"));
        element.click();
        element.sendKeys("18816");
    }

    public void clickSearch() throws Throwable{
        WebElement element=weBdriver.findElement(By.cssSelector(".search"));
        element.click();
    }

    public void assertStep() throws Throwable{
        String assertText="18816";
        System.out.println(weBdriver.findElement(By.linkText("18816")).getText());
        Assert.assertTrue(assertText.equals(weBdriver.findElement(By.linkText("18816")).getText()));
    }

    public void logout() throws Throwable{
        WebElement element=weBdriver.findElement(By.linkText("Logout"));
        element.click();
    }
}
