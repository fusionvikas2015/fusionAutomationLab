/**
 * @author Vikas Kumar
 * 
 * Description: Driver main class. This class is used to initialize the driver. In this class all the desired capabilities are being defined.
 * 
 * Desired Capabilities are keys and values encoded in a JSON object, sent by Appium clients to the server when a new automation session
 * is requested. They tell the Appium drivers all kinds of important things about how you want your test to work. Each Appium client builds
 * capabilities in a way specific to the client's language, but at the end of the day, they are sent over to Appium as JSON objects. 
 * 
*/
package com.fusionlab.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import com.fusionlab.common.Constants;
import com.fusionlab.utilities.ReportsLogger;
import com.fusionlab.utilities.Utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends ReportsLogger {

	public  static Logger logger = LogManager.getLogger(BaseClass.class);

	/**
	 * driver instance
	 */
	public static AndroidDriver<MobileElement> driver;

	/**
	 * Android serial id
	 */
	public static String androidDeviceID = Utility.parseGlobalProp("ANDROID_SERIALID");

	/**
	 * Appium Port number
	 */
	public static String PORT = Utility.parseGlobalProp("PORT");
	/**
	 * Used to set the device language
	 */
	public static String language = Utility.parseGlobalProp("LANGUAGE");
	/**
	 * Select the device region
	 */
	public static String locale = Utility.parseGlobalProp("LOCALE");

//	@AfterSuite
//	public void teardown() throws Exception {
//		/**
//		 * Suite teardown. Kill the appium driver
//		 */
//		System.out.println("\n\n\t\t\t\t============>>>> " + "Suite Level Teardown" + " <<<<============");
//		Thread.sleep(1000);
//		if (driver != null) {
//			driver.quit();
//		}
//	}

	@BeforeMethod
	public static AndroidDriver<MobileElement> createEnvironment() throws Exception {

		String version = Utility.parseGlobalProp("VERSION");
		logger.info(" Automation Framework Version:" + version);

		DesiredCapabilities caps = new DesiredCapabilities();
		logger.info("Please Wait ! Initiating Android Appium Driver...");
		logger.info("androidDeviceID: " + androidDeviceID);
		String platformVersion = Utility.exec_adb_command(androidDeviceID, Constants.ANDROID_PLATFORM_VERSION_CMD);
		logger.info("Platform: " + platformVersion);
		String DeviceName = Utility.exec_adb_command(androidDeviceID, Constants.ANDROID_DEVICE_NAME_CMD);
		logger.info("DeviceName: " + DeviceName);

		caps.setCapability("udid", androidDeviceID);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("deviceName", DeviceName);
		caps.setCapability("platformName", "Android");

		caps.setCapability("appPackage", Constants.ANDROID_APP_PACKAGE);
		caps.setCapability("appActivity", Constants.ANDROID_APP_ACTIVITY);
		caps.setCapability(MobileCapabilityType.AUTO_WEBVIEW, false);

		caps.setCapability(MobileCapabilityType.LANGUAGE, language);
		caps.setCapability(MobileCapabilityType.LOCALE, locale);

		caps.setCapability("noReset", "true");
		caps.setCapability("fullReset ", "false");

		File appDir = new File(System.getProperty("user.dir") + "//src//main//java//resources//apk//");

		File appPath = new File(appDir, Utility.parseGlobalProp("ANDROID_APP_NAME"));

		caps.setCapability("app", appPath.getAbsolutePath());

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + PORT + "/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		} catch (MalformedURLException e) {
			System.out.println("Error while initiaising the driver : " + e.getMessage());
		}

		/**
		 * Page Initialization Page factory implementation
		 * 
		 */
		logger.info("iOS Driver Initiated Successfully.Now initiating all the screens objects.");
		Utility.InitialisePages(driver);
		System.out.println("All Pages initaited with driver.");
		return driver;
	}

	public static void click(WebElement element, String elementName) {
		element.click();
		logger.info(elementName + " Clicked");
	}

	public static void type(WebElement element, String value, String elementName) {
		element.sendKeys(value);
		logger.info("Typing in : " + elementName + " entered the value as : " + value);
	}

}
