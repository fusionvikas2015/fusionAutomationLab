package com.fusionlab.pageobject;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.fusionlab.android.Mobile;
import com.fusionlab.driver.BaseClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseClass {

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
	private static WebElement SignIn;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	private static WebElement SkipSignIn;

	public static void doLoginAsValidUser(String username, String password) throws Exception {
		Thread.sleep(2000);
		click(SignIn, "Login Button");
		System.out.println("Login Successful");
		Thread.sleep(8000);
		Mobile.setContextToWebview();
	}

	public static void doLoginAsGuest() throws Exception {
		Thread.sleep(2000);
		click(SkipSignIn, "SkipSignIn Button");
		logger.info("Login As Guest - Skipped Sign In");
		Thread.sleep(2000);
	}

}
