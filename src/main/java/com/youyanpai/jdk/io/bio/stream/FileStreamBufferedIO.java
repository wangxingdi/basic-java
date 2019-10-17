package com.youyanpai.jdk.io.bio.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * 
 * @author wangxd
 */
public class FileStreamBufferedIO {
	
	public static void main(String[] args) throws IOException {
		String inFile = "D:\\IDE/eclipse_mars/workspace/git/basic-of-java/basic-of-java/src/com/youyanpai/io/stream/FileStreamBufferReadWrite.java";
		String outFile = "E:\\out.txt";
		InputStream is = new FileInputStream(inFile);
		OutputStream os = new FileOutputStream(outFile);
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		byte[] bytes = new byte[16];
		int i = -1;
		while((i=bis.read(bytes, 0, bytes.length)) != -1){
			System.out.println("本次buffer读取的数据长度:"+i);
			bos.write(bytes, 0, i);
		}
		bos.write(("当前系统时间:"+new Date().toString()).getBytes());
		bis.close();
		bos.close();
		is.close();
		os.close();
		System.out.println("===读写结束===");
	}

}
