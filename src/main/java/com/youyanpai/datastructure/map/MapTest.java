package com.youyanpai.datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(10);
		System.out.println(map.size());
		map.put(null, null);
		System.out.println(map.get(null));
		map.put(null, "GG");
		System.out.println(map.get(null));
		
		if("aa".equals(map.get("aa")))
			System.out.println("aa");
			System.out.println("bb");
		
		
	}

}
