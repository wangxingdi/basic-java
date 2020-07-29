package com.youyanpai.jdk.io.bio.readerwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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
public class BufferedReaderWriter {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		String inFile = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/BufferedReaderWriter.java";
		String outFile = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/BufferedReaderWriterCopy.txt";
		String s = "";
		char[] buffer = new char[1024];
		int length = 0;
//		FileReader fr = new FileReader(inFile);
//		BufferedReader brr = new BufferedReader(fr);
		try (InputStream is = new FileInputStream(inFile);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr)){
			//使用read()
			/*while (-1 != (length = br.read(buffer))) {
				try(OutputStream os = new FileOutputStream(outFile, true);
						OutputStreamWriter osw = new OutputStreamWriter(os);
						BufferedWriter bw = new BufferedWriter(osw)) {
					bw.write(buffer, 0, length);
				} catch (Exception e) {
					System.out.println("writer构建流失败");
				}
			}*/
			//使用readLine()
			while (null != (s=br.readLine())) {
				try(OutputStream os = new FileOutputStream(outFile, true);
						OutputStreamWriter osw = new OutputStreamWriter(os);
						BufferedWriter bw = new BufferedWriter(osw)){
					bw.write(s, 0, s.length());
					bw.newLine();
				}catch (Exception e) {
					System.out.println("writer构建流失败");
				}
			}
		} catch (Exception e) {
			System.out.println("reader流构建失败");
		}
		long end = System.currentTimeMillis();
		System.out.println("===读写结束：共耗时(ms)：" + (end - start));
	}

}
