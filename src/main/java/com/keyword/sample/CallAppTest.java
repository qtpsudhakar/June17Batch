package com.keyword.sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallAppTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/*
		 * AppTest at = new AppTest(); at.printIt(); at.printItInt(10);
		 * at.printItString("hello",10);
		 */
		
		//create class instance dynamically
		Class cls = Class.forName("com.keyword.sample.AppTest");
		Object obj = cls.newInstance();		
		
		//create method call to access a method without parameters
		Class noparams[] = {};
		Method method = cls.getDeclaredMethod("printIt", noparams);
		method.invoke(obj, null);
		
		//create method call to access a method with single parameters
		Class oneParams[] = {Integer.TYPE};
		Method m2 = cls.getDeclaredMethod("printItInt", oneParams);
		m2.invoke(obj, 20);

		//create method call to access a method with multiple parameters
		Class twoParams[] = {String.class,Integer.class};
		Method m3 = cls.getDeclaredMethod("printItString", twoParams);
		m3.invoke(obj, "sudhakar",10);
		
	}

}
