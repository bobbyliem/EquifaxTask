package seleniumTest.PageObjectModel;

import org.testng.annotations.Test;
public class TestRunner {

    @Test
    public void runAmazonTest(){

    //Hardcoding the url for POC
    String url = "https://www.amazon.com/" ;
    String bookName = "QA Testing for Beginners" ;
    BaseFunctions base = new BaseFunctions() ;
    base.runAmazonTest(url, bookName);

    }



}


