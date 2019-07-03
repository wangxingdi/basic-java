package com.youyanpai.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. stream()是jdk8中的新特性;
 * 2. mapXXX()是对流中的数据进行处理;
 * 3. 类名::方法名是一种Lambda表达式, 也可以换一种写法
 * 		person -> person.getAge(); == Person::getAge
 * @author wangxd
 */
public class TwoSum {
	
	private static int[] test = {1, 3, 6, 9, 3, 10, 12, 7};
	private static int target = 10;
	
	public static void main(String[] args) {
		int[] a = twoSum_1(test, target);
		System.out.println(a);
	}
	
	public static int[] twoSum_1(int[] nums, int target){
		List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    result.add(nums[i]);
                    result.add(nums[j]);
                }
            }
        }
        int[] rs = result.stream().mapToInt(Integer::intValue).toArray();
        return rs;
	}
	
	public static int[] twoSum_2(int[] nums, int target){
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
//			if(target-nums[i]){
//				
//			}
		}
		int[] rs = result.stream().mapToInt(Integer::intValue).toArray();
        return rs;
	}

}
