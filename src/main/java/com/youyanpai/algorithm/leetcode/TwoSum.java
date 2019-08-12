package com.youyanpai.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		int[] a = bruteForce(test, target);
		System.out.println(Arrays.toString(a));
//		System.out.println(StringUtils.join(a, ','));
		int[] b = hashTwice(test, target);
		System.out.println(Arrays.toString(b));
		int[] c = hashOnce(test, target);
		System.out.println(Arrays.toString(c));
	}
	
	/**
	 * 暴力破解
	 * 循环套循环,依次求和
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] bruteForce(int[] nums, int target){
//		List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
//                    result.add(nums[i]);
//                    result.add(nums[j]);
                	return new int[]{i, j};
                }
            }
        }
//        int[] rs = result.stream().mapToInt(Integer::intValue).toArray();
        return null;
	}
	
	/**
	 * 两次使用hash对比
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] hashTwice(int[] nums, int target){
//		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> first = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			first.put(nums[i], i);
		}
		for(int i=0;i<nums.length;i++){
			int s = target - nums[i];
			if(null!=first.get(s)){
//				result.add(nums[i]);
//				result.add(first.);
				return new int[]{i, first.get(s)};
			}
		}
//		int[] rs = result.stream().mapToInt(Integer::intValue).toArray();
        return null;
	}
	
	/**
	 * 一次使用hash对比
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] hashOnce(int[] nums, int target){
		Map<Integer, Integer> first = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			first.put(nums[i], i);
			int s = target - nums[i];
			if(first.get(s)!=null){
				return new int[]{i, first.get(s)};
			}
		}
		return null;
	}

}
