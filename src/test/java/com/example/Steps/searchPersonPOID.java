package com.example.Steps;

import com.example.Base.BaseClass;
import com.example.PageObjects.A_LoginPage;
import com.example.PageObjects.B_PersonsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class searchPersonPOID extends BaseClass{
    static WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("^Open Chrome and launch application$")
    public void open_chrome_and_launch_application() throws Throwable{
        System.setProperty("webdriver.chrome.driver","chromedriver 4");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver();
        driver.get("https://trials-int.nci.nih.gov/");
        Thread.sleep(3000);
    }
    @When("^I enter Username and password$")
    public void i_enter_username_and_password() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        //objLoginPage=new A_LoginPage(driver);
        Thread.sleep(3000);
        loginPage.setUserName();
        loginPage.setPassword();
    }

    @When("^the website opens$")
    public void the_website_opens() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickSigninSubmit();
        Thread.sleep(4000);
    }

    @When("^I click on Protocol Abstraction$")
    public void i_click_on_protocol_abstraction() throws Throwable
    {
        A_LoginPage loginPage=new A_LoginPage(driver);
        loginPage.clickProtocolAbstraction();
        loginPage.clickAccept();
        Thread.sleep(4500);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

    }

    @Given("^I click on Persons menu option$")
    public void i_click_on_persons_menu_option() throws Throwable{
        B_PersonsPage personsPage=new B_PersonsPage(driver);
        personsPage.clickPersonsMenuOption();
    }

    @When("^I type 18816 into PO ID (exact match)$")
    public void i_type_18816_into_po_id_exact_match() throws Throwable{
        B_PersonsPage personsPage=new B_PersonsPage(driver);
        personsPage.typeIntoPOID();
    }

    @Then("^I click on search$")
    public void i_click_on_search() throws Throwable{
        B_PersonsPage personsPage=new B_PersonsPage(driver);
        personsPage.clickSearch();
    }

    @Then("^I Assert 18816 matches 18816$")
    public void i_assert_18816_matches_18816() throws Throwable{
        B_PersonsPage personsPage=new B_PersonsPage(driver);
        personsPage.assertStep();
    }

    @Then("^I click on logout$")
    public void i_click_on_logout() throws Throwable{
        B_PersonsPage personsPage=new B_PersonsPage(driver);
        personsPage.logout();
    }
}
