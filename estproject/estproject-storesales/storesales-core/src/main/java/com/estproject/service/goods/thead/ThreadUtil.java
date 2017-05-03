package com.estproject.service.goods.thead;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/***
 * 线程执行工具
 * @author  YZH
 * @version 1.0
 * @date 2016年4月13日
 */
public final class ThreadUtil {
   private ThreadUtil(){}
   
   /***
    * 获取API对象
    * @return
    */
   private static ThreadPoolApi getApi(){
	   return ThreadPoolApi.getInstance();
   }
   
   /***
    * 执行线程：有回调结果
    * @param call
    */
   public static <R> CallResult<R> execute(ICall<R> call){
	   return getApi().execute(call);
   }
   
   /**
    * 执行线程无回调结果
    * @param run
    */
   public static void execute(IRun run){
	   getApi().execute(run);
   }
   
   /***
	 * 获取ThreadPoolTaskExecutor
	 * @return
	 */
   public static ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
   		return getApi().getThreadPoolTaskExecutor();
   }
	
	/***
	 * 获取ThreadPoolExecutor
	 * @return
	 */
	public static ThreadPoolExecutor getThreadPoolExecutor(){
		return getThreadPoolTaskExecutor().getThreadPoolExecutor();
	}
   
   /***
	 * 获取ActiveCount
	 * @return
	 */
	public static int getActiveCount(){
		return getApi().getThreadPoolTaskExecutor().getActiveCount();
	}
	
	/***
	 * 获取CorePoolSize
	 * @return
	 */
	public static int getCorePoolSize(){
		return getApi().getThreadPoolTaskExecutor().getCorePoolSize();
	}
	
	/***
	 * 获取KeepAliveSeconds
	 * @return
	 */
	public static int getKeepAliveSeconds(){
		return getApi().getThreadPoolTaskExecutor().getKeepAliveSeconds();
	}
	
	/***
	 * 获取MaxPoolSize
	 * @return
	 */
	public static int getMaxPoolSize(){
		return getApi().getThreadPoolTaskExecutor().getMaxPoolSize();
	}
	
	/***
	 * PoolSize
	 * @return
	 */
	public static int getPoolSize(){
		return getApi().getThreadPoolTaskExecutor().getPoolSize();
	}
}
