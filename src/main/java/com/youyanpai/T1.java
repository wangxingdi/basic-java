package com.youyanpai;

import java.util.Arrays;
import java.util.HashMap;
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

}
