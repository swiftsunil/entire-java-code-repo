package com.pearson.qa.ocv2.eSeleniumGoogleSearchText;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.pearson.qa.ocv2.common.pageobjects.web.pages.WebOCv2CommonPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Created by Sunil Kumar on 10/15/2014.
 */
public class GoogleSearchWebPage extends WebOCv2CommonPage implements GoogleSearchInterface {

    private UIElement searchTextBox =  createElement(UIType.Css,"#srchbx");
    private UIElement searchButton = createElement(UIType.Css,".srchbtn");
    private UIElement firstSearchResult = createElement(UIType.Xpath,"//div[@class='rslt wrslt'][1]/h3");


    // constructor
    @Inject
    public GoogleSearchWebPage(UIDriver driver, @Assisted String url) {
        super(driver, url);
    }

    // enter search text method
    @Override
    public void enterSearchText(String searchString) {
      this.searchTextBox.clearAndSendKeysRobustly(searchString);
    }


    // click search button
    @Override
    public void clickSearchButton() {
    this.searchButton.click();
    }


    // get first search result string
    @Override
    public String getFirstSearchResultString() {
        return this.firstSearchResult.getText();
    }
}
