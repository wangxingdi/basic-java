package com.youyanpai.jdk.util.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列api
 * @author wangxd
 */
public class QueueApi {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		//超出抛异常
		q.add(2);
		//超出返回false
		q.offer(3);
		//空队列抛异常
		System.out.println(q.element());
		//空队列返回null
		System.out.println(q.peek());
		//空队列抛异常
		System.out.println(q.remove());
		//空队列返回null
		System.out.println(q.poll());
		System.out.println(q);
                //这里将会发生代码冲突
	}

}
