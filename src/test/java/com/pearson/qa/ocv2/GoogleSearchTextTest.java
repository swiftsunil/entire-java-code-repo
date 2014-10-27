package com.pearson.qa.ocv2;

import com.pearson.qa.common.exceptions.RequirementsException;
import com.pearson.qa.ocv2.eSeleniumGoogleSearchText.pageobjects.interfaces.pages.GoogleSearchInterface;
import com.pearson.qa.ocv2.eSeleniumGoogleSearchText.pageobjects.web.pages.GoogleSearchWebPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.drivers.DefaultUIDriver;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by Sunil Kumar on 10/15/2014.
 */

// public class GooglePageTest extends UITestBase {

public class GoogleSearchTextTest {

    Logger logger = Logger.getLogger(GoogleSearchTextTest.class);
    // google  url
    String googleUrl = "http://www.k9safesearch.com/";
    String searchText = "dripping";

    @Test(description="google search text validation", groups ={"google.search.text"})
    public void googleSearchTextValidation() throws RequirementsException {

        logger.info("Start of googleSearchTextValidation() test:: ");
        UIDriver uiDriver = new DefaultUIDriver();
        uiDriver.get(googleUrl);
        GoogleSearchInterface googlePage = new GoogleSearchWebPage(uiDriver, googleUrl);
        googlePage.enterSearchText(searchText);

        googlePage.clickSearchButton();

        System.out.println("First search result string ::" + googlePage.getFirstSearchResultString());

        if (!googlePage.getFirstSearchResultString().contains(searchText))
            throw new RequirementsException("dripping not found in first search result.");

        logger.info("End of gogoleSearchTextValidation() test");
        uiDriver.quit();
    }
}
