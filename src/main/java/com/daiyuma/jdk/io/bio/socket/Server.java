package com.daiyuma.jdk.io.bio.socket;

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
 * ServerSocket服务端
 * @author wangxd
 */
public class Server {

	public static final int PORT = 55000;

	public static void main(String[] args) throws IOException, InterruptedException {
		startThreadPoolServer();
	}

	/**
	 * 开启服务端
	 * 没有使用线程池的方式
	 * 1. readLine()会阻塞性的寻找"回车"和"换行"符,所以谨慎使用
	 */
	public static void startServer() {
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("启动服务器....");
			Socket client = null;
			while ((client = server.accept()) != null) {
				System.out.println("客户端:" + client.getInetAddress().getLocalHost() + "已连接到服务器");
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				// 读取客户端发送来的消息
				String mess = br.readLine();
				System.out.println("客户端发来的消息：" + mess);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				bw.write("客户端你好\n");
				bw.flush();
			}
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 开启服务端
	 * 使用线程池的方式
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void startThreadPoolServer() throws IOException, InterruptedException {
		// 创建线程池
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
		// 创建服务端
		ServerSocket server = new ServerSocket(PORT);
		server.setReceiveBufferSize(1024);
		Socket client = null;
		System.out.println("启动了一个ServerSocket");
		while ((client = server.accept())!=null) {
			Thread.currentThread().sleep(3000);
			System.out.println("与客户端连接成功！");
			pool.execute(new ReaderHandle(client));
		}
		server.close();
	}

	static class ReaderHandle implements Runnable {
		private Socket socket = null;
		public ReaderHandle(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
				String s = reader.readLine();
				System.out.println("当前线程ID: "+ Thread.currentThread().getId());
				System.out.println("收到客户端信息: " + s);
				writer.write("返回消息: "+ s + "\n");
				writer.flush();
			} catch (Exception e) {
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
