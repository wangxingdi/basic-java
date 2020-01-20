package com.youyanpai.jdk.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NewThreadPoolExecutor {
	
	/**
	 * @param int corePoolSize,
     * @param int maximumPoolSize,
     * @param long keepAliveTime,
     * @param TimeUnit unit,
     * @param BlockingQueue<Runnable> workQueue,
     * @param ThreadFactory threadFactory,
     * @param RejectedExecutionHandler handler
	 */
	ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), arg5, arg6);

}
