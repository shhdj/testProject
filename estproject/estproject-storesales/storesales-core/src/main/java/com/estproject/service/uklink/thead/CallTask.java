package com.estproject.service.uklink.thead;

import java.io.Serializable;
import java.util.concurrent.Callable;

/***
 * 任务处理
 * @author  YZH
 * @version 1.0
 * @date 2016年4月13日
 */
public class CallTask<R> implements Callable<R>,Serializable {
	private static final long serialVersionUID = 998623003796076772L;
	private ICall<R> _call = null;
	public CallTask(ICall<R> call){
		this._call = call;
	}


	public R call() throws Exception {
		return _call.execute();
	}

}
