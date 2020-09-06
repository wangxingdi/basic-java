package com.daiyuma.jdk.util.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
	
	private static final String FILE = "E:/springboot.properties";

	public static void main(String[] args) {
		Properties p = new Properties();
		try(InputStream is = new FileInputStream(FILE)) {
			p.load(is);
			String s = p.getProperty("a.b.c");
			System.out.println(s);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
