package com.youyanpai;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.youyanpai.T1.ListNode;

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
	     ListNode n1 = new ListNode(5);
//	     ListNode n2 = new ListNode(4);
//	     ListNode n3 = new ListNode(3);
//	     n1.next = n2;
//	     n2.next = n3;
	     ListNode n4 = new ListNode(5);
//	     ListNode n5 = new ListNode(6);
//	     ListNode n6 = new ListNode(4);
//	     n4.next = n5;
//	     n5.next = n6;
	     System.out.println(addTwoNumbers(n1, n4));
	     
	     lengthOfLongestSubstring("abba");
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
	 
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode result = new ListNode(0);
	        ListNode tmp = result;
	        int carry = 0;
	        while(l1!=null || l2!=null){
	            int a = null==l1?0:l1.val;
	            int b = null==l2?0:l2.val;
	            int c = (a + b + carry)%10;
	            carry = (a + b + carry)/10;
	            ListNode curr = new ListNode(c);
	            tmp.next = curr;
	            tmp = tmp.next;
	            if(null!=l1){
	            	l1 = l1.next;
	            }
	            if(null!=l2){
	            	l2 = l2.next;
	            }
	        }
	        if(carry!=0){
	            ListNode curr = new ListNode(carry);
	            tmp.next = curr;
	        }
	        return result.next;
	    }
	 
	  static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	  
	  public static int lengthOfLongestSubstring(String s) {
	        int max = 0;
	        if(null==s || s.length()==0){
	            return max;
	        }
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        int left = 0;
	        for(int i=0;i<s.length();i++){
	            if(map.containsKey(s.charAt(i))){
	                left = Math.max(map.get(s.charAt(i)) + 1, left);
	            }
	            map.put(s.charAt(i), i);
	            max = Math.max(max, i - left + 1);
	        }
	        return max;
	    }

	    
}
