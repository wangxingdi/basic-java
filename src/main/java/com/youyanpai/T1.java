package com.youyanpai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1 {

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
		String s = "aaaa";
		System.out.println(s.indexOf(""));
		Map<String, String> map = new HashMap<String, String>(16);
		
		int[] array = new int[]{10, 20};
		array = new int[]{10, 20};
        swapByBitOperation(array, 0, 1);
        System.out.println(Arrays.toString(array));
        
        int a = 0;
        char b = '1';
        System.out.println(a + (b-'0'));
        
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        int[] x = reversePrint(n1);
        System.out.println(x);
	}
	
	public static int removeDuplicates(int[] nums) {
        if(null==nums || nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return ++i;
    }
	
	public static void  swapByBitOperation(int[] array, int i, int j) {
        array[i] = array[i]^array[j];
        array[j] = array[i]^array[j]; //array[i]^array[j]^array[j]=array[i]
        array[i] = array[i]^array[j]; //array[i]^array[j]^array[i]=array[j]
    }
	
	public static int[] reversePrint(ListNode head) {
        ListNode newHead = reverse(head);
        List<Integer> list = new ArrayList<Integer>();
        while(newHead!=null){
            list.add(newHead.val);
            newHead = newHead.next;
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static ListNode reverse(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
