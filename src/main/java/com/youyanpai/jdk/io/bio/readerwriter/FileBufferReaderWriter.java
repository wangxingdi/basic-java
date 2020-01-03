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
import java.io.Reader;
import java.io.Writer;
import java.util.Date;

/**
 * 1. BufferedReader的readLine()是阻塞式的,如果到达流末尾,返回null;
 * 2. 
 * @author wangxd
 */
public class FileBufferReaderWriter {

	public static void main(String[] args) throws IOException {
		String inFile = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileBufferReaderWriter.java";
		String outFile = "src/main/java/com/youyanpai/jdk/io/bio/readerwriter/FileBufferReaderWriterCopy.txt";
		InputStream in = new FileInputStream(inFile);
		Reader r = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(r);
		OutputStream out = new FileOutputStream(outFile);
		Writer w = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(w);
		String str = null;
		while((str = br.readLine()) != null){
			bw.write(str);
			//回车换行
			bw.newLine();
		}
		bw.write("系统当前时间:"+new Date().toString());
		br.close();
		r.close();
		in.close();
		bw.close();
		w.close();
		out.close();
		System.out.println("===读写结束===");
	}

}
