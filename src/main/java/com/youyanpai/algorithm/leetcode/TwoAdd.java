package com.youyanpai.algorithm.leetcode;

/**
 * 两数相加
 * =========================================================
 * 给出两个非空的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照“逆序”的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字0之外，这两个数都不会以0开头。
 * =========================================================
 * @author wangxd
 */
public class TwoAdd {
	
	private static int[] a = {0};
	private static int[] b = {0};
	
	public static void main(String[] args) throws Exception {
		Math.abs(10);
		System.out.println(arrPlus(a, b));
	}
	
	public static int getNum(int param, int index){
		return 1;
	}
	
	public static String arrPlus(int[] a, int[] b) throws Exception {
		if (null==a || null==b) {
			throw new Exception();
		} else if(a.length != b.length) {
			throw new Exception();
		} else {
			StringBuffer sb = new StringBuffer();
			int plus = 0;
			for (int i=0;i<a.length;i++) {
				int result = a[i] + b[i] + plus;
				if (i == a.length-1){
					if (result < 10) {
						sb.append(result);
					} else {
						sb.append(result % 10);
						sb.append(result /10);
					}
				} else if(10 <= result) {
					plus = result / 10;
					sb.append(result % 10);
				} else {
					plus = 0;
					sb.append(result % 10);
				}
			}
			return sb.toString();
		}
	}

}
