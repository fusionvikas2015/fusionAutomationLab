package com.fusionlab.pageobject;

import org.openqa.selenium.WebElement;

import com.fusionlab.driver.BaseClass;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckoutScreen extends BaseClass {

	/**
	 * NOTE: WebContentDebuggingEnabled is not enabled for this apk. Need to be
	 * setted as WebContentDebuggingEnabled=true from the app side. So not able to
	 * inspect the element. Below resource-ids and all are the not the actual one.
	 * 
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/name")
	private static WebElement getProductName;

	/**
	 * Mapped id for getProductPrice webElement as private.
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/price")
	private static WebElement getProductPrice;

	/**
	 * Mapped id for getProductDesc webElement as private.
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/desc")
	private static WebElement getProductDesc;

	/**
	 * Get the full product name during the checkout process
	 * 
	 * @return txt
	 */
	public static String getProductCompleteName() {
		String txt = getText(getProductName, "Get text");
		return txt;
	}

	/**
	 * Get the product price during checkout processs.
	 * 
	 * @return price
	 */
	public static String getProductPrice() {
		String price = getText(getProductPrice, "Get text");
		return price;
	}

	/**
	 * Get the product description during checkout processs.
	 * 
	 * @return desc
	 */
	public static String getProductDesc() {
		String desc = getText(getProductDesc, "Get text");
		return desc;
	}
}
