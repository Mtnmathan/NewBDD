package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
    WebDriver driver;
    Actions act;

    // Constructor to initialize the WebDriver and PageFactory elements
    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        this.act = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="nav-link-accountList-nav-line-1")
    WebElement helloLabel;

    @FindBy(xpath="//div[@id='nav-flyout-ya-signin']//a[@class='nav-action-signin-button']")
    WebElement siginBtn;
    
    @FindBy(id="twotabsearchtextbox")
    WebElement searchBox;
    

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public void hoverOnHello() {
        act.moveToElement(helloLabel).perform();
    }

    public void validateSigninBtn() {
        String btnText = siginBtn.getAttribute("innerText");
        boolean result = btnText.equalsIgnoreCase("Sign in");
        
        if(result=true) {
        	System.out.println("Page contains sign in button");
        }
        else {
        	System.out.println("Page doesn't contains sign in button");
        }
        driver.close();
    }
    
    public void sendtextFromid(String value) {
    	searchBox.sendKeys(value);
    }
}