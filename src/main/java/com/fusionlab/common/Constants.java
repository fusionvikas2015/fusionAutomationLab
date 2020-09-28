package com.fusionlab.common;

/**
 * 
 * Constant class
 *
 */
public class Constants{
	
	public static final String ANDROID = "ANDROID";
	public static final String SCREEN_DUMPSYS = "shell dumpsys \"window windows | grep -E mCurrentFocus\"";
	public static final String ANDROID_APP_PACKAGE = "com.amazon.mShop.android.shopping";
	public static final String ANDROID_APP_ACTIVITY = "com.amazon.mShop.splashscreen.StartupActivity";

	public static final String LaunchAppInHomeScreenDirectlyCmd = "shell am start -n com.amazon.mShop.android.shopping/com.amazon.mShop.sso.SigninPromptActivity";

	
	public static final String ANDROID_PLATFORM_VERSION_CMD = "shell getprop ro.build.version.release";
	public static final String ANDROID_DEVICE_NAME_CMD = "shell getprop ro.product.model";
	
	
	//Logcat command 
	public static final String CLEAR_LOGCAT = "logcat -c";
	public static final String START_LOGCAT = "logcat com.amazon.mShop.android.shopping -d";
	
	


	
	
	//Data provider
	public static String RUNMODE_COL = "Runmode";
	public static String DATA_SHEET = "TestData";
	
	public static String SUITE_SHEET = "Suite";
	public static String SUITENAME_COL ="SuiteName";
	
	
	public static String TESTCASE_SHEET = "TestCases";
	public static String TESTCASE_COL = "TestCases";
	
	public static String RUNMODE_YES = "Y";
	public static String RUNMODE_NO = "N";
	
	public static String SUITE_XL_PATH = System.getProperty("user.dir") + "//Resources//testData//Suite.xlsx";
	public static String SUITE1_XL_PATH=System.getProperty("user.dir") + "//Resources//testData//master.xlsx";

	


}
