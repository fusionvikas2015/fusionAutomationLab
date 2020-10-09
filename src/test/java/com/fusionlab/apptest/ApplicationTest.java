package com.fusionlab.apptest;

import java.util.Hashtable;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import com.fusionlab.driver.BaseClass;
import com.fusionlab.pageobject.CheckoutScreen;
import com.fusionlab.pageobject.HomeScreen;
import com.fusionlab.pageobject.LoginScreen;
import com.fusionlab.pageobject.ProductSearchScreen;
import com.fusionlab.utilities.DataProviders;

import junit.framework.Assert;

public class ApplicationTest extends BaseClass {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "credentialDP")
	public void TC01_LoginToAmazon(Hashtable<String, String> data) throws Exception {
		logger.info("TC01_LoginToAmazon");
		LoginScreen.doLoginAsValidUser(data.get("username"), data.get("password"));
	}

	@Test(dataProviderClass = DataProviders.class, dataProvider = "searchProductDP")
	public void TC02_VerifyDetailsOnProductSearchScreenVsCheckoutScreen(Hashtable<String, String> data)
			throws Exception {
		logger.info("TC02_VerifyDetailsOnProductSearchScreenVsCheckoutScreen");
		driver.rotate(ScreenOrientation.PORTRAIT);

		HomeScreen.searchProductOnHomeScreen(data.get("Category"));
		ProductSearchScreen.doSearchForProduct(data.get("Product"));

		logger.info("Get the Product name , price and description before checkout");
		String productName = ProductSearchScreen.getProductCompleteName();
		String productPrice = ProductSearchScreen.getProductPrice();
		String productDesc = ProductSearchScreen.getProductDesc();

		ProductSearchScreen.AddItemToCartAndCheckout();

		logger.info("Get the Product name , price and description from checkout screen");
		String nameOnCheckout = CheckoutScreen.getProductCompleteName();
		String priceOnCheckout = CheckoutScreen.getProductPrice();
		String descOnCheckout = CheckoutScreen.getProductDesc();

		logger.info("Validate the Product name , price and description on checkout screen");
		Assert.assertEquals(productName, nameOnCheckout,
				"Product name does not match from product screen to the checkout screen");
		Assert.assertEquals(productPrice, priceOnCheckout,
				"Product price does not match from product screen to the checkout screen");
		Assert.assertEquals(productDesc, descOnCheckout,
				"Product desc does not match from product screen to the checkout screen");
	}

	@Test(dataProviderClass = DataProviders.class, dataProvider = "searchProductDP")
	public void TC02_TestToShowScreenshotAttachmentToFailedTC(Hashtable<String, String> data) throws Exception {
		logger.info("TC02_VerifyDetailsOnProductSearchScreenVsCheckoutScreen");
		driver.rotate(ScreenOrientation.PORTRAIT);

		HomeScreen.searchProductOnHomeScreen(data.get("Category"));
		ProductSearchScreen.doSearchForProduct(data.get("Product"));

		logger.info("Get the Product name , price and description before checkout");
		String productName = ProductSearchScreen.getProductCompleteName();
		String productPrice = ProductSearchScreen.getProductPrice();
		String productDesc = ProductSearchScreen.getProductDesc();

		ProductSearchScreen.AddItemToCartAndCheckout();

		logger.info("Get the Product name , price and description from checkout screen");
		String nameOnCheckout = CheckoutScreen.getProductCompleteName();
		String priceOnCheckout = CheckoutScreen.getProductPrice();
		String descOnCheckout = CheckoutScreen.getProductDesc();

		logger.info("Validate the Product name , price and description on checkout screen");
		Assert.assertEquals(productName, nameOnCheckout,
				"Product name does not match from product screen to the checkout screen");
		Assert.assertEquals(productPrice, priceOnCheckout,
				"Product price does not match from product screen to the checkout screen");
		Assert.assertEquals(productDesc, descOnCheckout,
				"Product desc does not match from product screen to the checkout screen");

	}

}
