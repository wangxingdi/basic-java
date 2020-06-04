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
		int[] a = quick_sort(SortConstant.ARR1, 0, SortConstant.ARR1.length - 1);
		System.out.println(a);
	}
	
	static int[] quick_sort(int[] s, int l, int r){
	    if (l < r){
	        int i = l, j = r, x = s[l];
	        while (i < j){
	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
					j--;  
	            if(i < j) 
					s[i++] = s[j];
				
	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
					i++;  
	            if(i < j) 
					s[j--] = s[i];
	        }
	        s[i] = x;
	        quick_sort(s, l, i - 1); // 递归调用 
	        quick_sort(s, i + 1, r);
	    }
	    return s;
	}

}
