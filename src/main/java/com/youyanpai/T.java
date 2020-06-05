package com.youyanpai;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class T {

	public static void main(String[] args) {
	     Map<String, Object> map = new HashMap<>();
	     map.put("name", "Tina");
	     map.put("age", 30);
	     map.put("address", "101 Sun Street, Yellow Town");
	     Person person = toBean(map, Person.class);
	     System.out.println(person);
	     
	     StringBuilder s = new StringBuilder();
	     s.append("abcde");
	     StringBuilder s1 = s.reverse();
	     System.out.println(s1);
	     
	     System.out.println(isPalindrome(121));
	}

	 public static <T> T toBean(Map<String, Object> beanPropMap, Class<T> type) {
	     try {
	         T beanInstance = type.getConstructor().newInstance();
	         for (Object k : beanPropMap.keySet()) {
	             String key = (String) k;
	             Object value = beanPropMap.get(k);
	             if (value != null) {
	                 try {
	                	 Field field = type.getDeclaredField(key);
	                     field.setAccessible(true);
	                     field.set(beanInstance, value);
	                     field.setAccessible(false);
	                 } catch (Exception e) {
	                     e.printStackTrace();
	                 }
	             }
	         }
	         return beanInstance;
	     } catch (Exception e) {
	    	 e.printStackTrace();
	     }
	     return null;
	 }
	 
	 public static boolean isPalindrome(int x) {
	        if (x < 0 || (x%10==0&&x!=0)){
	            return false;
	        }
	        if (x == 0){
	            return true;
	        }
	        int num = 0;
	        while(num < x){
	            num = num*10 + x%10;
	            x = x/10;
	        }
	        return num==x || x == num/10;
	    }

	    
}
