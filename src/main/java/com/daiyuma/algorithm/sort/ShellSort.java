package com.daiyuma.algorithm.sort;

/**
 * 希尔排序
 * 直接插入排序的升级版
 * @author wangxd
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {1,5,9,2,46,35,16};
		shellSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+", ");
		}
		System.out.println("");
		int[] arr20200609 = {1,5,9,2,46,35,16};
		shellSort20200609(arr20200609);
		for(int i=0;i<arr20200609.length;i++){
			System.out.print(arr20200609[i]+", ");
		}
		System.out.println("");
		int[] arr20200614 = {1,5,9,2,46,35,16};
		shellSort20200614(arr20200614);
		for(int i=0;i<arr20200614.length;i++){
			System.out.print(arr20200614[i]+", ");
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
	
	/**
	 * 希尔排序
	 * 获取gap,gap归1,for遍历
	 * @param arr
	 */
	public static void shellSort20200609(int[] arr){
		int gap = arr.length/2;
		while(gap>1){
			gap /= 2;
			for(int i=gap;i<arr.length-1;i++){
				insertSort20200609(arr, gap, i);
			}
		}
	}
	
	public static void insertSort20200609(int[] arr, int gap, int i){
		int tmp = arr[i];
		int j = i - gap;
		while(j>0&&arr[j]>tmp){
			arr[j+gap] = arr[j];
			j-=gap;
		}
		arr[j+gap] = tmp;
	}
	
	public static void shellSort20200614(int[] arr){
		for(int gap=arr.length/2;gap>0;gap/=2){
			for(int i=gap;i<arr.length-1;i++){
				insertSort20200614(arr, gap, i);
			}
		}
	}

	private static void insertSort20200614(int[] arr, int gap, int i) {
		if(null==arr){
			return;
		}
		int tmp = arr[i];
		int j = i - gap; 
		while(j>=0&&arr[j]>tmp){
			arr[j+gap] = arr[j];
			j-=gap;
		}
		arr[j+gap] = tmp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
