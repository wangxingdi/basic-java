package com.daiyuma.jdk.io.bio.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 该类为了测试Stream相关的方法的具体用法
 * @author wangxd
 */
public class Methods {

	public static void main(String[] args) {
		String file = "src/main/java/com/youyanpai/jdk/io/bio/stream/Methods.java";
		//1
		try(InputStream is1 = new FileInputStream(file)){
			System.out.println(is1.available());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//2
		InputStream is2 = null;
		try{
			is2 = new FileInputStream(file);
			System.out.println(is2.available());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=is2){
				try {
					is2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//3
		try(InputStream is3 = new FileInputStream(file);
				BufferedInputStream bis3 = new BufferedInputStream(is3)){
			bis3.mark(1);
			int a = bis3.read();
			System.out.println("3:"+a);
			bis3.read(new byte[102]);
			int b = bis3.read();
			bis3.reset();
			System.out.println("3:"+b);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
