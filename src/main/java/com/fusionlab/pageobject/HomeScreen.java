package com.fusionlab.pageobject;

import org.openqa.selenium.WebElement;

import com.fusionlab.android.Mobile;
import com.fusionlab.driver.BaseClass;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseClass {

	/**
	 * Mapped id for SearchBar webElement as private.
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private static WebElement SearchBar;

	/**
	 * This method can be used to search any product on home screen.
	 * 
	 * @param productCategory
	 * @throws Exception
	 */
	public static void searchProductOnHomeScreen(String productCategory) throws Exception {
		System.out.println("productCategory:" + productCategory);
		click(SearchBar, "Search bar");
		Thread.sleep(2000);
		type(SearchBar, productCategory, productCategory);
		Mobile.pressEnterKey();
	}

}
