package com.youyanpai.algorithm.leetcode;

public class TwoAdd {
	
	private static int[] a = {2, 4, 3};
	private static int[] b = {5, 6, 4};
	
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
					sb.append(result);
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
