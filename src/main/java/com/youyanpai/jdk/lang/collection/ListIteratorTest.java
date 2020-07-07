package com.youyanpai.jdk.lang.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ListIteratorTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		List<String> list = new ArrayList<String>();
		list.add("x");
		list.add("y");
		list.add("z");
		//获取
		ListIterator<String> listIterator = list.listIterator();
//		listIterator.remove();
//		listIterator.set("2");
//		listIterator.add("1");
		//向后遍历
		while(listIterator.hasNext()){
			if("z".equals(listIterator.next())){
				System.out.println(listIterator.previous());
				listIterator.add("nnn");
				listIterator.add("mmm");
			}else{
				listIterator.add("kkk");
			}
		}
		//向前遍历
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());
		}
		System.out.println("---运行结束---");
	}

}
