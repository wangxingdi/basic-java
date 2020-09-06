package com.daiyuma.algorithm.sort;

/**
 * 选择排序
 * @author wangxd
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {7, 2, 1, 9, 6, 29};
		selectSort(arr);
		for(int a : arr){
			System.out.print(a+" ");
		}
		System.out.println("");
	}
	
	/**
	 * 需要两次遍历
	 * 第一次遍历从0开始,遍历至倒数第二个元素,每次移动指针都挑选当前元素为标的元素;
	 * 第二次遍历从标的元素开始(不包括),遍历至倒数第一个元素,从里面挑选出最小的元素;
	 *  | -- 最后将挑选的最小元素与标的元素调换位置;
	 * @param arr
	 */
	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			int current = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[current]){
					current = j;
				}
			}
			if(i!=current){
				int tmp = arr[i];
				arr[i] = arr[current];
				arr[current] = tmp;
			}
		}
	}

}
