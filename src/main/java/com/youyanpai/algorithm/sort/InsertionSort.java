/**
 * 
 */
package com.youyanpai.algorithm.sort;

/**
 * 插入排序
 * ==================================================================
 * 首先对于待排序的数字串arr[0…R]，我们称呼arr[0]（哨兵）为有序区域，而剩余的arr[1…R]为无序区域。
 * 1. 简单理解
 * 从无序区域中拿出一个数字，和有序区域里面的每一个数字依次比较以求找到正确的位置，
 * 然后将此位置和以后的每一个数字后移一个位置，最后将拿出的数字插入到正确的位置中去。
 * 2. 改进理解
 * 从无序区域中拿出一个数字，和有序区域里面的每一个依次比较。如果拿出的数字比被比较的数字大，
 * 那么就直接将被比较的数字后挪一位，直到找到正确的位置。
 * ==================================================================
 * @author wangxd
 */
public class InsertionSort {

	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {1,5,9,2,46,35,16};
		directInsertSort(arr1);
		for(int i=0;i<arr1.length;i++){
			System.out.print(arr1[i]+", ");
		}
		System.out.println("");
		int[] arr2 = {1,5,9,2,46,35,16};
		int[] returnArr1 = directInsertSort1(arr2, SortConstant.AES);
		for(int i=0;i<returnArr1.length;i++){
			System.out.print(returnArr1[i]+", ");
		}
		System.out.println("");
		int[] arr3 = {1,5,9,2,46,35,16};
		int[] returnArr2 = directInsertSort2(arr3, SortConstant.DES);
		for(int i=0;i<returnArr2.length;i++){
			System.out.print(returnArr2[i]+", ");
		}
		System.out.println("");
		int[] arr20200609 = {1,5,9,2,46,35,16};
		insertSort20200609(arr20200609);
		for(int i=0;i<arr20200609.length;i++){
			System.out.print(arr20200609[i]+", ");
		}
		System.out.println("");
		int[] arr20200614 = {1,5,9,2,46,35,16};
		insertSort20200614(arr20200614);
		for(int i=0;i<arr20200614.length;i++){
			System.out.print(arr20200614[i]+", ");
		}
		
		
	}
	
	public static void directInsertSort(int[] arr){
		if(null==arr){
			return;
		}
		for(int i=1;i<arr.length;i++){
			int tmp = arr[i];
			int j = i-1;
			while(j>=0&&tmp<arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = tmp;
		}
	}
	
	/**
	 * 直接插入排序
	 * @param arr
	 * @param order
	 * @return
	 */
	public static int[] directInsertSort1(int[] arr, String order){
		if(null==arr){
			return null;
		}
		for(int i=1;i<arr.length;i++){
			int tmp = arr[i];
			int j = i-1;
			switch (order) {
			case SortConstant.AES:
				for(; j>=0 && arr[j] > tmp;j--){
					arr[j+1] = arr[j];
				}
				break;
			case SortConstant.DES:
				for(; j>=0 && arr[j] < tmp;j--){
					arr[j+1] = arr[j];
				}
				break;
			default:
				break;
			}
			arr[j+1] = tmp;
		}
		return arr;
	}
	
	public static int[] directInsertSort2(int[] arr, String order){
		if(null==arr){
			return null;
		}
		for(int i=1;i<arr.length;i++){
			int tmp = arr[i];
			int j = i - 1;
			switch(order){
			case SortConstant.AES:
				while(j>=0 && arr[j] > tmp){
					arr[j+1] = arr[j];
					j--;
				}
				break;
			case SortConstant.DES:
				while(j>=0 && arr[j] < tmp){
					arr[j+1] = arr[j];
					j--;
				}
				break;
			default:
				break;
			}
			arr[j+1] = tmp;
		}
		return arr;
	}
	
	/**
	 * 直接排序
	 * 第一个为有序数组,剩下的为无序数组;
	 * 无序数组中选择一个,和有序数组依次比较,放到合适的位置;
	 * 将合适位置上的元素以及后面的有序数组依次向后挪一位;
	 * @param arr
	 */
	public static void insertSort20200609(int[] arr){
		if(null==arr){
			return;
		}
		for(int i=1;i<arr.length;i++){
			int tmp = arr[i];
			int j = i - 1;
			while(j>=0&&arr[j]>tmp){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = tmp;
		}
	}
	
	/**
	 * for loop + for loop形式,和for loop + while loop稍有不同
	 * @param arr
	 */
	public static void insertSort20200614(int[] arr){
		if(null==arr){
			return;
		}
		for(int i=1;i<arr.length;i++){
			int tmp = arr[i];
			int j = i - 1;
			while(j>=0&&arr[j]>tmp){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = tmp;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
