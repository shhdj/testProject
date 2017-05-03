package com.estproject.service.goods.thead;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 线程回调结果
 * @author  YZH
 * @version 1.0
 * @param <R>
 * @date 2016年4月13日
 */
public final class CallResult<R> {
   private FutureTask<R> _futureTask= null;
   public CallResult(FutureTask<R> futureTask){
	   this._futureTask = futureTask;
   }
   public R getResult() throws InterruptedException, ExecutionException{
	   return _futureTask.get();
   }
   
   public R getResult(long timeout,TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException{
	   return _futureTask.get(timeout, unit);
   }
   
   public boolean isCancelled(){
	   return _futureTask.isCancelled();
   }
   
   public boolean isDone(){
	   return _futureTask.isDone();
   }
}
