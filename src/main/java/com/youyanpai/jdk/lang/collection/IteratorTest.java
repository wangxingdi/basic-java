package com.youyanpai.jdk.lang.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		Collection<String> c = new HashSet<String>();
		c.add("a");
		c.add("b");
		Iterator<String> it = c.iterator();
		
		Collection<String> c1 = new ArrayList<String>();
		c.add("a");
		c.add("b");
		Iterator<String> it1 = c.iterator();
	}

}
