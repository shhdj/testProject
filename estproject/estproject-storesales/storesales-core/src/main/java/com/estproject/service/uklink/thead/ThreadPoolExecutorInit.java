package com.estproject.service.uklink.thead;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.etong.framework.util.SpringContextUtils;


/***
 * 线程池加载
 * 
 * @author YZH
 * @version 1.0
 * @date 2016年4月13日
 */
final class ThreadPoolExecutorInit {
	//private static final String _BEAN_NAME = "threadPoolTaskExecutor";
	private static final ThreadPoolExecutorInit _init = new ThreadPoolExecutorInit();
	/**
	 * ThreadPoolTaskExecutor对象
	 */
	private ThreadPoolTaskExecutor _threadPoolTaskExecutor;
	/***
	 * 构造器
	 */
	private ThreadPoolExecutorInit() {
		//if( null == _threadPoolTaskExecutor ){
			//if( SpringContextUtils.getApplicationContext().containsBean(_BEAN_NAME) ){
			   //_threadPoolTaskExecutor = SpringContextUtils.getBean(ThreadPoolTaskExecutor.class);
			//}
		//}
	}
	
	/**
	 * 获取this
	 * @return
	 */
	public static ThreadPoolExecutorInit getInstance(){
		return _init;
	}
	
	/***
	 * 获取threadPoolTaskExecutor
	 * @return
	 */
	public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
		if( null == _threadPoolTaskExecutor ){
			//throw new NullPointerException("not find the bean [threadPoolTaskExecutor] in this project!");
			_threadPoolTaskExecutor = SpringContextUtils.getBean(ThreadPoolTaskExecutor.class);
		}
		return _threadPoolTaskExecutor;
	}
	
	/***
	 * 获取threadPoolExecutor
	 * @return
	 */
	public ThreadPoolExecutor getThreadPoolExecutor(){
		return getThreadPoolTaskExecutor().getThreadPoolExecutor();
	}
	
	
	

}
