package com.daiyuma.jdk.io.bio.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			for(int i=0;i<100;i++){
		         Socket s = new Socket("127.0.0.1",8888);
		         //构建IO
		         InputStream is = s.getInputStream();
		         OutputStream os = s.getOutputStream();
		         
		         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		         //向服务器端发送消息
	        	 bw.write("服务端你好"+ i +"\n");
		         bw.flush();
		         //读取服务器返回的消息
		         BufferedReader br = new BufferedReader(new InputStreamReader(is));
		         String mess = br.readLine();
		         System.out.println("服务器返回的消息："+mess);
		         s.close();
	         }
	      } catch (UnknownHostException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}

}
