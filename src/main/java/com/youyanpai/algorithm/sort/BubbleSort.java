/**
 * from www.youyanpai.com
 */
package com.youyanpai.algorithm.sort;

/**
 * 冒泡排序
 * ========================================================================
 * 升序冒泡：
 * 对于数据集中的数据，从第一个开始，依次和相邻的后一个数据进行比较。如果前者大于后者，
 * 则将两者的位置交换，直到倒数第二个数据和倒数第一个数据比较完成，则第一次冒泡完成。
 * 此时，最后一个数据应该是整个数据集中最大的数据；
 * 紧接重复上述步骤，由于最后一个数据已经被确认是最大的一个数据，所以不需要再次比较。
 * 故而直到倒数第三个数据和倒数第二个数据比较完成，则第二次冒泡完成。
 * 此时，倒数第二个数据不小于除最后一个数据外的任何一个数据；
 * 这样，依次循环，直到将第一个数据和第二个数据的顺序排好，则整个数据集排序完成。
 * ========================================================================
 * @author wangxd
 */
public class BubbleSort {
	
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {7, 2, 1, 9, 6, 29, 74, 31, 124, 25, 35, 54, 85, 2, 24, 35, 68, 84, 51, 24, 67, 98, 189};
		int[] returnArr = simpleSort(arr, SortConstant.AES);
		for(int i=0;i<returnArr.length;i++){
			System.out.print(returnArr[i]+", ");
		}
	}
	
	/**
	 * 简单的冒泡排序算法
	 * @param arr 待排序数组
	 * @param order 排序方向
	 *         |- AES: 升序
	 *         |- DES: 降序
	 * @return 排序后数组
	 */
	public static int[] simpleSort(int[] arr, String order){
		//第一层循环,目的是为了限制一个段区间
		for(int i=arr.length-1;i>1;i--){
			//第二层循环,目的是为了在限制的区间内,相邻两个元素逐个比较
			for(int j=0;j<i;j++){
				switch (order) {
				case SortConstant.AES:
					if(arr[j] > arr[j+1]){
						int x = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = x;
					}
					break;
				case SortConstant.DES:
					if(arr[j] < arr[j+1]){
						int x = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = x;
					}
					break;
				default:
					break;
				}
			}
		}
		return arr;
	}

}
