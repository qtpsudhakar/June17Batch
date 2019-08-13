package com.keyword.sample;

import org.testng.Assert;

public class AppTest {

	//no parameters
	public void printIt() {
		System.out.println("printIt() no param");
		
	}

	//two different parameters
	public void printItString(String temp, Integer x) {
		System.out.println("printIt() with param String : " + temp);
	}

	//one parameter
	public void printItInt(int temp) {
		System.out.println("printIt() with param int : " + temp);
	}

}
