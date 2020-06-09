package com.youyanpai;

public class T2 {

	public static void main(String[] args) {
		System.out.println(climbStairs1(10));
		System.out.println(climbStairs2(10));
		System.out.println(climbStairs3(10));
	}
	
	public static int climbStairs1(int n) {
		if(0==n||1==n){
			return 1;
		}
		return climbStairs1(n-1) + climbStairs1(n-2);
    }
	
	public static int climbStairs2(int n){
		return climb_Stairs(0, n);
	}
	
	public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
	
	public static int climbStairs3(int n){
		int n1 = 1;
		int n2 = 2;
		int tmp = 0;
		for(int i=3;i<=n;i++){
			tmp = n2;
			n2 = n1 + n2;
			n1 = tmp;
		}
		return n2;
	}

}
