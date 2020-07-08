package com.youyanpai.jdk.io.bio.readerwriter;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 
 * @author wangxd
 */
public class FileReaderWriter {

	public static void main(String[] args) {
		test2();
	}
	
	public static void test1(){
		String inPath = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileReaderWriter.java";
		String outPath = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileReaderWriterCopy.txt";
		try(FileReader reader = new FileReader(inPath);
				FileWriter writer = new FileWriter(outPath);){
			char[] cbuf = new char[512];
			int length = 0;
			while(-1!=(length=reader.read(cbuf))){
				writer.write(cbuf, 0, length);
			}
			writer.close();
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("test1执行完成");
	}
	
	/**
	 * FileWriter(in, boolean)的第二个参数,表示的是本次写IO的模式，而不是每次写入都是追加
	 */
	public static void test2(){
		String inPath = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileReaderWriter.java";
		String outPath = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileReaderWriterCopy.txt";
		try(FileReader reader = new FileReader(inPath);
				FileWriter writer = new FileWriter(outPath, true);){
			char[] cbuf = new char[2];
			int length = 0;
			while(-1!=(length=reader.read(cbuf))){
				writer.write(cbuf, 0, length);
			}
			writer.write("哈哈哈哈");
			writer.write("呵呵呵呵");
			writer.close();
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("test2执行完成");
	}
	
	/**
	 * reader.read()会一个字符一个字符的读数据,返回值就是读取到的数据(int强转为char)
	 * reader.read(cbuf)会将字符先读取到cbuf中
	 */
	public static void test3(){
		String inPath = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileReaderWriter.java";
		try(FileReader reader = new FileReader(inPath)){
			int read = 0;
			char[] cbuf = new char[64];
			while((read = reader.read(cbuf))!=-1){
				System.out.print(cbuf);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
