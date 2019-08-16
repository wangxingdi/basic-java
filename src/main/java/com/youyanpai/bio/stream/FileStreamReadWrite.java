package com.youyanpai.bio.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class FileStreamReadWrite {

	/**
	 * 读取一个文件,并将内容写入到另一个文件中;
	 * 读写结束后,使用notepad++查看时发现内容出现NUL内容,怀疑是空格;
	 * 当bytes设置为1024后,输出文件中会出现多余的内容.->解决方法:使用write(byte[] b, int off, int len)来处理
	 * @param args
	 * @throws IOException
	 * @date 2019-04-08
	 */
	public static void main(String[] args) throws IOException {
		String inFile = "D:\\IDE/eclipse_mars/workspace/git/basic-of-java/basic-of-java/src/com/youyanpai/io/stream/FileStreamReadWrite.java";
		String outFile = "E:\\out.txt";
		InputStream in = new FileInputStream(inFile);
		OutputStream out = new FileOutputStream(outFile);
		byte[] bytes = new byte[512];
		int i = -1;
		while((i = in.read(bytes)) != -1){
			out.write(bytes, 0, i);
		}
		out.write(("当前系统时间:"+new Date()).toString().getBytes());
		out.close();
		in.close();
		System.out.println("===读写结束===");
	}
}
