package com.daiyuma.basic.threadpool.java;

public class PrimitiveThread {

	public static void main(String[] args) {
		for(int i=0;i<50;i++){
			final int index = i;
//			try {
//	        	Thread.sleep(index * 5);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(index);
				}
			}).start();
		}
	}

}
