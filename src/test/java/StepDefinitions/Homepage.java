package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import PageObjects.HomePageObjects;
import Utilities.BasePage;
import Utilities.ExtendReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Homepage {

    private WebDriver driver;
    private ExtentTest test;
    private HomePageObjects homePageObjects;
    private BasePage basepage;
    private ExtendReport extentreport;

    public Homepage() {
        this.driver = new ChromeDriver();
        this.basepage = new BasePage(driver);
        this.homePageObjects = new HomePageObjects(driver);
        this.extentreport = new ExtendReport();
    }

    @Before
    public void setUp() {
        ExtendReport.setUpReport();
        ExtendReport.createTest("Homepage Test");
    }
    
    @Given("User is on home page")
    public void user_is_on_home_page() throws IOException {
        basepage.maximizePage();
        basepage.impWait();
        basepage.getURL("https://www.amazon.in/");
        ExtendReport.logInfo(driver, "User landed in amazon Page");
        
        String title = homePageObjects.getHomePageTitle();
        System.out.println(title);
        ExtendReport.logPass(driver, "Page title fetched");
        
        homePageObjects.sendtextFromid("Samsung");
    }

    @And("Mouse hover on Hello Signin")
    public void mouse_hover_on_hello_signin() throws InterruptedException {
        homePageObjects.hoverOnHello();
    }

    @Then("Signin button should display")
    public void signin_button_should_display() {
        homePageObjects.validateSigninBtn();
    }
    
    @After
    public void tearDown() {
        ExtendReport.tearDownReport();
        if (driver != null) {
            driver.quit();
        }
    }
}