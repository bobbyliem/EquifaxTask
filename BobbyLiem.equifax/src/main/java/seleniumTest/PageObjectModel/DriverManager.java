package seleniumTest.PageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    //Default Constructor
    public DriverManager() {
    }

    public DriverManager(WebDriver driver) {
        this.driver = driver ;
    }

    WebDriver driver = null;

    public WebDriver setUp(){
        openBrowser();

        return this.driver;
    }



    private void openBrowser(){

        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();

    }

    public void navigateToUrl(String url) {
        //Timeout if page does not load
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to(url);

    }

    //Creating common Method so it can reused when we need to send key.
    public void enterText( By element, String text){
        driver.findElement(element).sendKeys(text);

    }

    //Creating common Method so it can reused when we need to send key.
    public void clickButton( By element){
        driver.findElement(element).click();

    }

    //Creating common Method so it can reused when we need to send key.
    public String fetchText( By element){

       return driver.findElement(element).getText();
    }

    public void quitDriver(){
        driver.quit();
    }

 }
