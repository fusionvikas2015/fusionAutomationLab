package com.fusionlab.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.fusionlab.android.Mobile;
import com.fusionlab.driver.BaseClass;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductSearchScreen extends BaseClass {

	/**
	 * Mapped id for SearchBar webElement as private
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private static WebElement SearchBar;

	/**
	 * Mapped id for ProductListName List<WebElement> as private
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/item_title")
	private static List<WebElement> ProductListName;

	/**
	 * Mapped id for AddToCartBtn webElement as private
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/add-to-cart-button")
	private static WebElement AddToCartBtn;

	/**
	 * Mapped id for CartPopUpBtn webElement as private
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/a-autoid-0-announce")
	private static WebElement CartPopUpBtn;

	/**
	 * NOTE: WebContentDebuggingEnabled is not enabled for this apk. Need to be
	 * setted as WebContentDebuggingEnabled=true from the app side. So not able to
	 * inspect the element. Below resource-ids and all are the not the actual one.
	 * 
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/name")
	private static WebElement getProductName;

	/**
	 * Mapped id for getProductPrice webElement as private
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/price")
	private static WebElement getProductPrice;

	/**
	 * Mapped id for getProductDesc webElement as private
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/desc")
	private static WebElement getProductDesc;

	/**
	 * This method can be used to search the product on product screen.
	 * 
	 * @param searchForProduct
	 * @return
	 * @throws Exception
	 */
	public static String doSearchForProduct(String searchForProduct) throws Exception {
		String fullProductName = searchForProduct;
		System.out.println("searchingForProduct:" + searchForProduct);

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

	/**
	 * This method can be used to add the item/product to the cart
	 * 
	 * @throws Exception
	 */
	public static void AddItemToCartAndCheckout() throws Exception {
		Mobile.scrollToText("Add to Cart");
		click(AddToCartBtn, "Add to cart");
		click(CartPopUpBtn, "Cart btn on Widget");
	}

	/**
	 * Get the complete name of the product/item on product screen.
	 * 
	 * @return
	 */
	public static String getProductCompleteName() {
		String txt = getText(getProductName, "Get text");
		return txt;
	}

	/**
	 * Get the price of the product/item on product screen.
	 * 
	 * @return
	 */
	public static String getProductPrice() {
		String price = getText(getProductPrice, "Get text");
		return price;
	}

	/**
	 * Get the description of the product on product screen.
	 * 
	 * @return
	 */
	public static String getProductDesc() {
		String desc = getText(getProductDesc, "Get text");
		return desc;
	}

}
