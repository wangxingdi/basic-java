package com.daiyuma.jdk.lang.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("a", "b");
		map.get("aa");
		//排序
		sortHashMap();
		//安全
		Collections.synchronizedSortedMap(new TreeMap<String, String>());
		//treeMap
		treeMapApi();
		//concurrentHashMap
		concurrentHashMapApi();
	}
	
	public static void sortHashMap(){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
	    map.put("aa", 2);
	    map.put("bc", 8);
	    map.put("af", 5);
	    //查看默认的排序
	    for(Entry<String, Integer> entry : map.entrySet()){
	        System.out.println(entry.getKey());
	    }
	    //对map进行按需排序
	    List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
	    Collections.sort(list, new Comparator<Entry<String, Integer>>(){
	        @Override
	        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
	            //降序
	            return o2.getValue() - o1.getValue();
	        }
	    });
	    System.out.println("");
	}
	
	public static void treeMapApi(){
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("a", "a");
		map.put("c", "c");
		map.put("f", "f");
		map.put("e", "e");
		Entry<String, String> ceilingEntry = map.ceilingEntry("b");
		System.out.println(ceilingEntry.getKey());
		Object map1 = map.clone();
		System.out.println(map1);
		System.out.println(map.comparator());
		NavigableSet<String> set = map.descendingKeySet();
		for(String s : set){
			System.out.println(s);
		}
		System.out.println(map.firstEntry());
		System.out.println(map.headMap("e", true));
		System.out.println("=== treeMapApi结束 ===");
	}
	
	public static void concurrentHashMapApi(){
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		chm.put("a", "a");
		chm.get("a");
	}
	
	

}
