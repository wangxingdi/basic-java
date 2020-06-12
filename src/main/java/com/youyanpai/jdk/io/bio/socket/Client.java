package com.youyanpai.jdk.io.bio.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try(Socket client = new Socket("127.0.0.1", Server.PORT);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))){
			writer.write("我是一条客户端发出的消息");
			writer.flush();
			System.out.println("收到服务器返回的消息: "+reader.readLine());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
