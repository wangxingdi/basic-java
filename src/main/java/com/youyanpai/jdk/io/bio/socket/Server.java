package com.youyanpai.jdk.io.bio.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ServerSocket
 * @author wangxd
 */
public class Server {
	
	public static final int PORT = 8888;

	public static void main(String[] args) throws IOException {
		startServer();
	}
	
	public static void startServer() throws IOException{
		//创建线程池
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
		//创建服务端
		ServerSocket server = new ServerSocket(PORT);
		server.setReceiveBufferSize(1024);
		System.out.println("启动了一个ServerSocket: "+server.getInetAddress().getLocalHost());
		Socket client = server.accept();
		System.out.println("客户端: "+client.getInetAddress().getLocalHost()+" 已经连接到服务器");
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println("收到客户端信息: "+reader.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        bw.write("收到客户端消息，同时返回一条消息");
        bw.flush();
//		pool.execute(new ReaderHandle(client));

	}
	
	static class ReaderHandle implements Runnable {
		public Socket socket;
		public ReaderHandle(Socket socket){
			this.socket = socket;
		}

		@Override
		public void run() {
			System.out.println("等待客户端接入…………");
			byte[] bytes = new byte[1024];
			int length = 0;
			try(BufferedInputStream buff = new BufferedInputStream(socket.getInputStream());){
				while((length=buff.read(bytes, 0, length))!=-1){
					System.out.println(bytes);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	

}
