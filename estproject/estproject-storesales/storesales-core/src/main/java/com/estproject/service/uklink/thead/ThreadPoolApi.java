package com.estproject.service.uklink.thead;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.etong.framework.util.thread.iface.ICall;
import com.etong.framework.util.thread.iface.IRun;

/***
 * 线程调用Api
 * 
 * @author YZH
 * @version 1.0
 * @date 2016年4月13日
 */
public final class ThreadPoolApi {
	private static final ThreadPoolApi _api = new ThreadPoolApi();

	private ThreadPoolApi() {
	}

	public static ThreadPoolApi getInstance() {
		return _api;
	}

	/***
	 * 执行线程：有回调结果
	 * 
	 * @param call
	 */
	public <R> CallResult<R> execute(ICall<R> call) {
		FutureTask<R> futureTask = new FutureTask<R>(new CallTask<R>(call));
		this.getThreadPoolTaskExecutor().execute(futureTask);
		return new CallResult<R>(futureTask);
	}

	/**
	 * 执行线程无回调结果
	 * 
	 * @param run
	 */
	public void execute(final IRun run) {
		this.getThreadPoolExecutor().execute(new Runnable() {
			@Override
			public synchronized void run() {
				run.execute();
				
			}
		});
	}
	
	/***
	 * 获取ThreadPoolTaskExecutor
	 * @return
	 */
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
    	return ThreadPoolExecutorInit.getInstance().getThreadPoolTaskExecutor();
    }
	
	/***
	 * 获取ThreadPoolExecutor
	 * @return
	 */
	public ThreadPoolExecutor getThreadPoolExecutor(){
		return this.getThreadPoolTaskExecutor().getThreadPoolExecutor();
	}
	
	

}
