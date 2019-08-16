package com.youyanpai.bio.other;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 1. try语句块运行结束时,流会被自动关闭.这是因为流实现了AutoCloseable接口.
 * 2. 当发生异常时,流也会被自动关闭.
 * @author wangxd
 */
public class TryWithResource {

	public static void main(String[] args) {
		System.out.println("===the method is begin running===");
		String inFile = "D:\\IDE/eclipse_mars/workspace/git/basic-of-java/basic-of-java/src/com/youyanpai/io/other/TryWithResource.java";
		try(InputStream in = new FileInputStream(inFile)){
			//每次读取多个字节,如果被读取的数据长度不足以填充整个bytes,则只会覆盖前半部分.
			byte[] bytes = new byte[512];
			int i = -1;
			while((i = in.read(bytes)) != -1){
				for(int m = 0;m<i;m++){
					System.out.print((char)bytes[m]);
				}
			}
		} catch (Exception e) {
			System.out.println("===the method catch exception===");
		}
	}

}
