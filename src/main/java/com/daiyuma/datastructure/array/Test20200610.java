package com.daiyuma.datastructure.array;

public class Test20200610 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(arrSum1(arr));
		System.out.println(arrSum2(arr, arr.length));
		getMaxAndMin1(arr);
		getMaxAndMin2(arr);
		int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
		reverseArr(arr1);
	}
	
	/**
	 * 数组求和
	 * @param arr 数组
	 * @return
	 */
	public static int arrSum1(int[] arr){
		int sum = 0;
		for(int i=0;i<arr.length;i++){
			sum += arr[i];
		}
		return sum;
	}
	
	/**
	 * 数组求和
	 * @param arr 数组
	 * @param n 求和末位(包含)
	 * @return
	 */
	public static int arrSum2(int[] arr, int n){
		return 0==n?0:arrSum2(arr, n-1)+arr[n-1];
	}
	
	/**
	 * 求数组的最小值和最大值
	 * @param arr
	 */
	public static void getMaxAndMin1(int[] arr){
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		if(null==arr){
			return;
		}else if(0==arr.length){
			return;
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min = arr[i];
			}
			if(arr[i]>max){
				max = arr[i];
			}
		}
		System.out.println("最小值: "+min+", 最大值: "+max);
	}
	
	/**
	 * 求数组的最小值和最大值
	 * 分治法
	 * @param arr
	 */
	public static void getMaxAndMin2(int[] arr){
		if(null==arr){
			return;
		}else if(0==arr.length){
			return;
		}
	}
	
	/**
	 * 数组反转
	 * @param arr
	 */
	public static void reverseArr(int[] arr){
		if(null==arr){
			return;
		}
		if(0==arr.length){
			return;
		}
		int i = 0;
		int j = arr.length - 1;
		while(i<j){
			int tmp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = tmp;
		}
		System.out.print("反转后数组:");
		for(int m=0;m<arr.length;m++){
			System.out.print(arr[m]+", ");
		}
		System.out.println("");
	}

}
