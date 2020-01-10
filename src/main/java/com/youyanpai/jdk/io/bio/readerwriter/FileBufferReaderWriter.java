package com.youyanpai.jdk.io.bio.readerwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 1. BufferedReader的readLine()是阻塞式的,如果到达流末尾,返回null;
 * 2. Socket通信不太适合readLine(),因为在使用readLine()时,线程会一直阻塞寻找"回车""换行"符;
 * 
 * @author wangxd
 */
public class FileBufferReaderWriter {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		String inFile = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileBufferReaderWriter.java";
		String outFile = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileBufferReaderWriterCopy.txt";
		String s = "";
		try (InputStream in = new FileInputStream(inFile);
				InputStreamReader inputStreamReader = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(inputStreamReader)) {
			while ((s = reader.readLine()) != null) {
				try(OutputStream out = new FileOutputStream(outFile, true);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
				BufferedWriter writer = new BufferedWriter(outputStreamWriter)){
					writer.write(s);
					writer.newLine();
				} catch (Exception e){
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		long end = System.currentTimeMillis();
		System.out.println("===读写结束：共耗时(ms)：" + (end - start));
	}

}
