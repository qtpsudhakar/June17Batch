package com.wd.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static String getUniqueId() {
		// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		return sd.format(new Date());

	}
}
