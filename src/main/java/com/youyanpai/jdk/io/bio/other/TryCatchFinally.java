package com.youyanpai.jdk.io.bio.other;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangxd
 */
public class TryCatchFinally {

	public static void main(String[] args) throws IOException {
		System.out.println("===the method is begin running===");
		String inFile = "D:\\IDE/eclipse_mars/workspace/git/basic-of-java/basic-of-java/src/com/youyanpai/io/other/TryCatchFinally.java";
		InputStream in = null;
		try {
			in = new FileInputStream(inFile);
			//每次会读取一个字节,并将读取到的数据以0-255范围内的int类型返回;如果流结束,则返回-1
			int read = in.read();
			while(read != -1){
				System.out.print((char)read);
				read = in.read();
			}
		} catch (Exception e) {
			System.out.println("===the method catch exception===");
			if(null!=in){
				in.close();
			}
		} finally {
			System.out.println("===the method finally finished===");
			if(null!=in){
				in.close();
			}
		}

	}

}
