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
		int[] arr0 = {7, 2, 1, 9, 6, 29, 74, 31};
		quickSort(arr0, 0, arr0.length-1);
		for(int a : arr0){
			System.out.print(a+" , ");
		}
		System.out.println("");
		int[] arr1 = {7, 2, 1, 9, 6, 29, 74, 31};
		quickSort_1(arr1, 0, arr1.length-1);
		for(int a : arr1){
			System.out.print(a+" , ");
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
	
	public static void quickSort_1(int[] arr, int left, int right){
		if(left<right){
			int mid = divide(arr, left, right);
			quickSort_1(arr, left, mid-1);
			quickSort_1(arr, mid+1, right);
		}
	}
	
	/**
	 * 返回哨兵最后的索引
	 * @param arr
	 * @param start
	 * @param stop
	 * @return
	 */
	public static int divide(int[] arr, int start, int stop){
		int tmp = arr[start];
		while(start<stop){
			while(start<stop && arr[stop]>=tmp){
				stop--;
			}
			if(start<stop){
				arr[start] = arr[stop];
				start++;
			}
			while(start<stop && arr[start]<=tmp){
				start++;
			}
			if(start<stop){
				arr[stop] = arr[start];
				stop--;
			}
		}
		arr[start] = tmp;
		return start;
	}

}
