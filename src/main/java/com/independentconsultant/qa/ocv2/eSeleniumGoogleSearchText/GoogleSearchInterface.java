package com.pearson.qa.ocv2.eSeleniumGoogleSearchText;

import com.pearson.qa.ocv2.common.pageobjects.interfaces.pages.OCv2CommonPage;

/**
 * Created by Sunil Kumar on 10/15/2014.
 */
public interface GoogleSearchInterface extends OCv2CommonPage {

void enterSearchText(String searchString);
void clickSearchButton();
String getFirstSearchResultString();

}
