package seleniumTest.PageObjectModel;

import org.openqa.selenium.WebDriver;

public class BaseFunctions {

    WebDriver driver ;
    DriverManager driveManager = new DriverManager(driver);


    public void runAmazonTest(String url, String bookName){

        try {
            navigateToUrl(url);
            searchBook(bookName);
            addBookToCart();
            validateBookDataInCart();

        }finally {
            System.out.println("Quiting Driver");
            driveManager.quitDriver();
        }

    }

    public void navigateToUrl(String url){

            //Navigate to URL
            driveManager.setUp();
            driveManager.navigateToUrl(url);

    }

    public void searchBook(String bookName){
        PageObjects pageObjects = new PageObjects() ;

        //Search the TextBooK
        driveManager.enterText(pageObjects.searchBar , bookName);
        driveManager.clickButton(pageObjects.searchButton);

    }

    public void addBookToCart(){
        // Select the first Book
        PageObjects productListPageObjects = new PageObjects() ;
        driveManager.clickButton(productListPageObjects.firstBook);

        //Add book to the Cart
        PageObjects productDetailPageObject = new PageObjects() ;
        driveManager.clickButton(productDetailPageObject.addToCartButton);
        //navigate back to avoid passing book price object to validation method
        driveManager.driver.navigate().back();

    }

    public void validateBookDataInCart(){
        //Get Price from Product Page
        PageObjects productListPageObject = new PageObjects() ;
        String productPageBookPrice = driveManager.fetchText(productListPageObject.productPageBookPrice);
        driveManager.clickButton(productListPageObject.gotoCartButton);

        //Go to Cart and Get price from the Check Out Page
        PageObjects checkOutPageObject = new PageObjects() ;
        String checkoutPagePrice = driveManager.fetchText(checkOutPageObject.checkOutBookPrice);
        assert productPageBookPrice.equals(checkoutPagePrice);

    }
}
