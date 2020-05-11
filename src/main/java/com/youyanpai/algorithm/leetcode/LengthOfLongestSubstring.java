package com.youyanpai.algorithm.leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * 找出给定的字符串中,不含重复字符的最长子串以的长度
 * 错误1: break没有加;
 * 错误2: abcdefd时,第二次大循环直接结束了
 * @author wangxd
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		
		String target = "abcdefd2345678";
		System.out.println(getLengthOfLongestSubstring(target));
	}
	
	public static int getLengthOfLongestSubstring(String target) {
		int max = 0;
		if (StringUtils.isNotBlank(target)) {
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<target.length()-1;i++) {
				System.out.println("================循环====");
				char begin = target.charAt(i);
				sb.append(begin);
				for (int j=i+1;j<target.length();j++) {
					char end = target.charAt(j);
					//重复出现的位置
					int index = sb.indexOf(String.valueOf(end));
					if (index == -1) {
						//error2
						if (j == target.length() -1) {
							if (sb.length() > max) {
								return sb.length() + 1;
							} else {
								return max;
							}
						} else {
							sb.append(end);
						}
					} else {
						if (sb.length() > max) {
							max = sb.length();
						}
						i = index;
						sb.delete(0, sb.length());
						//error1
						break;
					}
				}
			}
		}
		return max;
	}

}
