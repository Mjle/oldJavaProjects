package com.fdmgroup.jpauser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
	public static Properties loadProperties(String filename) {
		try {

			InputStream inputStream = PropertyUtils.class.getResourceAsStream("/" + filename);
			Properties properties = new Properties();

			properties.load(inputStream);
			inputStream.close();

			return properties;

		} catch (IOException e) {

			e.printStackTrace();

			return null;
		}

	}

}
