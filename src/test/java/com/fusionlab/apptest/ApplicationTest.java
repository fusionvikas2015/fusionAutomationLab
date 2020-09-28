package com.fusionlab.apptest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fusionlab.android.Mobile;
import com.fusionlab.driver.BaseClass;
import com.fusionlab.pageobject.HomePage;
import com.fusionlab.pageobject.LoginPage;
import com.fusionlab.pageobject.ProductSearchScreen;

public class ApplicationTest extends BaseClass {

	@Test
	public void TC01_LoginToAmazon() throws Exception {
		logger.info("TC01_LoginToAmazon");
		//LoginPage.doLoginAsValidUser("fusionvikas", "foster123");

	}

	@Test
	public void TC02_VerifyDetailsOnProductSearchScreenVsCheckoutScreen() throws Exception {
		logger.info("TC02_VerifyDetailsOnProductSearchScreenVsCheckoutScreen");
		//LoginPage.doLoginAsGuest();
		//HomePage.searchProductOnHomeScreen("65-inch TV");

		//ProductSearchScreen.doSearchForProduct("LG 164 cm (65 inches) 4K Ultra HD");
		//ProductSearchScreen.AddItemToCart();
	}

}
