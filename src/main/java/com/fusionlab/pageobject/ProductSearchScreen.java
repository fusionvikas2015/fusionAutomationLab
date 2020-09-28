package com.fusionlab.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.fusionlab.android.Mobile;
import com.fusionlab.driver.BaseClass;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductSearchScreen extends BaseClass {

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private static WebElement SearchBar;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/item_title")
	private static List<WebElement> ProductListName;

	@AndroidFindBy(tagName = "com.amazon.mShop.android.shopping:id/item_title")
	private static WebElement AddToCart;

	public static String doSearchForProduct(String searchForProduct) throws Exception {
		String fullProductName = searchForProduct;
		System.out.println("searchForProduct:" + searchForProduct);
		// Mobile.scrollToTextMatch(searchForProduct);
		int count = ProductListName.size();
		System.out.println("Count:" + count);

		for (int i = 0; i < count; i++) {
			String text = ProductListName.get(i).getText();
			System.out.println("Product Name :" + text);

			if (text.contains(searchForProduct)) {
				System.out.println("Product Found at position: " + i);
				fullProductName = ProductListName.get(i).getText();
				ProductListName.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		return fullProductName;
	}

	public static void AddItemToCart() throws Exception {
		Mobile.scrollToText("Add to Cart");
		click(AddToCart, "Add to cart");
	}

}
