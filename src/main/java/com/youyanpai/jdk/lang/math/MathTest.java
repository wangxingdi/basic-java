package com.youyanpai.jdk.lang.math;

public class MathTest {

	public static void main(String[] args) {
		// 自然对数底数,2.718281828459045
		System.out.println("Math.E=" + Math.E);
		// 圆周率,3.141592653589793
		System.out.println("Math.PI=" + Math.PI);
		// 二进制,八进制,十进制,十六进制
		System.out.println("0b1111=" + 0b1111 + ",0111=" + 0111 + ",0xffff=" + 0xffff);
		// 10的次幂
		System.out.println("2e1=" + 2e1);
		// 无穷
		System.out.println((Float.NEGATIVE_INFINITY * 0) + "," + (Float.POSITIVE_INFINITY / 0) + ","
				+ (Float.NEGATIVE_INFINITY + 10) + "," + (Float.NEGATIVE_INFINITY - 10) + ","
				+ (Float.NEGATIVE_INFINITY * 10) + "," + (Float.NEGATIVE_INFINITY / 10) + ","
				+ Double.isInfinite(0.25f));
		// NaN
		System.out.println(Float.isNaN(Float.NaN) + "," + (Float.NaN + 0));
		// 参数和下一个数据的间距
		System.out.println(Math.ulp(100));
		// 参数的符号函数
		System.out.println(Math.signum(5) + "," + Math.signum(-5) + "," + Math.signum(-0) + "," + Math.signum(0) + ","
				+ Math.signum(Float.NaN) + "," + Math.signum(Float.POSITIVE_INFINITY) + ","
				+ Math.signum(Float.NEGATIVE_INFINITY));
	}

}
