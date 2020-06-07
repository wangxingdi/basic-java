package com.youyanpai.algorithm.sort;

/**
 * 希尔排序
 * 直接插入排序的升级版
 * @author wangxd
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = SortConstant.ARR1;
		shellSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+", ");
		}
		System.out.println("");
	}
	
	public static void shellSort(int[] arr){
		//间隔归0
		for(int gap=arr.length/2;gap>0;gap/=2){
			//一趟遍历,分组内插入排序
			for(int i=gap;i<arr.length;i++){
				groupInsertSort(arr, gap, i);
			}
		}
	}
	
	public static void groupInsertSort(int[] arr, int gap, int i){
		int tmp = arr[i];
		int j = i-gap;
		while(j>=0&&tmp<arr[j]){
			arr[j+gap] = arr[j];
			j-=gap;
		}
		arr[j+gap] = tmp;
	}

}
