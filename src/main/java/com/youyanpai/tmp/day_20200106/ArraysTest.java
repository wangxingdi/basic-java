package com.youyanpai.tmp.day_20200106;

import java.util.ArrayList;
import java.util.List;

/**
 * Integer[]向int[]的转换
 * 1. 可以使用循环;
 * 2. 也可以使用java8中的stream();
 * @author wangxd
 */
public class ArraysTest {

	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(convertListToArray(list));
	}
	
	private static int[] convertListToArray(List<Integer> list) {
		int[] arr = new int[list.size()];
		for (int i=0;i<list.size();i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

}
