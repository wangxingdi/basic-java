package com.youyanpai.algorithm.search;

/**
 * 二分查找
 * @author wangxd
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,4,7,8,9,12,17,45,91};
		System.out.println(binarySearch(arr, 5));
	}
	
	public static int binarySearch(int[] sortArr, int target){
		int left = 0;
		int right = sortArr.length - 1;
		int mid = -1;
		while(left<right){
			mid = (left+right)/2;
			if(sortArr[mid]<target){
				left = mid+1;
			}else if(sortArr[mid]>target){
				right = mid-1;
			}else{
				return mid;
			}
		}
		return -1;
	}

}
