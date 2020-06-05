/**
 * from www.youyanpai.com
 */
package com.youyanpai.algorithm.sort;

/**
 * 快速排序
 * @author wangxd
 */
public class QuickSort {

	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {7, 2, 1, 9, 6, 29, 74, 31};
		quickSort(arr, 0, arr.length-1);
		for(int a : arr){
			System.out.println(a);
		}
	}
	
	/**
	 * 快速排序
	 * @param arr 待排序数组
	 * @param start 起始下标
	 * @param stop 终止下标
	 * @return
	 */
	public static void quickSort(int[] arr, int start, int stop){
		if(start < stop){
			int left = start;
			int right = stop;
			int tmp = arr[left];
			while(left<right){
				//从右向左,调走小于哨兵的元素
				while(arr[right]>=tmp && left<right){
					right--;
				}
				if(left<right){
					arr[left++] = arr[right];
				}
				//从左向右,调走大于哨兵的元素
				while(arr[left]<=tmp && left<right){
					left++;
				}
				if(left<right){
				    arr[right--] = arr[left];
				}
			}
			arr[left] = tmp;
			quickSort(arr, start, left - 1);
			quickSort(arr, left + 1, stop);
		}
	}

}
