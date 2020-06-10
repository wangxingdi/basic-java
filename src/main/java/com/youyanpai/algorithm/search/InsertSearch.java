package com.youyanpai.algorithm.search;

/**
 * 插值查找
 * 二分查找的升级版,升级了mid的计算公式;
 * 时间复杂度loglogN
 * @author wangxd
 */
public class InsertSearch {

	public static void main(String[] args) {
		int[] arr = {1,4,7,8,9,12,17,45,91};
		System.out.println(insertSearch(arr, 45));
	}
	
	public static int insertSearch(int[] arr, int target){
		int left = 0;
		int right = arr.length - 1;
		int mid = -1;
		while(left<right){
			mid = (right-left)*(target-arr[left])/(arr[right]-arr[left]) + left;
			if(target<arr[mid]){
				right = mid - 1;
			}else if(target>arr[mid]){
				left = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}

}
