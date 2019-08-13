package com.keyword.sample;

import java.lang.reflect.Method;

public class ReflectApp {

	public static void main(String[] args) {

		// no paramater
		Class noparams[] = {};

		// String and int parameter
		Class[] paramString = new Class[2];
		paramString[0] = String.class;
		paramString[1] = Integer.TYPE;
		
		// int parameter
		Class[] paramInt = new Class[1];
		paramInt[0] = Integer.TYPE;

		try {
			// load the AppTest at runtime
			Class cls = Class.forName("com.keyword.sample.AppTest");
			Object obj = cls.newInstance();

			// call the printIt method
			Method method = cls.getDeclaredMethod("printIt", noparams);
			method.invoke(obj, null);

			// call the printItString method, pass a String param
			method = cls.getDeclaredMethod("printItString", paramString);
			method.invoke(obj, "sudhakar",100);

			// call the printItInt method, pass a int param
			method = cls.getDeclaredMethod("printItInt", paramInt);
			method.invoke(obj, 123);

			//demo(2,4,1,5,7,8,1,0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void demo(int... x){
		System.out.println(x[0]);
		System.out.println(x[1]);
	}
}





