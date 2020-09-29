package com.fusionlab.pageobject;

import org.openqa.selenium.WebElement;

import com.fusionlab.android.Mobile;
import com.fusionlab.driver.BaseClass;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseClass {

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private static WebElement SearchBar;
	
	

	public static void searchProductOnHomeScreen(String productName) throws Exception {
		click(SearchBar, "Search bar");
		type(SearchBar, productName, "65-inch TV");
		Mobile.pressEnterKey();

	}

}
