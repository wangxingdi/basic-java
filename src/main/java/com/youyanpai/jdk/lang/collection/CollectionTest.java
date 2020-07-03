package com.youyanpai.jdk.lang.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {

	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
		System.out.println(c.add(1));
		System.out.println(c.add(1));
		System.out.println(c.add(1));
		
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(1);
		c1.add(2);
		System.out.println(c.addAll(c1));
		c.remove(1);
//		c.removeAll(c1);
		
		c.retainAll(c1);
		
		c1.add(5);
		System.out.println(c.containsAll(c1));
		
		c.clear();
		c.add(null);
		System.out.println(c.isEmpty());
		
		c.clear();
		c1.clear();
		c.add(1);
		c.add(2);
		c1.add(1);
		c1.add(2);
		System.out.println(c.equals(c1));
		System.out.println("===运行结束===");
	}

}
