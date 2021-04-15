package seleniumTest.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {
    //Note : Best Practice is to create separate class for each Page.
    //But for POC we are adding all Page objects in one class

    WebDriver driver ;
    // WebElements for Landing Page
    public final By searchBar = By.xpath("//*[@id='twotabsearchtextbox']");
    public final By searchButton = By.id("nav-search-submit-button");


    //WebElements for Product List Page, this can be more optimized by reading the div for the first book but cutting it short due to time crunch
    public final By firstBook = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div");
    public final By productPageBookPrice = By.xpath("//*[@id=\"newBuyBoxPrice\"]") ;

    //Add to cart Button
    public final By addToCartButton = By.xpath("//*[@id='add-to-cart-button']");
    public final By gotoCartButton = By.xpath("//*[@id=\"nav-cart\"]");

    //WebElements for Checkout Page : Needs enhancement on get the By use Multiple attributes to locate an element for now using absolute path
    public final By checkOutBookPrice = By.xpath("//body/div[@id='a-page']/div[4]/div[1]/div[7]/div[1]/div[2]/div[4]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/p[1]");

}
