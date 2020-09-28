package com.fusionlab.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.fusionlab.common.Constants;

/*
 * This Class will drive data from DataUtil class to Test Class
 * Step:
 * 1. Test Class call DataProvide Class with Data Provide name "masterDP".
 * 2. This Class will get Method Name of Calling Test Class using reflection and Pass it to Variable testcase.
 * 3. Then This Class will pass testcase name to DataUtil Class.
 * 4. This Class will get Data from DataUtil Class and Pass it to Test Class.
 * 
 */

public class DataProviders {

	@DataProvider(name = "masterDP", parallel = true)
	public static Object[][] getDataSuite1(Method m) {

		System.out.println("Class Name : " + m.getName());

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		String testcase = m.getName();
		return DataUtil.getData(testcase, excel);

	}

}

